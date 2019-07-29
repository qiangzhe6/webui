package day2;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowsTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        String adress=System.getProperty("user.dir")+"\\selenium_html\\index.html";
        webDriver.get(adress);
        Suspend.suspend(1000);
    }
    @Test
    public void windowsTest(){
        WebElementUtils.findElement(By.id("id01")).click();
        String handle1 = webDriver.getWindowHandle();
        for (String handles:webDriver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }
            webDriver.switchTo().window(handles);
        }
        Suspend.suspend(5000);
        WebElementUtils.findElement(By.id("kw")).sendKeys("haha");
        Suspend.suspend(5000);
    }
    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
