package ravn.Contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement singUpSection(){

        WebElement form = driver.findElement(By.className("signup-form"));
        return form;
    }

    public WebElement signUpBanner(){
        WebElement banner = singUpSection().findElement(By.tagName("h2"));
        return banner;
    }

    public WebElement nameInput(){
        WebElement name = singUpSection().findElement(By.name("name"));
        return name;
    }

    public WebElement emailInput(){
        WebElement email = singUpSection().findElement(By.name("email"));
        return email;
    }

    public WebElement signUpButton(){
        WebElement button = singUpSection().findElement(By.className("btn"));
        return button;
    }
}
