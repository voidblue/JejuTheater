package Crawlers;

import org.openqa.selenium.WebDriver;


//for SeleniumCrawler
//크롤하기 전 페이지의 상태를 사용자측에서 정의
@FunctionalInterface
public interface Pager {
    WebDriver paging(WebDriver driver);
}
