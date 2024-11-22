package com.SeleniumAutomation.testcases;

import com.SeleniumAutomation.pageobject.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class TestMyAccount extends BaseTest {
    static Faker faker = new Faker();
    public static String emailId = faker.internet().emailAddress();


    String firstName = faker.funnyName().name();
    String lastName = faker.funnyName().name();
    String company = faker.company().toString();
    String address = faker.address().toString();
    String number = faker.phoneNumber().toString();
    String pin = faker.regexify("^[0-9]{1,6}$");

//    public String getEmail() {
//        emailId = "Rani" + System.currentTimeMillis() + "@gmail.com";
//        return emailId;
//    }

    @Test
    public void verifyRegistrationAndLogin() {
//        System.out.println(firstName);
        //open url
        driver.get(url);
        logger.info("url opened");
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterName(firstName);
        myAccountPage.enterEmailAddress(emailId);
        myAccountPage.clickOnSignUp();
        logger.info("Name & email entered, clicked on signUp button!!");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.selectTitle();
        logger.info("Title selected!!");

        signUpPage.enterPassword(faker.regexify("[a-z]{0,9}"));
        logger.info("password entered");
        signUpPage.enterDay("2");
        signUpPage.enterMonth("February");
        signUpPage.enterYear("2015");
        logger.info("date of birth entered");
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastName(lastName);
        signUpPage.enterCompanyName(company);
        signUpPage.enterAddressInField1(address);
        signUpPage.enterAddressInField2("UP");
        signUpPage.enterCountry("India");
        signUpPage.enterState("UP");
        signUpPage.enterCity("Mirzapur");
        signUpPage.enterZipCode(pin);
        signUpPage.enterMobileNumber(number);
        logger.info("All required fields entered");
        signUpPage.clickOnCreateAccountButton();
        logger.info("Clicked on create account");
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.verifyIfAccountCreated();
        accountCreatedPage.clickOnContinueButton();
        logger.info("Account Created => continuing to next page");
        HomePage homePage = new HomePage(driver);
        String username = homePage.verifyUserLoggedIn();
        System.out.println(username);
        Assert.assertEquals("Logged in as " + firstName, username);


    }
}
