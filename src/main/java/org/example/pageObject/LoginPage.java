package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        LoginPage.driver = driver;
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginBtn;

    public boolean verifyOnLoginPage() {
        return userName.isDisplayed();
    }

    public void inputUserName(String username) {
        userName.sendKeys(username);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickBtnLogin() {
        loginBtn.click();
    }
}
