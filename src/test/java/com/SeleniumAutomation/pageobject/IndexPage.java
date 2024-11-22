package com.SeleniumAutomation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    //1. Create object of webdriver
    WebDriver ldriver;

    //constructor
    public IndexPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    //identify webelements
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signIn;


    //identify action on webelement
    public void clickOnSignIn(){
        signIn.click();
    }
}
