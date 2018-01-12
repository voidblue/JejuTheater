package Utils;

import Interface.Parser;
import org.jsoup.nodes.Document;

public class SimpleParser implements Parser {
    private Document html;

    public static SimpleParser getInstance(Document html) { return new SimpleParser(html); }
    private SimpleParser(Document html)
    {
        this.html = html;
    }

    public String parse(String tag)
    {
        String result = html.select(tag).text();

        return result;
    }
}