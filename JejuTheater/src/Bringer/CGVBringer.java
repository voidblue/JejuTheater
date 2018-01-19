package Bringer;

import Crawlers.JsoupCralwer;
import Interface.Bring;
import Interface.Crawl;
import Parsers.JsoupParser;
import TheaterData.Movies;
import TheaterData.Schedules;
import Utils.Crawler;
import Utils.Parser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

        lists.add(getMovies(JEJU));
        lists.add(getSchedules(JEJU));
        lists.add(getMovies(JEJU_NOHYENG));
        lists.add(getSchedules(JEJU_NOHYENG));

        return lists;
    }

    private Schedules getSchedules(String theater)
    {
        Schedules schedules = new Schedules();
        int repetitions = 0;

        // 날짜 개수만큼 반복
        while(true) {
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
                String movie_titie = parseToText(target, ".info-movie a strong");
                ArrayList screen_set = parseToList(target, ".col-times .type-hall");

                // 상영관 수만큼 반복
                for (int count_screen = 0; count_screen < screen_set.size(); count_screen++) {
                    target = getTarget(screen_set, count_screen);
                    String screen_number = parseToText(target, ".info-hall ul li:nth-child(2)");
                    ArrayList time_set = parseToList(target,".type-hall div:nth-child(2) ul li");

                    // 상영시간 수만큼 반복
                    for (int count_showtime = 0; count_showtime < time_set.size(); count_showtime++) {
                        target = getTarget(time_set, count_showtime);
                        String show_time = parseToText(target, "em");
                        String seat_left = parseToText(target, "span:not(.hidden)");

                        // TODO: ArrayList에 add
                    }
                }
            }
        }

        return null;
    }

    private Movies getMovies(String theater)
    {
        Crawler crawler = Crawler.getInstance();

        String html = crawler.crawl(new JsoupCralwer(), "http://www.cgv.co.kr/movies/?lt=1&ft=1");
        String[] ids = getIds(html);

        // id 개수만큼 반복
        for (int i = 0; i < ids.length; i++) {
            String url_pro = "http://www.cgv.co.kr/movies/detail-view/?midx=";
            String html_movie = crawler.crawl(new JsoupCralwer(), url_pro + ids[i]);

            String title = parseToText(html_movie, ".title strong");
            String title_en = parseToText(html_movie, ".title p");
            String genre = parseToText(html_movie, ".spec dt:nth-last-of-type(3)").substring(5);
            String storyline = parseToText(html_movie, ".sect-story-movie");
            String release_date = parseToText(html_movie, ".spec .on:last-of-type");
            String basic = parseToText(html_movie, ".spec .on:nth-last-of-type(2)");
            String age_limit = basic.split(",")[0];
            String running_time = basic.split(",")[1].substring(1);
            String score = parseToText(html_movie, ".score .percent span:not(.percent)");
            String ticket_sales = parseToText(html_movie, ".egg-gage:first-of-type .percent");

            // TODO: ArrayList에 add

        }
        return null;
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
}
