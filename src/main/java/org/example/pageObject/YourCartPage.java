package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
    public static WebDriver driver;

    public YourCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        YourCartPage.driver = driver;
    }

    @FindBy(className = "title")
    public WebElement pageTitle;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")
    public WebElement firstRemoveBtn;

    private static String productTitle;
    private static String productPrice;

    public boolean verifyOnYourCartPage() {
        return pageTitle.isDisplayed();
    }

    private static void setProductTitle(int order) {
        String locator = "//div[@class='cart_item'][" + order + "]//div[@class='inventory_item_name']";
        productTitle = YourCartPage.driver.findElement(By.xpath(locator)).getText();
    }

    private static void setProductPrice(int order) {
        String locator = "//div[@class='cart_item'][" + order + "]//div[@class='inventory_item_price']";
        productPrice = YourCartPage.driver.findElement(By.xpath(locator)).getText();
    }

    public static String getProductTitle(int order) {
        if (order != 0) {
            YourCartPage.setProductTitle(order);
        }
        return YourCartPage.productTitle;
    }

    public static String getProductPrice(int order) {
        if (order != 0) {
            YourCartPage.setProductPrice(order);
        }
        return YourCartPage.productPrice;
    }

    public void clickFirstRemoveBtn() {
        firstRemoveBtn.click();
    }

    public void clickCheckoutBtn() {
        checkoutBtn.click();
    }
}
