package day3;

import aw.tools.Suspend;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @DataProvider(name = "test")
    public  Object[][] data(){
        return new Object[][]{
                {"chrome","http://192.168.60.1:5555"},
                {"firefox","http://192.168.60.1:5555"},
                {"internet explorer","http://192.168.60.1:6666"},
                {"Microsoft Edge","http://192.168.60.1:6666"}
        };
    }
    @Test(dataProvider = "test")
    public void gridTest(String browserName,String url){
        DesiredCapabilities dc=null;
        if (browserName.equals("chrome")){
            dc=DesiredCapabilities.chrome();
        }else if(browserName.equals("firefox")){
            dc=DesiredCapabilities.firefox();
        }else if(browserName.equals("internet explorer")){
            dc=DesiredCapabilities.internetExplorer();
            dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        }else if(browserName.equals("Microsoft Edge")){
            dc=DesiredCapabilities.edge();
        }
        WebDriver webDriver=null;
        try {
            webDriver = new RemoteWebDriver(new URL(url + "/wd/hub"), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        webDriver.get("https://www.baidu.com/");
        Suspend.suspend(5000);
        webDriver.quit();

    }


}
