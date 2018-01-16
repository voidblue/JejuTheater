package Interface;

public interface Parsable {
    String parse(String html, String tag);
    String parseToText(String html, String tag);
}
