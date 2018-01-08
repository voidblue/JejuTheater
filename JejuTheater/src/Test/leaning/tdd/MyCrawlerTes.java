package leaning.tdd;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;

public class MyCrawlerTes {
    @Test
    public void testCrawl() {
        ICrawler crawler = new Crawler(
                "https://test"
        );
        HtmlPage result = crawler.crawl();
        HtmlPage expected = new HtmlPage("fail");
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void testAllNewCrawl() {
        ICrawler crawler = new AllNewCrawler();
        HtmlPage result = crawler.crawl();
        HtmlPage expected = new HtmlPage("fail");
        Assert.assertTrue(result.equals(expected));
    }
}

interface ICrawler {
    public HtmlPage crawl();
}

class AllNewCrawler implements ICrawler {

    @Override
    public HtmlPage crawl() {
        return null;
    }
}

class Crawler implements ICrawler {
    private String url;
    public Crawler(String url) {
        this.url = url;
    }

    @Override
    public HtmlPage crawl() {
        Document httpdocument = null;
        try {
            httpdocument = Jsoup.connect(url).get();
        } catch (IOException e) {
            return new HtmlPage("fail");
        }
        return new HtmlPage(httpdocument.outerHtml());
    }
}

class HtmlPage {
    public String page;
    public HtmlPage(String page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        HtmlPage target = (HtmlPage)o;
        return this.page == target.page;
    }
}