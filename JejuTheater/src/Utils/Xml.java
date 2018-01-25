package Utils;

import Crawlers.Pager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;


public class Xml {
    Document doc;
    public Xml(ArrayList<HashMap<String, String>> arrayList){

        doc = null;
        DocumentBuilderFactory factory = null;
        factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        doc = builder.newDocument();
        Element schedule = doc.createElement("schedule");
        doc.appendChild(schedule);

        Element date = doc.createElement("date");
        schedule.appendChild(date);
        date.appendChild(doc.createTextNode("date"));

        Element theater = doc.createElement("theater");
        schedule.appendChild(theater);

        Element brand = doc.createElement("brand");
        theater.appendChild(brand);
        brand.appendChild(doc.createTextNode("brand"));

        Element theaterName = doc.createElement("theaterName");
        theater.appendChild(theaterName);
        theaterName.appendChild(doc.createTextNode("theaterName"));

        Element address = doc.createElement("address");
        theater.appendChild(address);
        address.appendChild(doc.createTextNode("address"));

        Element phoneNumber = doc.createElement("phoneNumber");
        theater.appendChild(phoneNumber);
        phoneNumber.appendChild(doc.createTextNode("phoneNumber"));

        Element movies = doc.createElement("movies");
        theater.appendChild(movies);

        Element movieId = doc.createElement("movieId");
        movies.appendChild(movieId);
        movieId.appendChild(doc.createTextNode("movieId"));

        Element movieName = doc.createElement("movieName");
        movies.appendChild(movieName);
        movieName.appendChild(doc.createTextNode("movieName"));

        Element movieNameENG = doc.createElement("movieNameENG");
        movies.appendChild(movieNameENG);
        movieNameENG.appendChild(doc.createTextNode("movieNameENG"));

        Element genre = doc.createElement("genre");
        movies.appendChild(genre);
        genre.appendChild(doc.createTextNode("genre"));

        Element ageLimit = doc.createElement("ageLimit");
        movies.appendChild(ageLimit);
        ageLimit.appendChild(doc.createTextNode("ageLimit"));

        Element openDate = doc.createElement("openDate");
        movies.appendChild(openDate);
        openDate.appendChild(doc.createTextNode("openDate"));

        Element story = doc.createElement("story");
        movies.appendChild(story);
        story.appendChild(doc.createTextNode("story"));

        Element share = doc.createElement("share");
        movies.appendChild(share);
        share.appendChild(doc.createTextNode("share"));

        Element sales = doc.createElement("sales");
        movies.appendChild(sales);
        sales.appendChild(doc.createTextNode("sales"));

        Element timeList = doc.createElement("timeList");
        movies.appendChild(timeList);

        Element screenId = doc.createElement("screenId");
        timeList.appendChild(screenId);
        screenId.appendChild(doc.createTextNode("screenId"));

        Element room = doc.createElement("room");
        timeList.appendChild(room);
        room.appendChild(doc.createTextNode("room"));

        Element startTime = doc.createElement("startTime");
        timeList.appendChild(startTime);
        startTime.appendChild(doc.createTextNode("startTime"));

        Element leftSeat = doc.createElement("leftSeat");
        timeList.appendChild(leftSeat);
        leftSeat.appendChild(doc.createTextNode("leftSeat"));

        Element totalSeat = doc.createElement("totalSeat");
        timeList.appendChild(totalSeat);
        totalSeat.appendChild(doc.createTextNode("totalSeat"));


        TransformerFactory tr_factory = TransformerFactory.newInstance();
        String xmlStr = "";
        try
        {
            StringWriter sw = new StringWriter();
            Properties output = new Properties();
            output.setProperty(OutputKeys.INDENT, "yes");
            output.setProperty(OutputKeys.ENCODING, "EUC-KR");
            Transformer transformer = tr_factory.newTransformer();
            transformer.setOutputProperties(output);
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            xmlStr = sw.getBuffer ().toString ();
            System.out.println(xmlStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void main(String ares[]){
//        Xml xml = new Xml();
    }

}