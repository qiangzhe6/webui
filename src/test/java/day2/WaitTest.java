package day2;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        String adress=System.getProperty("user.dir")+"\\selenium_html\\index.html";
        webDriver.get(adress);
        Suspend.suspend(1000);
    }
    @Test
    public void globalWaitTest(){
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        webDriver.findElement(By.className("baidu")).click();

        webDriver.findElement(By.className("secondary-button text-button small-link"));
    }
    @Test
    public void displayWaitTest(){
        webDriver.findElement(By.className("wait")).click();
        //3.显示等待，如果没有满足until后面的值，会等待5s，然后抛超时异常，如果5s之内就正常了，那就无需等待
        new WebDriverWait(webDriver,5).until(ExpectedConditions.presenceOfElementLocated(By.className("red")));
        String text=webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        System.out.println(text);
    }
    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
