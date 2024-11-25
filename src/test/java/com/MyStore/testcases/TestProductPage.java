package com.MyStore.testcases;

import com.MyStore.pageobject.HomePage;
import com.MyStore.pageobject.IndexPage;
import com.MyStore.pageobject.MyAccountPage;
import com.MyStore.pageobject.ProductsPage;
import com.MyStore.utilities.AllDataProvider;
import com.MyStore.utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestProductPage extends BaseTest {

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
        if(username.equals("Logged in as " + expectedUserName)){
            logger.info("Verify registered user login - Passed");
            Assert.assertTrue(true);
        }else {
            logger.info("Verify registered user login - Failed");
            captureScreenshot(driver, "verifyProduct");
            Assert.assertTrue(false);
        }

        ProductsPage pg = new ProductsPage(driver);
        pg.clickOnProducts();
        pg.enterTextInSearchBar(searchKey);
        pg.clickOnSearchIcon();
        scrollWindow(0,450);
        String productName = pg.verifyProductDescription();
        System.out.println(productName);
        if(productName.contains(searchKey)){
            logger.info("Verify product - Passed");
            Assert.assertTrue(true);
        }else {
            logger.info("Verify product - Failed");
            captureScreenshot(driver, "verifyProduct");
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
