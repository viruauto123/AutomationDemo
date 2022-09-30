package com.qa.practice.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class  MyAccountPageTest extends BaseTest {
    @BeforeClass
    public void myAccountPageSetup(){
        myAccountPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void getMyAccountTitleTest(){
      boolean actualTitle = myAccountPage.getMyAccountTittlePage();
        Assert.assertTrue(actualTitle);

    }

    @Test(priority = 2,dataProvider = "productData")
    public void getSearchResultTest(String productName) throws InterruptedException {
        myAccountPage.doSearch(productName);
        Thread.sleep(3000);
    }
    @DataProvider
    public Object[][] productData() {
        return new Object[][]{
                {"Macbook pro"},
                {"Apple"},
                {"Samsung"},
        };
    }
}
