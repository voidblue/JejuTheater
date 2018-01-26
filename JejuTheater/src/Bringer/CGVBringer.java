package Bringer;

import Crawlers.JsoupCralwer;
import Crawlers.SeleniumCrawler;
import Interface.Bring;
import Interface.Crawl;
import Parsers.JsoupParser;
import TheaterData.Movies;
import TheaterData.Schedules;
import Utils.Crawler;
import Utils.Parser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CGVBringer implements Bring {
    private Crawler crawler;
    private Parser parser;
    public final String JEJU = "0121";
    public final String JEJU_NOHYENG = "0259";

    public CGVBringer()
    {
        this.crawler = Crawler.getInstance();
        this.parser = Parser.getInstance(new JsoupParser());
    }

    @Override
    public ArrayList<ArrayList> bring() {
        ArrayList<ArrayList> lists = new ArrayList<>();

        lists.add(getMovies());
        lists.add(getSchedules(JEJU));
        lists.add(getSchedules(JEJU_NOHYENG));

        return lists;
    }

    private ArrayList<ArrayList> getSchedules(String theater)
    {
        System.out.println("Schedule 받는 중 ... ");
        ArrayList<ArrayList> alldaySchedules = new ArrayList<ArrayList>();
        String theater_name = getTheaterName(theater);
        int repetitions = 0;

        // 날짜 개수만큼 반복
        while(true) {
            ArrayList<Schedules> onedaySchedules = new ArrayList<Schedules>();

            String date = getDate(repetitions++);
            String url = "" +
                    "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=206,04,06&theatercode="
                    + theater + "&date=" + date;
            String html = crawler.crawl(new JsoupCralwer(), url);

            String date_set = parse(html, ".day a[title=\"현재 선택\"]");
            String month, day, day_of_week;

            month = parseToText(date_set, "span");
            day = parseToText(date_set, "strong");
            day_of_week = parseToText(date_set, "em");

            if (!isEqualDate(date, month, day)) break;

            // 영화 개수만큼 반복
            String target;
            ArrayList schedule_set = parseToList(html, ".sect-showtimes ul li .col-times");
            for (int count_movie = 0; count_movie < schedule_set.size(); count_movie++) {
                target = getTarget(schedule_set, count_movie);
                String movie_id = parser.getAttr(target, ".info-movie a", "href");
                movie_id = movie_id.substring(movie_id.length()-5);;
                String movie_titie = parseToText(target, ".info-movie a strong");
                ArrayList screen_set = parseToList(target, ".col-times .type-hall");

                // 상영관 수만큼 반복
                for (int count_screen = 0; count_screen < screen_set.size(); count_screen++) {
                    target = getTarget(screen_set, count_screen);
                    String screen_number = parseToText(target, ".info-hall ul li:nth-child(2)");
                    screen_number = screen_number.substring(0,1);
                    String theaterName = "CGV"+theater_name + screen_number;
                    ArrayList time_set = parseToList(target,".type-hall div:nth-child(2) ul li");

                    // 상영시간 수만큼 반복
                    for (int count_showtime = 0; count_showtime < time_set.size(); count_showtime++) {
                        target = getTarget(time_set, count_showtime);
                        String show_time = parseToText(target, "em");

                        SimpleDateFormat timeParser = new SimpleDateFormat("hh:mm");
                        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
                        Date tempDate = null;
                        Date tempTime = null;
                        try {
                            tempDate = dateParser.parse(date);
                            tempTime = timeParser.parse(show_time);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        if (Integer.parseInt(date.substring(6,8)) >= 24){
                            tempDate.setDate(tempDate.getDate() + 1);
                        }
                        String time = (tempDate.getYear()+1900) +"-" + (tempDate.getMonth()+1) + "-" + tempDate.getDate()+ " " +
                                    tempTime.getHours() + ":" + tempTime.getMinutes();


                        String seat_left = parseToText(target, "span:not(.hidden)");

                        if(seat_left.equals("마감")){
                            seat_left = "0";
                        }else if (seat_left.substring(0,3).equals("준비중")){
                            seat_left = "NULL";
                        }else{
                            seat_left = seat_left.substring(4,6);
                        }
                        // ArrayList에 add (-> onedaySchedules)
                        onedaySchedules.add(new Schedules(theaterName, time, seat_left, movie_id, "CGV"));
                    }
                }
            }
            // ArrayList에 add (-> alldaySchedules)
            alldaySchedules.add(onedaySchedules);
        }

        return alldaySchedules;
    }

    private ArrayList<Movies> getMovies()
    {
        System.out.println("Movie 받는 중 ... ");
        ArrayList<Movies> movies = new ArrayList<Movies>();

        String html = crawler.crawl(new SeleniumCrawler((driver) ->{
            WebElement moreList = driver.findElement(By.className("btn-more-fontbold"));
            moreList.click();
            return driver;
        }), "http://www.cgv.co.kr/movies/?lt=1&ft=0");

        String[] ids = getIds(html);

        // id 개수만큼 반복
        for (int i = 0; i < ids.length; i++) {
            String result, str;
            String[] str_array;

            String url_pro = "http://www.cgv.co.kr/movies/detail-view/?midx=";
            String html_movie = crawler.crawl(new JsoupCralwer(), url_pro + ids[i]);

            String title = parseToText(html_movie, ".title strong");
            String title_en = parseToText(html_movie, ".title p");

            result = parseToText(html_movie, ".spec dt");
            str = result.split("장르 :")[1];
            String genre;
            try{
                genre = str.split(" /")[0].substring(1);
            } catch (Exception e)
            {
                genre = str.split(" /")[0];
            }

            result = parseToText(html_movie, ".sect-story-movie");
            String storyline = result.replace("'" , "\\\'");

            result = parseToText(html_movie, ".spec .on");
            str_array = result.split(" ");
            String release_date = str_array[str_array.length-1];

            result = parseToText(html_movie, ".spec");
            str = result.split("기본 : ")[1];
            String age_limit = str.split(",")[0];
            String running_time = str.split(",")[1].substring(1,4);

            String score = parseToText(html_movie, ".egg-gage:first-of-type .percent");

            String ticket_sales = parseToText(html_movie, ".score .percent span:not(.percent)");

            // ' 처리
            title = changeQuote(title);
            title_en = changeQuote(title_en);
            storyline = changeQuote(storyline);

            // ArrayList에 add
            movies.add(new Movies(ids[i], "CGV", title, title_en, genre, storyline, release_date, age_limit, score, ticket_sales, running_time));
        }
        return movies;
    }


    private String changeQuote(String str)
    {
        if (str.contains("'")) str = str.replace("'", "’");

        return str;
    }

    private String parseToText(String html, String tag)
    {
        return parser.parseToText(html, tag);
    }

    private String parse(String html, String tag)
    {
        return parser.parse(html, tag);
    }

    private ArrayList parseToList(String html, String tag)
    {
        return parser.parseToList(html, tag);
    }

    private String getTarget(ArrayList list, int count)
    {
        return list.get(count).toString();
    }

    private String[] getIds(String html)
    {
        Parser parser = Parser.getInstance(new JsoupParser());
        ArrayList movielist = parser.parseToList(html, ".sect-movie-chart .box-contents a:not(.link-reservation)");
        String[] ids = new String[movielist.size()];

        for (int i = 0; i < movielist.size(); i++)
        {
            String str = movielist.get(i).toString();
            String href = parser.getAttr(str, "a", "href");
            ids[i] = href.substring(href.length()-5);
        }

        return ids;
    }

    private String getDate(int repetitions)
    {
        Calendar c1 = new GregorianCalendar();
        c1.add(Calendar.DATE, repetitions);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷
        String date = sdf.format(c1.getTime()); // String으로 저장

        return date;
    }

    private boolean isEqualDate(String date, String month, String day)
    {
        String input_date = date.substring(4);
        String schedule_date = month.substring(0, 2) + day;
        boolean result = input_date.equals(schedule_date);

        return result;
    }

    private String getTheaterName(String theater)
    {
        String theaterName;

        if (theater.equals(JEJU)) theaterName = "제주점";
        else if (theater.equals(JEJU_NOHYENG)) theaterName = "제주노형점";
        else theaterName = "";

        return theaterName;
    }
}
