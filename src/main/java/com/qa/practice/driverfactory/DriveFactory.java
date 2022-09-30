package com.qa.practice.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriveFactory {
    public WebDriver driver;
    public Properties prop;
    public WebDriver inItDriver(Properties prop ){
        String browsername = prop.getProperty("browser").trim();
        if (browsername.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browsername.equals("FF")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();

        }
        else if(browsername.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();

        }
        else{
            System.out.print("Please pass the right browser: "+browsername);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

        return driver;

    }
     public Properties inIt_Prop(){
        prop = new Properties();
         try {
             FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
             prop.load(ip);
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }

         return prop;

     }
}
