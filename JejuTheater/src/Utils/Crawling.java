package Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Crawling {

    public static Crawling getInstance(){
        return new Crawling();
    }
    private Crawling(){

    }


    public static String getCurrentTime(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        return sdf.format(new Date());

    }

    public Document parse(String url){
        System.out.println(" Start Date : " + getCurrentTime());
        Document httpdocument = null;
        try {
            httpdocument = (Document) Jsoup.connect(url).get();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(" End Date : " + getCurrentTime());
        return httpdocument;
    }

    public void save(Document httpdocument) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("result.txt"));
        out.write(httpdocument.toString());

    }

    public static void main(String[] args) throws IOException {
        //와 jsoup로 한줄에 파싱 가능
        Crawling crawling = Crawling.getInstance();
        Document httpdocument = crawling.parse("http://www.cgv.co.kr/theaters/?areacode=206%2C04%2C06&theaterCode=0121&date=20180103");
        crawling.save(httpdocument);
        System.out.println(httpdocument);
    }

}

