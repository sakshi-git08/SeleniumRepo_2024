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

    @FindBy(xpath = "//a[starts-with(text(),'View Product')]")
    WebElement viewProduct;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    WebElement prodName;

    @FindBy(id = "quantity")
    WebElement qty;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    WebElement addToCartButton;

    public void clickOnProducts() {
        product.click();
    }

    public void enterTextInSearchBar(String text) {
        productSearchBar.clear();
        productSearchBar.sendKeys(text);
    }

    public void clickOnSearchIcon() {
        searchIcon.click();
    }

    public String verifyProductDescription() {
        String productText = productDescription.getText();
        return productText;
    }

    public void clickOnViewProduct() {
        viewProduct.click();
    }

    public String getProductName() {
        String name = prodName.getText();
        return name;
    }

    public void enterQty(String number) {
        qty.clear();
        qty.sendKeys(number);
    }

    public void clickOnAddToCart() {
        addToCartButton.click();
    }

}
