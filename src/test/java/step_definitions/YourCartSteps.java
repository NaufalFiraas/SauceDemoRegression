package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.ProductsPage;
import org.example.pageObject.YourCartPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class YourCartSteps {
    public WebDriver driver;

    public YourCartSteps() {
        super();
        this.driver = Hooks.webDriver;
    }

    @Then("User already on Your Cart page")
    public void verifyOnYourCartPage() {
        YourCartPage yourCartPage = new YourCartPage(driver);
        Assert.assertTrue(yourCartPage.verifyOnYourCartPage());
    }

    @And("Verify the first product name is the same as first selected product name")
    public void verifyFirstProductName() {
        Assert.assertEquals(ProductsPage.firstProductTitle, YourCartPage.getProductTitle(1));
    }

    @And("Verify the first product price is the same as first selected product price")
    public void verifyFirstProductPrice() {
        Assert.assertEquals(ProductsPage.firstProductPrice, YourCartPage.getProductPrice(1));
    }

    @And("Verify the second product name is the same as second selected product")
    public void verifySecondProductName() {
        Assert.assertEquals(ProductsPage.secondProductTitle, YourCartPage.getProductTitle(2));
    }

    @And("Verify the second product price is the same as second selected product price")
    public void verifySecondProductPrice() {
        Assert.assertEquals(ProductsPage.secondProductPrice, YourCartPage.getProductPrice(2));
    }

    @When("User click on remove button inside the first product")
    public void clickFirstRemoveBtn() {
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.clickFirstRemoveBtn();
    }

    @Then("Verify that only second product left on Your Cart page")
    public void verifyOnlySecondProductLeft() {
        Assert.assertEquals(ProductsPage.secondProductTitle, YourCartPage.getProductTitle(1));
        Assert.assertEquals(ProductsPage.secondProductPrice, YourCartPage.getProductPrice(1));
    }

    @When("User click on Checkout button")
    public void clickCheckoutBtn() {
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.clickCheckoutBtn();
    }
}
