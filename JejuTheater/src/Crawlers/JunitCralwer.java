package Crawlers;

import Interface.Crawl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JunitCralwer implements Crawl{
    @Override
    public String crawl(String url, String dateformat) {
        System.out.println(" Start Date : " + dateformat);
        Document httpdocument = null;
        try {
            httpdocument = (Document) Jsoup.connect(url + dateformat).get();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(" End Date : " + dateformat);
        return httpdocument.outerHtml();
    }
}
