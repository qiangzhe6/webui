package day4;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "D:\\mydoc\\webui\\src\\test\\java\\day4",
        format = {"pretty","html:target/cucumber-pretty",
                  "json:target/cucumber.json"},
        tags    = {"@Automation"},
        glue    = {"D:\\mydoc\\webui\\src\\test\\java\\day4"})
public class RunCucumber extends AbstractTestNGCucumberTests {

}
