package Parsers;

import Interface.Parsable;
import Utils.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParser implements Parsable {

    @Override
    public String parseToText(String html, String tag) {
        Document document = Jsoup.parse(html);
        String result = document.select(tag).text();
        return result;
    }

    @Override
    public String parse(String html, String tag)
    {
        Document document = Jsoup.parse(html);
        String result = document.select(tag).outerHtml();
        return result;
    }
}
