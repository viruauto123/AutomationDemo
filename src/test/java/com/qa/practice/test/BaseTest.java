package com.qa.practice.test;

import com.qa.practice.driverfactory.DriveFactory;
import com.qa.practice.pages.Loginpage;
import com.qa.practice.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    DriveFactory df;
    WebDriver driver;
    Properties prop;
    Loginpage loginpage;
    MyAccountPage myAccountPage;
    @BeforeTest
    public void setup(){
        df= new DriveFactory();
       prop = df.inIt_Prop();
        driver=df.inItDriver(prop);
        loginpage = new Loginpage(driver);


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
