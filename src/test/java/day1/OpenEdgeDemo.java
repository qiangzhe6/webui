package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class OpenEdgeDemo {
    WebDriver webDriver;
    @Test
    public void openEdge(){
        String path=System.getProperty("user.dir")+"\\drivers\\MicrosoftWebDriver.exe";
        System.setProperty("webdriver.edge.driver",path);
        webDriver=new EdgeDriver();
        webDriver.get("https://www.baidu.com/");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }
}
