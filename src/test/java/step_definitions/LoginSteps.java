package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    final private WebDriver driver;

    public LoginSteps() {
        super();
        this.driver = Hooks.webDriver;
    }

    @Given("User already on Login Page")
    public void verifyOnLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.verifyOnLoginPage());
    }

    @When("User input \"(.*)\" as userName and input \"(.*)\" as password")
    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUserName(username);
        loginPage.inputPassword(password);
        loginPage.clickBtnLogin();
    }
}
