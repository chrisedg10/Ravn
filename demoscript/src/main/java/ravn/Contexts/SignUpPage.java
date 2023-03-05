package ravn.Contexts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement accountInfoSection(){
        WebElement accountSection = driver.findElement(By.className("login-form"));
        return accountSection; 
    }

    public List<WebElement> banners(){
        List<WebElement> headers = accountInfoSection().findElements(By.tagName("b"));
        return headers;
    }

    public List<WebElement> radioButtons(){
        WebElement section = accountInfoSection().findElement(By.className("clearfix"));
        List<WebElement> radioBtns = section.findElements(By.tagName("input"));
        return radioBtns;
    }

    public WebElement passwordField(){
        WebElement passwordField = accountInfoSection().findElement(By.name("password"));
        return passwordField; 
    }

    public List<WebElement> getDropdowns(){
        List<WebElement> dropdowns = accountInfoSection().findElements(By.tagName("select"));
        return dropdowns;
    }

    public ArrayList<WebElement> getCheckBoxes(){
        List<WebElement> checkers = accountInfoSection().findElements(By.className("checker"));
        ArrayList<WebElement> checkboxes = new ArrayList<WebElement>();

        for(WebElement cb: checkers){
            checkboxes.add(cb.findElement(By.tagName("input")));
        }

        return checkboxes;
    }

}
