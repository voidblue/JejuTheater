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

    public Document crawl(Crawl crawler, String url){
        return crawler.crawl(url);
    }

}

