package day4;

import aw.driver.SeleniumDriver;
import aw.elements.WebElementUtils;
import aw.tools.Suspend;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CucumberSteps {
    WebDriver webDriver;
    @假如("^我打开\"(.*?)\"网站$")
    public void openWeb(String url){
        webDriver= SeleniumDriver.SeleniumDriver("chrome");
        Suspend.suspend(1000);
        webDriver.get(url);
    }
    @当("^我用\"(.*?)\"账号,用\"(.*?)\"密码$")
    public void login(String email,String pw){
        WebElementUtils.findElement(By.id("lbNormal")).click();
        Suspend.suspend(5000);
        WebElement element=WebElementUtils.findElement(By.xpath("//*[@id=\"x-URS-iframe1564932773061.185\"]"));
        webDriver.switchTo().frame(element);
        WebElementUtils.findElement(By.xpath("//*[@id=\"auto-id-1564911566336\"]")).click();
        WebElementUtils.findElement(By.xpath("//*[@id=\"auto-id-1564911566339\"]")).sendKeys("email");
        WebElementUtils.findElement(By.xpath("//*[@id=\"auto-id-1564911566339\"]")).click();
        WebElementUtils.findElement(By.xpath("//*[@id=\"auto-id-1564911566339\"]")).sendKeys("pw");
    }
    @当("^点击登录按钮$")
    public void submit(){
        webDriver.findElement(By.id("dologin")).click();
    }


}
