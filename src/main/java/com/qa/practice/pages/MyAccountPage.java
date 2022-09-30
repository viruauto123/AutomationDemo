package com.qa.practice.pages;

import com.qa.practice.utilities.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        elementUtil =new ElementUtil(driver);

    }
    private By myAccountTittle = By.cssSelector("#content h2:nth-of-type(1)");
    private By searchField= By.cssSelector(".form-control.input-lg");
    private By searchButton = By.cssSelector(".btn.btn-default.btn-lg");

    public boolean getMyAccountTittlePage(){
       return elementUtil.doIsDisplayed(myAccountTittle);
    }

    public SearchResultPage doSearch(String ProductName){
        elementUtil.doSendKeys(searchField , ProductName );
        elementUtil.doClick(searchButton);
        return new SearchResultPage(driver);

    }
}
