package day2;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFrameTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        String adress=System.getProperty("user.dir")+"\\selenium_html\\index.html";
        webDriver.get(adress);
        Suspend.suspend(1000);

    }
    @Test
    public void iframeTest(){
        webDriver.switchTo().frame("aa");
        WebElementUtils.findElement(By.id("user")).sendKeys("你好frame");
        Suspend.suspend(10000);
        webDriver.switchTo().defaultContent();
        WebElementUtils.findElement(By.id("user")).sendKeys("哈哈");

    }
    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
