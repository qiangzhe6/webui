package aw.driver;

import aw.logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static aw.logger.LoggerControler.getLogger;
public class SeleniumDriver {
    public static WebDriver driver;
    final static LoggerControler log= getLogger(SeleniumDriver.class);
    public static WebDriver SeleniumDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\testing\\webdriver_demo\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            log.info("你打开了"+browser+"浏览器");
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver();
            log.info("你打开了"+browser+"浏览器");
        } else {
            log.severe("你输入的" + browser + "浏览器不支持打开");
        }
    }
    public static void closed(){
        driver.quit();
    }
}
