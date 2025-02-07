package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver ldriver;

    //constructor
    public CartPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //identify webelements
    @FindBy(xpath = "//div[@class='modal-content']/div/h4")
    WebElement productAdded;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCart;

    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    WebElement checkoutButton;

    //identify action on webelement
    public String verifyProductAdded() {
        String text = productAdded.getText();
        return text;
    }

    public void clickOnCartDetails() {
        viewCart.click();
    }

    public void clickOnCheckout() {
        checkoutButton.click();
    }

}
