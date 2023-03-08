package ravn.Contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountVerificationPage {

    private WebDriver driver;

    public AccountVerificationPage(WebDriver driver){
        this.driver = driver;
    }

    /* CONTAINER LOCATOR */
    public WebElement verificationContainer(){
        WebElement container = driver.findElement(By.className("col-sm-9"));
        return container;
    }

    /* HEADERS LOCATOR */
    public WebElement verificationTitle(){
        WebElement title = verificationContainer().findElement(By.cssSelector("h2.title>b"));
        return title;
    }

    /* CONTROLS LOCATOR */
    public WebElement continueButton(){
        WebElement continueBtn = verificationContainer().findElement(By.cssSelector("div.pull-right>a"));
        return continueBtn;
    }
}
