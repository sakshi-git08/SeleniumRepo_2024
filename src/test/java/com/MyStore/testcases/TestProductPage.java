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
        logger.info("Enter product to search...");
        pg.enterTextInSearchBar(searchKey);
        pg.clickOnSearchIcon();
        scrollWindow(0, 450);
//        String productName = pg.verifyProductDescription();
//        System.out.println(productName);
        logger.info("Scroll the window and click on view product");
        pg.clickOnViewProduct();
        String productName = pg.getProductName();
        System.out.println(productName);
        logger.info("Verify the name of the product");
        if (productName.contains(searchKey)) {
            logger.info("Verify product - Passed");
            Assert.assertTrue(true);
        } else {
            logger.info("Verify product - Failed");
            captureScreenshot(driver, "verifyProduct");
            Assert.assertTrue(false);
        }
        logger.info("Enter the quantity of products");
        pg.enterQty("2");
        logger.info("Add product to the cart");
        pg.clickOnAddToCart();
        CartPage cp = new CartPage(driver);
//        driver.switchTo().frame("Added!");
//        String text = cp.verifyProductAdded();
//        Assert.assertEquals("Added!", text);
        logger.info("View cart details and checkout");
        cp.clickOnCartDetails();
        cp.clickOnCheckout();
        OrderPage op = new OrderPage(driver);
        logger.info("Click on place order");
        op.clickOnPlaceOrder();
        paymentPage = new PaymentPage(driver);
        logger.info("Enter card details");
        orderDetailsPage = paymentPage.goToOrderDetails("Aviel Mansour", "4932971218528393", "115", "11", "2027");
        logger.info("Review order which you placed...");
        String orderDetails = orderDetailsPage.verifyOrderPlaced();
        Assert.assertEquals("ORDER PLACED!", orderDetails);
        logger.info("Download Invoice");
        orderDetailsPage.getInvoice();
        logger.info("Click on continue");
        orderDetailsPage.clickOnContinue();
        logger.info("After purchase => Logout");
        homePage.clickOnLogout();
    }

}
