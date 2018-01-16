package Parsers;

import Interface.Parsable;
import Utils.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParser implements Parsable {
    private String html;
    private Document document;

    public JsoupParser(String html)
    {
        this.html = html;
        this.document = Jsoup.parse(this.html);
    }

    @Override
    public String parseToText(String tag) {
        String result = document.select(tag).text();
        return result;
    }

    @Override
    public String parse(String tag)
    {
        String result = document.select(tag).outerHtml();
        return result;
    }
}
