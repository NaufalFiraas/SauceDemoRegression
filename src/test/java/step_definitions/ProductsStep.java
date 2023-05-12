package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.ProductsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductsStep {
    public WebDriver driver;

    public ProductsStep() {
        super();
        this.driver = Hooks.webDriver;
    }

    @Then("User already on Products page")
    public void verifyOnProductsPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.verifyProductsPage());
    }

    @When("User select filter \"(.*)\" as selectedValue")
    public void selectValue(String selectedValue) {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.setSelectFieldByText(selectedValue);
    }

    @And("User click Add to cart button on the first and second product")
    public void addToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickAddToCartBtn(1);
        productsPage.clickAddToCartBtn(2);

    }

    @And("User click on cart icon")
    public void clickShoppingCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickCartIcon();
    }
}
