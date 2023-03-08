package ravn.Contexts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    /* LIST OF NAV BAR LINKS */
    public List<WebElement> homeLinks(){

        List<WebElement> links = driver.findElements(By.cssSelector("ul.navbar-nav>li"));

        return links;
    }

    /* PIVOT LOCATORS */
    public WebElement slider(){
        WebElement slider = driver.findElement(By.id("slider-carousel"));
        return slider;
    }
}
