package Crawlers;

import Interface.Crawl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsoupCralwer implements Crawl{
    @Override
    public Document crawl(String url) {
        Document httpdocument = null;
        try {
            httpdocument = (Document) Jsoup.connect(url).get();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return httpdocument;
    }
}
