package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage extends BasePage{

    //relativni
    private By registerLink = By.cssSelector(".header-links>ul>li>a[class='ico-register']");
    private By gender = By.xpath("//label[text()='Male']");
    private By firstNameField = By.cssSelector(".inputs>label[for='FirstName'] + input");
    private By lastNameField = By.xpath("//div/label[@for='LastName']/following-sibling::input");
    private By emailNameField = By.xpath("//input[@id='Email']");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    private By welcomePageText = By.cssSelector(".page-body .result");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    //apsolutni
    ///html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[2]/input


    public void registerUser(){
        driver.findElement(registerLink).click();
        driver.findElement(gender).click();
        driver.findElement(firstNameField).sendKeys("John");
        driver.findElement(lastNameField).sendKeys("Smith");
        driver.findElement(emailNameField).sendKeys(System.currentTimeMillis() + "@email.com");
        driver.findElement(passwordField).sendKeys("Test1234");
        driver.findElement(confirmPasswordField).sendKeys("Test1234");
        driver.findElement(registerButton).click();
    }

    public boolean isUserRegistered(){
        String expectedText = "Your registration completed!";
        return matchesExpectedText(welcomePageText, expectedText);
    }



}
