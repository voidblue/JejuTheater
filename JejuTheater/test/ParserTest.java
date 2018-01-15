import Crawlers.JsoupCralwer;
import Parsers.JsoupParser;
import Utils.Crawler;
import Utils.Parser;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest
{
    @Test
    public void HTMLParsing()
    {
        Crawler crawler = Crawler.getInstance();
        String html = crawler.crawl(new JsoupCralwer(), "http://www.cgv.co.kr/");
//        System.out.println(html);

        Parser parser = Parser.getInstance(new JsoupParser(html));
        String result = parser.parse(".address address");
//        System.out.println(result);
        Assert.assertTrue(result.equals("(04377)서울특별시 용산구 한강대로 23길 55, 아이파크몰 6층(한강로동)"));
    }
}