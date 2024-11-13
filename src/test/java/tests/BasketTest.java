package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BasketTest extends BaseTest {

    //Actions actions = new Actions(driver);

    By headerMenuComputers = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Computers')]");
    By headerMenuNotebooks = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Notebooks')]");
    By headerMenuBooks = By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");

    By addToCartButton = By.cssSelector("input[value='Add to cart']");

    By goToCartButton = By.cssSelector(".ico-cart .cart-label");

    By productPrices = By.cssSelector(".product-subtotal");
    By totalAmount = By.cssSelector(".product-price>strong");


    @Test
    public void basketTest(){


        hover(headerMenuComputers, 1);
        hoverAndClick(headerMenuNotebooks, 2000);

        getElement(addToCartButton).click();

        clickOnElement(headerMenuBooks);
        clickOnRandomElement(addToCartButton);
        clickOnRandomElement(addToCartButton);

        clickOnElement(goToCartButton);


        List<WebElement> list = driver.findElements(productPrices);
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Double.parseDouble(list.get(i).getText());
        }

        System.out.println("Zbir je: " + sum);

        double total = Double.parseDouble(getElement(totalAmount).getText());

        System.out.println("Total je: " + total);

        Assert.assertTrue(total == sum, "Sum is not equal to total amount!");
    }

}
