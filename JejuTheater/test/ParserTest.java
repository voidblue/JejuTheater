import Crawlers.JsoupCralwer;
import Interface.Crawl;
import Utils.Crawler;
import Utils.SimpleParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest
{
    @Test
    public void HTMLParsing()
    {
        Crawler crawler = Crawler.getInstance();
        Document html = crawler.crawl(new JsoupCralwer(), "http://www.cgv.co.kr/");
//        System.out.println(html);

        SimpleParser parser = SimpleParser.getInstance(html);
        String result = parser.parse(".address address");

        Assert.assertTrue(result.equals("(04377)서울특별시 용산구 한강대로 23길 55, 아이파크몰 6층(한강로동)"));
    }
}