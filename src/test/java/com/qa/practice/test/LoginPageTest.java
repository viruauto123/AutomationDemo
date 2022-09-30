package com.qa.practice.test;

import com.qa.practice.driverfactory.DriveFactory;
import com.qa.practice.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void LoginPageTitleTest() {
        String actualTitle = loginpage.getLoginPageTitle();
        Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void LoginPageURlTest() {
        String actualURL = loginpage.getLoginPageURL();
        Assert.assertTrue(actualURL.contains(Constants.LOGIN_PAGE_URL));

    }
    @Test(priority = 3)
    public void doLoginTest() {
        loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
    }
}