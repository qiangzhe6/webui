package day2;

import aw.driver.SeleniumDriver;
import aw.tools.Suspend;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        String adress=System.getProperty("user.dir")+"\\selenium_html\\index.html";
        webDriver.get(adress);
        Suspend.suspend(1000);
    }
    @Test
    public void AlertTest(){
        webDriver.findElement(By.className("confirm")).click();
        Alert alert=webDriver.switchTo().alert();
        Suspend.suspend(20000);
        alert.accept();
    }
    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
