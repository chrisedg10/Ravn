package ravn.Contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvertisementLocators {

    private WebDriver driver;

    public AdvertisementLocators(WebDriver driver){
        this.driver = driver;
    }

    /* CONTAINER LOCATORS */
    public WebElement addContainer(){
        WebElement container = driver.findElement(By.cssSelector("html > ins"));
        return container;
    }

    /* FRAMES LOCATORS */
    public WebElement addFrame(){
        WebElement addFame = addContainer().findElement(By.name("aswift_1"));
        return addFame;
    }

    /* CONTROLS LOCATORS */
    public WebElement closeAddBtn(){
        WebElement close = addFrame().findElement(By.id("ad_position_box"));
        return close;
    }
}
