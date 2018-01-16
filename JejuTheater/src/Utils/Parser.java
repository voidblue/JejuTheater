package Utils;

import Interface.Parsable;

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
    public String parseToText(String tag)
    {
        return parser.parseToText(tag);
    }
}
