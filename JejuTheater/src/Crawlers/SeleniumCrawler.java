package Crawlers;

import Interface.Crawl;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//무적 크롤러.. 동적웹에 클릭도 할수있음 다만 조금 느림
public class SeleniumCrawler implements Crawl {
    WebDriver driver;
    Pager pager;

    public SeleniumCrawler(Pager pager) {

//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("headless","window-size=1920x1080", "disable-gpu");
//        driver = new FirefoxDriver();

        this.pager = pager;
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", path + "/driver/geckodriver");


        System.out.println(path);

        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        driver = new FirefoxDriver(firefoxOptions);
//        driver = new FirefoxDriver();
    }

    @Override
    public String crawl(String url) {
//        driver.get(url);
//        System.out.println(driver.getPageSource());
        String httpDocument;
        try {
            driver.get(url);
            driver = pager.paging(driver);
            System.out.println(driver.getPageSource());
        } finally {
            httpDocument = driver.getPageSource();
            driver.quit();
        }

        return httpDocument;
    }
}