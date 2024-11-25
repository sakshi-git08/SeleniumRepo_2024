package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver ldriver;

    //constructor
    public HomePage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //identify webelements
    @FindBy(xpath = "//*[@class='fa fa-user']//ancestor::a")
    WebElement loggedInAs;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutLink;

    //identify action on webelement
    public String verifyUserLoggedIn() {
        String loggedInName = loggedInAs.getText();
        return loggedInName;
    }

    public void clickOnLogout(){
        logoutLink.click();
    }

}
