package Test;

import Utils.Crawling;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class CrawlingTest {
    public static Crawling crawling;
    public static Document httpdocument;

    @BeforeClass
    public static void makeInstance()throws Exception{
        crawling = Crawling.getInstance();
    }

    @Test
    public void parse() throws IOException {
        httpdocument = crawling.parse("http://www.cgv.co.kr/theaters/?areacode=206%2C04%2C06&theaterCode=0121&date=20180103");
        Assert.assertTrue(httpdocument.title().equals("영화 그 이상의 감동. CGV"));
    }

    @Test
    public void save() throws IOException {
        crawling.save(httpdocument);
    }

}
