package Crawlers;

import Interface.Crawl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//무적 크롤러.. 동적웹에 클릭도 할수있음 다만 조금 느림
public class SeleniumCrawler implements Crawl {
    WebDriver driver;
    Pager pager;

    public SeleniumCrawler(Pager pager) {
        this.pager = pager;
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", path + "/driver/geckodriver");

        System.out.println(path);

        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        driver = new FirefoxDriver(firefoxOptions);
    }

    @Override
    public String crawl(String url) {
        String httpDocument;
        try {
            driver.get(url);
            driver = pager.paging(driver);
        } finally {
            httpDocument = driver.getPageSource();
            driver.quit();
        }

        return httpDocument;
    }
}