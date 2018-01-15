package Crawlers;

import Interface.Crawl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupCralwer implements Crawl{
    @Override
    public String crawl(String url) {
        Document httpdocument = null;
        try {
            httpdocument = (Document) Jsoup.connect(url).get();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return httpdocument.outerHtml();
    }
}
