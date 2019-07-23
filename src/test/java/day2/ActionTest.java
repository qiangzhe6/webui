package day2;

import aw.driver.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class ActionTest {
    WebDriver webDriver;
    @BeforeTest
    public WebDriver openBrowser(){
        SeleniumDriver.SeleniumDriver("chrome")


    }
}
