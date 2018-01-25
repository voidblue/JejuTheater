package Crawlers;

import org.openqa.selenium.WebDriver;


//for SeleniumCrawler
//크롤하기 전 페이지의 상태를
@FunctionalInterface
public interface Pager {
    WebDriver paging(WebDriver driver);
}
