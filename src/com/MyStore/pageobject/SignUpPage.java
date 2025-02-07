package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    //1. Create object of webdriver
    WebDriver ldriver;

    //constructor
    public SignUpPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //identify webelements
    @FindBy(id = "id_gender2")
    WebElement titleMrs;

    @FindBy(id = "id_gender1")
    WebElement titleMr;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement addressField1;

    @FindBy(id = "address2")
    WebElement addressField2;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountButton;


    public void selectOptions(WebElement element, String value) {
        Select options = new Select(element);
        options.selectByValue(value);
    }


    //identify action on webelement
    public void selectTitle() {
        titleMrs.click();
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void enterDay(String day) {
        Select options = new Select(days);
        options.selectByVisibleText(day);
    }

    public void enterMonth(String month) {
        Select options = new Select(months);
        options.selectByVisibleText(month);
    }

    public void enterYear(String year) {
        Select options = new Select(years);
        options.selectByVisibleText(year);
    }

    public void enterFirstName(String fname) {
        firstName.clear();
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.clear();
        lastName.sendKeys(lname);
    }

    public void enterCompanyName(String cmpy) {
        company.clear();
        company.sendKeys(cmpy);
    }

    public void enterAddressInField1(String add1) {
        addressField1.clear();
        addressField1.sendKeys(add1);
    }

    public void enterAddressInField2(String add2) {
        addressField2.clear();
        addressField2.sendKeys(add2);
    }

    public void enterCountry(String countryName) {
        Select options = new Select(country);
        options.selectByVisibleText(countryName);
    }

    public void enterState(String stateName) {
        state.clear();
        state.sendKeys(stateName);
    }

    public void enterCity(String cityName) {
        city.clear();
        city.sendKeys(cityName);
    }

    public void enterZipCode(String zipCode) {
        zipcode.clear();
        zipcode.sendKeys(zipCode);
    }

    public void enterMobileNumber(String mobile) {
        mobileNumber.clear();
        mobileNumber.sendKeys(mobile);
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }


//    public void enterText(WebElement element, String text){
//        element.clear();
//        element.sendKeys(text);
//    }
}
