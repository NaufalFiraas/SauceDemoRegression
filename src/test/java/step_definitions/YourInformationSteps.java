package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.YourInformationPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class YourInformationSteps {

    public WebDriver driver;

    public YourInformationSteps() {
        super();
        this.driver = Hooks.webDriver;
    }

    @Then("User already on Checkout: Your Information page")
    public void verifyOnYourInformationPage() {
        YourInformationPage yourInfoPage = new YourInformationPage(driver);
        Assert.assertTrue(yourInfoPage.verifyOnYourInformationPage());
    }

    @When("User input \"(.*)\" as firstName and \"(.*)\" as lastName and \"(.*)\" as postalCode")
    public void inputAllFields(String firstName, String lastName, String postalCode) {
        YourInformationPage yourInfoPage = new YourInformationPage(driver);
        yourInfoPage.inputFirstName(firstName);
        yourInfoPage.inputLastName(lastName);
        yourInfoPage.inputPostalCode(postalCode);
    }

    @And("User click on Continue button")
    public void clickContinueBtn() {
        YourInformationPage yourInfoPage = new YourInformationPage(driver);
        yourInfoPage.clickContinueBtn();
    }
}
