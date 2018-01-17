package Bringer;

import Crawlers.JsoupCralwer;
import Interface.Bring;
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
    public final String JEJU = "0121";
    public final String JEJU_NOHYENG = "0259";

    public CGVBringer()
    {
        this.crawler = Crawler.getInstance();
    }

    @Override
    public ArrayList<ArrayList> bring() {
        ArrayList<ArrayList> lists = new ArrayList<>();

        // TODO: 반복문으로 구현
        lists.add(getSchedules(JEJU));
        lists.add(getMovies(JEJU));
//        lists.add(getSchedules(JEJU_NOHYENG));
//        lists.add(getMovies(JEJU_NOHYENG));

        return lists;
    }

    private Schedules getSchedules(String theater)
    {
        Schedules schedules = new Schedules();
        String date = "&date=" + getDate();
        String url = "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=206,04,06&theatercode=" + JEJU + date;
        String html = crawler.crawl(new JsoupCralwer(), url);

        Parser parser = Parser.getInstance(new JsoupParser());
        // TODO: 날짜 개수만큼 반복
        String date_set = parser.parse(html, ".day a[title=\"현재 선택\"]");
        String month = parser.parseToText(date_set, "span");
        String day = parser.parseToText(date_set, "strong");
        String day_of_week = parser.parseToText(date_set, "em");

        // TODO: 영화 개수만큼 반복
        String schedule_set = parser.parse(html, ".sect-showtimes ul li:nth-child(1) .col-times");
        String movie_titie = parser.parseToText(schedule_set, ".info-movie a strong");

        // TODO: 상영관 수만큼 반  복
        String screen_set = parser.parse(schedule_set, "div:nth-child(2)");
        String screen_number = parser.parseToText(screen_set, ".info-hall:nth-child(1) ul li:nth-child(2)");

        // TODO: 상영시간 수만큼 반복
        String time_set = parser.parse(screen_set, ".type-hall div:nth-child(2) ul li:nth-child(1)");
        System.out.println(time_set);
        String show_time = parser.parseToText(time_set, "em");
        String seat_left = parser.parseToText(time_set, "span:not(.hidden)");
        // TODO: ArrayList에 add

        System.out.println("[결과]");
        System.out.println(month);
        System.out.println(day);
        System.out.println(day_of_week);
        System.out.println(movie_titie);
        System.out.println(screen_number);
        System.out.println(show_time);
        System.out.println(seat_left);
        return null;
    }

    private Movies getMovies(String theater)
    {

        return null;
    }

    private String getDate()
    {
        Calendar c1 = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷
        String date = sdf.format(c1.getTime()); // String으로 저장

        return date;
    }

}
