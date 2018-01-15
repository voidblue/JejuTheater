import Crawlers.JsoupCralwer;
import Utils.Crawler;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CrawlerTest {
    public static Crawler crawler;
    @BeforeClass
    public static void makeInstance(){
        crawler = Crawler.getInstance();
    }

    @Test
    public void CGVtest(){
        final String JEJU = "0121";
        final String JEJU_NOHYENG = "0259";
        String date = "&date=" + getDate();
        String url = "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=206,04,06&theatercode=" + JEJU + date;

        //html 소스 안에 CGV라는 문자열이 존재하면 대략적으로 통과한걸로
        String httpdocument = crawler.crawl(new JsoupCralwer(),url);
        System.out.println(httpdocument);

        Assert.assertTrue(httpdocument.contains("CGV"));
    }

    private String getDate()
    {
        Calendar c1 = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷
        String date = sdf.format(c1.getTime()); // String으로 저장

        return date;
    }


}
