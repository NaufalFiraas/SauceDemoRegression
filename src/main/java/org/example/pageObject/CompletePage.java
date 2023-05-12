package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage {
    public static WebDriver driver;

    public CompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        CompletePage.driver = driver;
    }

    @FindBy(className = "title")
    private WebElement pageTitle;

    public boolean verifyOnCompletePage() {
        return pageTitle.isDisplayed();
    }
}
