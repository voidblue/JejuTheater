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
        String date = getDate();
        String url = "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=206,04,06&theatercode=" + theater + "&date=" + date;
        String html = crawler.crawl(new JsoupCralwer(), url);

        Parser parser = Parser.getInstance(new JsoupParser(html));
        String set = parser.parse(".sect-showtimes ul li:nth-child(1) .col-times");
        System.out.println(set);

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
