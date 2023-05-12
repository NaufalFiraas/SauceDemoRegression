package step_definitions;

import cucumber.api.java.en.Then;
import org.example.pageObject.CompletePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CompleteSteps {
    final private WebDriver driver;

    public CompleteSteps() {
        super();
        this.driver = Hooks.webDriver;
    }

    @Then("User already on Checkout: Complete! page")
    public void verifyOnCompletePage() {
        CompletePage completePage = new CompletePage(driver);
        Assert.assertTrue(completePage.verifyOnCompletePage());
    }
}
