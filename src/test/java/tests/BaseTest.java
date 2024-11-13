package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setupMethod(){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    protected WebElement getElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void typeIn(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    protected void clickOnRandomElement(By locator){
        List<WebElement> list = driver.findElements(locator);
        Random random = new Random();
        int randomElement = random.nextInt(list.size());
        list.get(randomElement).click();
    }

    protected void hover(By locator, long wait){
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .build()
                .perform();
    }

    protected void hoverAndClick(By locator, long wait){
        WebElement element = getElement(locator);
        new Actions(driver)
                .moveToElement(element)
                .pause(wait)
                .click()
                .build()
                .perform();
    }

    protected void clickOnElement(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }



}
