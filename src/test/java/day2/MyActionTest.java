package day2;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;

public class MyActionTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        String adress=System.getProperty("user.dir")+"\\selenium_html\\index.html";
        webDriver.get(adress);
        Suspend.suspend(10000);
    }
    @Test
    public void click(){
        WebElementUtils.findElement(By.className("btnSousuo")).click();
        Suspend.suspend(10000);
    }
    @Test
    public void sendkey(){
        WebElementUtils.findElement(By.id("user")).sendKeys("张翠翠");
        Suspend.suspend(10000);
    }
    @Test
    public void AssertTrue(){
        Assert.assertTrue(WebElementUtils.findElement(By.id("user")).isDisplayed());
    }
    @Test
    public void AssertEable(){
        Assert.assertTrue(WebElementUtils.findElement(By.xpath("/html/body/div/table/thead/tr/th[2]")).isEnabled());
    }

    @Test
    public void ScreenShot()throws IOException {
        File file= ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D:\\myproject\\error\\baidu.png"));
    }

    @Test
    public void getText(){
        System.out.println(WebElementUtils.findElement(By.xpath("//*[@id=\"link\"]/a")).getText());
    }
    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
