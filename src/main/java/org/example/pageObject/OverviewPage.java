package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

    public static WebDriver driver;

    public OverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        OverviewPage.driver = driver;
    }

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(className = "inventory_item_price")
    private WebElement productPrice;

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(className = "summary_total_label")
    private WebElement totalPrice;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public boolean verifyOnOverviewPage() {
        return pageTitle.isDisplayed();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getItemTotal() {
        return itemTotal.getText().split(" ")[2];
    }

    public String getTotalPrice() {
        return totalPrice.getText().split(" ")[1];
    }

    public String getItemTotalPlusTax(double tax) {
        String itemTotal = getProductPrice().replace("$", "");
        double itemTotalDouble = Double.parseDouble(itemTotal);
        double newTotal = itemTotalDouble + tax;
        return "$" + newTotal;
    }

    public void clickFinishBtn() {
        finishBtn.click();
    }
}
