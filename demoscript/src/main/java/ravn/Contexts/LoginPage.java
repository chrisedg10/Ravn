package ravn.Contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    /* SIGN UP SECTION LOCATORS */

    /* SIGN UP CONTAINER */
    public WebElement singUpSection(){
        WebElement form = driver.findElement(By.className("signup-form"));
        return form;
    }

    /* SIGN UP HEADER */
    public WebElement signUpBanner(){
        WebElement banner = singUpSection().findElement(By.cssSelector("div.signup-form>h2"));
        return banner;
    }

    /* SIGN UP CONTROLS */
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

    /* LOG IN SECTION LOCATORS */

    /* LOG IN CONTAINER */
    public WebElement logInSection(){
        WebElement form = driver.findElement(By.className("login-form"));
        return form;
    }

    /* LOG IN HEADER */
    public WebElement logInBanner(){
        WebElement banner = logInSection().findElement(By.cssSelector("div.login-form>h2"));
        return banner;
    }

    /* LOG IN CONTROLS */
    public WebElement logInEmail(){
        WebElement email = logInSection().findElement(By.name("email"));
        return email;
    }

    public WebElement logInPassword(){
        WebElement email = logInSection().findElement(By.name("password"));
        return email;
    }

    public WebElement logInButton(){
        WebElement button = logInSection().findElement(By.className("btn"));
        return button;
    }

    /* LOG IN ERROR MESSAGE */
    public WebElement logInErrorMessage(){
        WebElement errorText = logInSection().findElement(By.cssSelector("div.login-form>form>p"));
        return errorText;
    }
}
