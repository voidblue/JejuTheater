package Crawlers;

import DataBase.DBSetter;
import Interface.Crawl;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


//Selenium보다 속도가 훨~~~씬 빠르니까 이걸로 써요
//동적 웹에는 사용하기 힘듦
public class JsoupCralwer implements Crawl {
    @Override
    public String crawl(String url) {
        Document httpdocument = null;
        try {
            httpdocument = (Document) Jsoup.connect(url).get();
//            httpdocument = (Document) Jsoup.connect(url).m
        } catch (IOException e) {
//            System.out.println(e.getMessage());
        }

        return httpdocument.outerHtml();
    }
}
