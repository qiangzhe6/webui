package day2;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;

public class SelectTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        String adress=System.getProperty("user.dir")+"\\selenium_html\\index.html";
        webDriver.get(adress);
        Suspend.suspend(1000);
    }
    @Test
    public void selectTest(){
        Select select=new Select(WebElementUtils.findElement(By.id("moreSelect")));
        select.selectByIndex(1);
        Suspend.suspend(1000);
        select.selectByValue("vivo");
        Suspend.suspend(1000);
        select.selectByVisibleText("meizu");
        Suspend.suspend(5000);

    }
    @Test
    public void mulSelectTest(){
        Select select=new Select(WebElementUtils.findElement(By.id("selectWithMultipleEqualsMultiple")));
        try {
            Robot robot=new Robot();
            robot.keyPress(InputEvent.CTRL_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        select.selectByIndex(1);
        Suspend.suspend(1000);
        select.deselectByIndex(1);
        Suspend.suspend(1000);
    }

    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
