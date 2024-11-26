package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver ldriver;

    //constructor
    public PaymentPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameOnCard;

    @FindBy(xpath = "//input[@name='card_number']")
    WebElement cardNumber;

    @FindBy(xpath = "//input[@data-qa='cvc']")
    WebElement cvc;

    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    WebElement expiryMonth;

    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    WebElement expiryYear;

    @FindBy(id = "submit")
    WebElement submitButton;

    public OrderDetailsPage goToOrderDetails(String name, String cardNum, String cvv, String month, String year) {
        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(cardNum);
        cvc.sendKeys(cvv);
        expiryMonth.sendKeys(month);
        expiryYear.sendKeys(year);
        submitButton.click();
        return new OrderDetailsPage(ldriver);


    }


}
