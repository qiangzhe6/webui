package day4;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;

public class CucumberSteps {

    @假如("^我打开\"(.*?)\"网站$")
    public void openWeb(String url){
        System.out.println("打开了"+url+"网站"+"\n");
}
    @当("^我用\"(.*?)\"账号,用\"(.*?)\"密码$")
    public void login(String email,String pw){
        System.out.println("用账号"+email+"密码"+pw+"登陆"+"\n");
    }
    @当("^点击登录按钮$")
    public void submit(){
        System.out.println("点击登陆"+"\n");
    }
    @那么("^登录成功$")
    public void sucess(){
        System.out.println("登录成功"+"\n");
    }


}
