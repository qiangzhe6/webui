package day2;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionTest {
    WebDriver webDriver;
    @BeforeTest
    public void openBrowser(){
        webDriver= SeleniumDriver.SeleniumDriver("Edge");
        String adress=System.getProperty("user.dir")+"\\selenium_html\\index.html";
        webDriver.get(adress);
        Suspend.suspend(1000);
    }
    @Test
    public void rightClickTest(){

        WebElement element= WebElementUtils.findElement(By.className("over"));
        Actions actions=new Actions(webDriver);
        actions.contextClick(element).perform();
        Suspend.suspend(5000);
        actions.click().perform();
        actions.clickAndHold(element).perform();
        Suspend.suspend(5000);
        actions.release(element).perform();
        Suspend.suspend(5000);
        WebElement element1= WebElementUtils.findElement(By.name("identity"));
        actions.click(element1).perform();
        Suspend.suspend(5000);
        WebElement element2= WebElementUtils.findElement(By.xpath("//*[@id=\"radio\"]/label[1]"));
        actions.doubleClick(element2).perform();
        Suspend.suspend(5000);
        WebElement element3= WebElementUtils.findElement(By.xpath("//*[@id=\"radio\"]/label[4]"));
        Point point=element3.getLocation();
        actions.dragAndDropBy(element2,point.getX(),point.getY()).perform();
        Suspend.suspend(5000);
        actions.release(element2).perform();

    }

    @AfterTest
    public void closeBrowser(){
        SeleniumDriver.closed();
    }
}
