package day2;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        String adress=System.getProperty("user.dir")+"\\selenium_html\\index.html";
        webDriver.get(adress);
        Suspend.suspend(1000);
    }
    @Test
    public void robot(){
        WebElementUtils.findElement(By.id("user")).click();
        try {
            Robot robot=new Robot();
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
            Suspend.suspend(5000);
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);
            Suspend.suspend(5000);
            WebElement element=WebElementUtils.findElement(By.className("confirm"));
            Point point = element.getLocation();
            System.out.println(point.getX()+point.getY());
            robot.mouseMove(point.getX(),point.getY());
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Suspend.suspend(10000);
        } catch (AWTException e) {
            e.printStackTrace();
        }


    }

    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
