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

    public Document parse(String url) throws IOException {
        System.out.println(" Start Date : " + getCurrentTime());
        Document httpdocument = (Document) Jsoup.connect(url).get();
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
//
//        // 1. 가져오기전 시간 찍기
//
//
//
//
//        // 2. 가져올 HTTP 주소 세팅
//
//        HttpPost http = new HttpPost("http://finance.naver.com/item/coinfo.nhn?code=045510&target=finsum_more");
//
//
//        // 3. 가져오기를 실행할 클라이언트 객체 생성
//
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//
//
//
//        // 4. 실행 및 실행 데이터를 Response 객체에 담음
//
//        HttpResponse response = httpClient.execute(http);
//
//
//
//        // 5. Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음
//
//        HttpEntity entity = response.getEntity();
//
//
//
//        // 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴
//
//        ContentType contentType = ContentType.getOrDefault(entity);
//
//        Charset charset = contentType.getCharset();
//
//
//
//        // 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중 선택은 개인취향)
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
//
//
//
//        // 8. 가져온 DOM 데이터를 담기위한 그릇
//
//        StringBuffer sb = new StringBuffer();
//
//
//
//        // 9. DOM 데이터 가져오기
//
//        String line = "";
//
//        while((line=br.readLine()) != null){
//
//            sb.append(line+"\n");
//
//        }
//
//        // 10. 가져온 아름다운 DOM을 보자
//
//        System.out.println(sb.toString());
//
//
//
//        // 11. Jsoup으로 파싱해보자.
//
//        Document doc = (Document) Jsoup.parse(sb.toString());
    }

}

