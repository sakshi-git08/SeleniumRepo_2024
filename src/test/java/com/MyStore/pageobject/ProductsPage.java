package com.MyStore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver ldriver;

    //constructor
    public ProductsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement product;

    @FindBy(id = "search_product")
    WebElement productSearchBar;

    @FindBy(id = "submit_search")
    WebElement searchIcon;

    @FindBy(xpath = "//p[contains(text(),'T-Shirts')]")
    WebElement productDescription;

    public void clickOnProducts(){
        product.click();
    }

    public void enterTextInSearchBar(String text){
        productSearchBar.clear();
        productSearchBar.sendKeys(text);
    }

    public void clickOnSearchIcon(){
        searchIcon.click();
    }

    public String verifyProductDescription(){
        String productText = productDescription.getText();
        return productText;
    }
}
