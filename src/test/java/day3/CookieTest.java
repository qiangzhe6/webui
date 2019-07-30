package day3;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Cookie;

public class CookieTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        webDriver.get("https://mail.qq.com/cgi-bin/loginpage");
        Suspend.suspend(1000);
    }
    @Test
    public void cookieTest(){
        webDriver.switchTo().frame("login_frame");
        WebElementUtils.findElement(By.className("inputstyle")).sendKeys("591158309@qq.com");
        WebElementUtils.findElement(By.className("inputstyle password")).sendKeys("459765jiajia**");
        WebElementUtils.findElement(By.className("btn"));
        for(Cookie cookie:webDriver.manage().getCookies()){
            System.out.println("第一个cookie:"+cookie.getName()+";"+cookie.getValue()+";"+cookie.getDomain()+";"+cookie.getPath()+";"+cookie.getExpiry()+";"+cookie.isSecure());
        }

    }
    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
