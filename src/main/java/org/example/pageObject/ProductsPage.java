package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    public static WebDriver driver;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        ProductsPage.driver = driver;
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private WebElement shoppingCart;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectField;

    public static String firstProductTitle;
    public static String secondProductTitle;

    public static String firstProductPrice;
    public static String secondProductPrice;

    public boolean verifyProductsPage() {
        return pageTitle.isDisplayed();
    }

    public void setSelectFieldByText(String text) {
        Select selectField = new Select(this.selectField);
        selectField.selectByVisibleText(text);
    }

    public void clickAddToCartBtn(int order) {
        String addToCartBtnLocator = "//div[@class='inventory_item'][" + order + "]//button[@id[contains(., 'add-to-cart')]]";
        WebElement addToCartBtn = ProductsPage.driver.findElement(By.xpath(addToCartBtnLocator));
        addToCartBtn.click();
        setProductTitle(order);
        setProductPrice(order);
    }

    private void setProductTitle(int order) {
        String locator = "//div[@class='inventory_list']/div[" + order + "]//div[@class='inventory_item_name']";
        if (order == 1) {
            firstProductTitle = ProductsPage.driver.findElement(By.xpath(locator)).getText();
        } else {
            secondProductTitle = ProductsPage.driver.findElement(By.xpath(locator)).getText();
        }
    }

    private void setProductPrice(int order) {
        String locator = "//div[@class='inventory_item'][" + order + "]//div[@class='inventory_item_price']";
        if (order == 1) {
            firstProductPrice = ProductsPage.driver.findElement(By.xpath(locator)).getText();
        } else {
            secondProductPrice = ProductsPage.driver.findElement(By.xpath(locator)).getText();
        }
    }

    public void clickCartIcon() {
        shoppingCart.click();
    }

}
