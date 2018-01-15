package Utils;

import Interface.Parsable;
import org.jsoup.nodes.Document;

public class Parser {
    private Parsable parser;

    public static Parser getInstance(Parsable parser) { return new Parser(parser); }
    private Parser(Parsable parser)
    {
        this.parser = parser;
    }

    public String parse(String tag)
    {
        return parser.parse(tag);
    }
    public String parseInTag(String tag)
    {
        return parser.parseInTag(tag);
    }
}
