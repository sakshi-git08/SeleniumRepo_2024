package com.MyStore.testcases;

import com.MyStore.pageobject.*;
import com.MyStore.utilities.AllDataProvider;
import com.MyStore.utilities.ReadExcelFile;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestMyAccountDataDrivenTesting extends BaseTest {
    static Faker faker = new Faker();
    public static String emailId = faker.internet().emailAddress();
    public static String password =  faker.regexify("[a-z]{0,9}");


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

    @Test(enabled = false)
    public void verifyRegistrationAndLogin() {
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

        signUpPage.enterPassword(password);
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

    @Test(dataProvider = "LoginDP", dataProviderClass = AllDataProvider.class)
    public void verifyRegisteredUserLogin(String userEmail, String userPwd, String expectedUserName) throws IOException {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterLoginEmail(userEmail);
        myAccountPage.enterLoginPassword(userPwd);
        myAccountPage.clickOnLoginButton();
        HomePage homePage = new HomePage(driver);
        String username = homePage.verifyUserLoggedIn();
        System.out.println(username);
        if(username.equals("Logged in as " + expectedUserName)){
            logger.info("Verify registered user login - Passed");
            Assert.assertTrue(true);
        }else {
            logger.info("Verify registered user login - Failed");
            captureScreenshot(driver, "verifyRegisteredUserLogin");
            Assert.assertTrue(false);
        }
        homePage.clickOnLogout();
    }

//    @DataProvider(name = "LoginDP")
//    public String [][] LoginDP(){
//        String fileName = System.getProperty("user.dir") + "\\testData\\MyStoreTestData.xlsx";
//
//        int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
//        int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
//
//        String data[][] = new String[ttlRows - 1][ttlColumns];
//        for (int i = 1; i < ttlRows; i++){
//            for (int j = 0; j < ttlColumns; j++){
//                data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
//            }
//        }
//        return data;
//    }
}
