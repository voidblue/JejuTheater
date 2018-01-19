package Parsers;

import Interface.Parsable;
import Utils.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.util.ArrayList;

public class JsoupParser implements Parsable {

    @Override
    public String parseToText(String html, String tag) {
        Document document = getDocument(html);
        String result = document.select(tag).text();
        return result;
    }

    @Override
    public ArrayList parseToList(String html, String tag) {
        Document document = getDocument(html);
        Elements result = document.select(tag);
        return result;
    }

    @Override
    public String parse(String html, String tag)
    {
        Document document = getDocument(html);
        String result = document.select(tag).outerHtml();
        return result;
    }

    @Override
    public String getAttr(String html, String tag, String attr)
    {
        Document document = getDocument(html);
        String result = document.select(tag).attr(attr);
        return result;
    }

    private Document getDocument(String html) { return Jsoup.parse(html); }
}
