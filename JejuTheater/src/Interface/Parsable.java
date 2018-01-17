package Interface;

import java.util.ArrayList;

public interface Parsable {
    String parse(String html, String tag);
    String parseToText(String html, String tag);
    ArrayList parseToList(String html, String tag);
}
