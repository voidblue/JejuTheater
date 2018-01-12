package Interface;

import org.jsoup.nodes.Document;

public interface Crawl {
    Document crawl(String url);
}
