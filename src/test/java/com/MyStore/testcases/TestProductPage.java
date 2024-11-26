package com.MyStore.testcases;

import com.MyStore.pageobject.*;
import com.MyStore.utilities.AllDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestProductPage extends BaseTest {
    PaymentPage paymentPage;
    OrderDetailsPage orderDetailsPage;

    @Test(dataProvider = "LoginDP", dataProviderClass = AllDataProvider.class)
    public void verifyProduct(String userEmail, String userPwd, String expectedUserName) throws IOException {
        String searchKey = "T-Shirts";
        logger.info("\n *******************Test case search product Started******************");

        //Sign in
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickOnSignIn();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterLoginEmail(userEmail);
        myAccountPage.enterLoginPassword(userPwd);
        myAccountPage.clickOnLoginButton();
        HomePage homePage = new HomePage(driver);
        String username = homePage.verifyUserLoggedIn();
        System.out.println(username);
        if (username.equals("Logged in as " + expectedUserName)) {
            logger.info("Verify registered user login - Passed");
            Assert.assertTrue(true);
        } else {
            logger.info("Verify registered user login - Failed");
            captureScreenshot(driver, "verifyProduct");
            Assert.assertTrue(false);
        }

        ProductsPage pg = new ProductsPage(driver);
        pg.clickOnProducts();
        pg.enterTextInSearchBar(searchKey);
        pg.clickOnSearchIcon();
        scrollWindow(0, 450);
//        String productName = pg.verifyProductDescription();
//        System.out.println(productName);
        pg.clickOnViewProduct();
        String productName = pg.getProductName();
        System.out.println(productName);
        if (productName.contains(searchKey)) {
            logger.info("Verify product - Passed");
            Assert.assertTrue(true);
        } else {
            logger.info("Verify product - Failed");
            captureScreenshot(driver, "verifyProduct");
            Assert.assertTrue(false);
        }
        pg.enterQty("2");
        pg.clickOnAddToCart();
        CartPage cp = new CartPage(driver);
//        driver.switchTo().frame("Added!");
//        String text = cp.verifyProductAdded();
//        Assert.assertEquals("Added!", text);
        cp.clickOnCartDetails();
        cp.clickOnCheckout();
        OrderPage op = new OrderPage(driver);
        op.clickOnPlaceOrder();
        paymentPage = new PaymentPage(driver);
        orderDetailsPage = paymentPage.goToOrderDetails("Aviel Mansour", "4932971218528393", "115", "11", "2027");
        String orderDetails = orderDetailsPage.verifyOrderPlaced();
        Assert.assertEquals("ORDER PLACED!", orderDetails);
        orderDetailsPage.getInvoice();
        orderDetailsPage.clickOnContinue();


        homePage.clickOnLogout();
    }

}
