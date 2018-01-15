package Parsers;

import Interface.Parsable;
import Utils.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupParser implements Parsable {
    private String html;
    private Document document;

    public JsoupParser(String html)
    {
        this.html = html;
        this.document = this.getDocument();
    }

    private Document getDocument(){
        return Jsoup.parse(this.html);
    }

    @Override
    public String parse(String tag) {
        String result = document.select(tag).text();
        return result;
    }
}
