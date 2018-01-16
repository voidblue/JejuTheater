package Utils;

import Interface.Parsable;

public class Parser {
    private Parsable parser;

    public static Parser getInstance(Parsable parser) { return new Parser(parser); }
    private Parser(Parsable parser)
    {
        this.parser = parser;
    }

    public String parse(String html, String tag)
    {
        return parser.parse(html, tag);
    }
    public String parseToText(String html, String tag)
    {
        return parser.parseToText(html, tag);
    }
}
