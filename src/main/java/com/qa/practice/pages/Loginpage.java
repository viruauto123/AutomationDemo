package com.qa.practice.pages;

import com.qa.practice.utilities.Constants;
import com.qa.practice.utilities.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public Loginpage(WebDriver driver){
        this.driver = driver;
      elementUtil =new ElementUtil(driver);
    }

    private By emailID= By.id("input-email");
    private By password= By.id("input-password");
    private By loginBtn = By.cssSelector("[type='submit']");

    public String getLoginPageTitle(){
        return elementUtil.waitForTitleContains(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_TIMEOUT);
    }
    public String getLoginPageURL(){
        return elementUtil.waitForUrl(Constants.DEFAULT_TIMEOUT,Constants.LOGIN_PAGE_URL);
    }
    public MyAccountPage doLogin(String un, String pwd){
        System.out.println("login with "+ un + ":"+pwd);
        elementUtil.doSendKeys(emailID,un);
        elementUtil.doSendKeys(password,pwd);
        elementUtil.doClick(loginBtn);
        return new MyAccountPage(driver);

    }


}

