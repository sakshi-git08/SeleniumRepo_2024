package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    WebDriver ldriver;

    //constructor
    public AccountCreatedPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //identify webelements
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement accountCreated;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;


    //identify action on webelement
    public void verifyIfAccountCreated() {
        accountCreated.getText();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
