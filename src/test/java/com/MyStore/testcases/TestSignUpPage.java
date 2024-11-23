package com.MyStore.testcases;

import com.MyStore.pageobject.SignUpPage;
import org.testng.annotations.Test;

public class TestSignUpPage extends BaseTest {

    @Test
    public void createAccount(){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.selectTitle();
        logger.info("Title selected!!");

        signUpPage.enterPassword("Test@123");
        logger.info("password entered");
    }
}
