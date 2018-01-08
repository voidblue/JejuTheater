package Utils;

import Interface.Crawl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Crawler {

    public static Crawler getInstance(){
        return new Crawler();
    }
    private Crawler(){

    }

    public String crawl(Crawl crawler, String url, String dateFormat){
        return crawler.crawl(url, dateFormat);
    }

}

