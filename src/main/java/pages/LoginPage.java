package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By loginLink = By.cssSelector(".ico-login");
    By userNameField = By.cssSelector(".email");
    By passwordField = By.cssSelector(".password");
    By loginButton = By.cssSelector(".button-1.login-button");

    By invalidLoginErrorMessage = By.cssSelector(".validation-summary-errors");
    By invalidUsernameMessage = By.cssSelector("span[for='Email']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginForm() {
        clickOnElement(loginLink);
        return this;
    }

    public LoginPage loginUser(String username, String password) {
        typeIn(userNameField, username)
                .typeIn(passwordField, password)
                .clickOnElement(loginButton);
        return this;
    }

    public boolean isErrorMessagePresent(){
        return getElement(invalidLoginErrorMessage).isDisplayed() || getElement(invalidUsernameMessage).isDisplayed();
    }



}
