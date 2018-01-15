import Crawlers.JsoupCralwer;
import Parsers.JsoupParser;
import Utils.Crawler;
import Utils.Parser;
import org.junit.Test;

import java.util.ArrayList;

public class CGVTest {


    @Test
    public void CGVtest()
    {
        ArrayList schedules = new ArrayList();
        Crawler crawler = Crawler.getInstance();

        // 크롤링
        String html_schedule = crawler.crawl(new JsoupCralwer(), "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=206&theatercode=0121&date=20180115");

        // 파싱
        Parser parser = Parser.getInstance(new JsoupParser(html_schedule));

        String str = parser.parseInTag(".sect-showtimes ul li");
        System.out.println(str);

        // print
    }
}
