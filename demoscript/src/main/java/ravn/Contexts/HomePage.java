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

    public List<WebElement> homeLinks(){

        WebElement navbar = driver.findElement(By.className("navbar-nav"));
        List<WebElement> links = navbar.findElements(By.tagName("a"));

        return links;
    }
}
