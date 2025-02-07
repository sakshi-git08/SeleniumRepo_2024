package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    WebDriver ldriver;

    //constructor
    public OrderPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement placeOrder;

    public PaymentPage clickOnPlaceOrder() {
        placeOrder.click();
        return new PaymentPage(ldriver);
    }


}
