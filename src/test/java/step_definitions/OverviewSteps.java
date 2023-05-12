package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.OverviewPage;
import org.example.pageObject.YourCartPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class OverviewSteps {
    public WebDriver driver;

    public OverviewSteps() {
        super();
        this.driver = Hooks.webDriver;
    }

    @Then("User already on Checkout: Overview page")
    public void verifyOnOverviewPage() {
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertTrue(overviewPage.verifyOnOverviewPage());
    }

    @And("Verify product name is the same as product left from Cart Page")
    public void verifyProductName() {
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertEquals(YourCartPage.getProductTitle(0), overviewPage.getProductName());
    }

    @And("Verify product price is the same as product left from Cart Page")
    public void verifyProductPrice() {
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertEquals(YourCartPage.getProductPrice(0), overviewPage.getProductPrice());
    }

    @And("Verify item total is the same as product price")
    public void verifyItemTotalWithProductPrice() {
        OverviewPage overviewPage = new OverviewPage(driver);
        Assert.assertEquals(overviewPage.getItemTotal(), overviewPage.getProductPrice());
    }

    @And("Verify total price is the same as item total plus \"(.*)\" as tax")
    public void verifyTotalPriceWithItemTotalPlusTax(String tax) {
        OverviewPage overviewPage = new OverviewPage(driver);
        double taxDouble = Double.parseDouble(tax);
        Assert.assertEquals(overviewPage.getItemTotalPlusTax(taxDouble), overviewPage.getTotalPrice());
    }

    @When("User click Finish button")
    public void clickFinishButton() {
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.clickFinishBtn();
    }
}
