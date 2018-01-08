package Test;

import Crawlers.JunitCralwer;
import Utils.Crawler;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
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
        String date = getDate();
        String cgv_url = "http://www.cgv.co.kr/theaters/?areacode=206%2C04%2C06&theaterCode=0121" + "&date=" + date;

        String httpdocument = crawler.crawl(new JunitCralwer(),cgv_url);
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
