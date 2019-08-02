package day3;

import aw.driver.SeleniumDriver;
import aw.tools.Suspend;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Jstest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("firefox");
        webDriver.get("https://www.baidu.com/");
        Suspend.suspend(1000);
    }
    @Test
    public void jsTest(){
        JavascriptExecutor js=(JavascriptExecutor)webDriver;
        System.out.println(js.executeScript("var a=document.getElementById(\"su\").value; return a;"));
        Suspend.suspend(5000);

    }
    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
