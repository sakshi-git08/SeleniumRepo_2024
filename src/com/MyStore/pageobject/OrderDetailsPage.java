package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
    WebDriver ldriver;

    //constructor
    public OrderDetailsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//b[normalize-space()='Order Placed!']")
    WebElement placedOrderText;

    @FindBy(xpath = "//a[normalize-space()='Download Invoice']")
    WebElement downloadInvoiceButton;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueBtn;

    public String verifyOrderPlaced() {
        String text = placedOrderText.getText();
        return text;
    }

    public void getInvoice() {
        downloadInvoiceButton.click();
    }

    public void clickOnContinue() {
        continueBtn.click();
    }
}
