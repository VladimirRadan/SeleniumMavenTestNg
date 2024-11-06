package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeleniumActionsTest extends BaseTest{


    @Test
    public void iFrameTest(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);
    }

    @Test
    public void sliderTest(){
        driver.get("https://demoqa.com/slider");
        WebElement slider = driver.findElement(By.cssSelector(".range-slider"));
        for (int i = 0; i < 50; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @Test
    public void tabsTest(){
        driver.get("https://demoqa.com/browser-windows");
        String currentTab = driver.getWindowHandle();
        System.out.println(currentTab);

        driver.findElement(By.id("tabButton")).click();
        //Set<String> tabs = new HashSet<>()
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);
    }

}
