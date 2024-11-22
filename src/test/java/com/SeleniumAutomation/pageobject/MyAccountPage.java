package com.SeleniumAutomation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    //1. Create object of webdriver
    WebDriver ldriver;

    //constructor
    public MyAccountPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    //identify webelement
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpButton;

    //identify actions for webelement
    public void enterName(String nameForAccount){
        name.sendKeys(nameForAccount);
    }

    public void enterEmailAddress(String emailAddres){
        email.sendKeys(emailAddres);
    }

    public void clickOnSignUp(){
        signUpButton.click();
    }
}
