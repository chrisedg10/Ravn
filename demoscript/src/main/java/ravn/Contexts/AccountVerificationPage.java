package ravn.Contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountVerificationPage {

    private WebDriver driver;

    public AccountVerificationPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement verificationContainer(){
        WebElement container = driver.findElement(By.className("col-sm-9"));
        return container;
    }

    public WebElement verificationTitle(){
        WebElement title = verificationContainer().findElement(By.tagName("b"));
        return title;
    }

    public WebElement continueButton(){
        WebElement continueBtn = verificationContainer().findElement(By.tagName("a"));
        return continueBtn;
    }

    public WebElement addContainer(){
        WebElement container = driver.findElement(By.cssSelector("html > ins"));
        return container;
    }

    public WebElement addFrame(){
        WebElement addFame = addContainer().findElement(By.name("aswift_1"));
        return addFame;
    }

    public WebElement closeAddBtn(){
        //WebElement close = addFrame().findElement(By.cssSelector("#dismiss-button"));
        WebElement close = addFrame().findElement(By.id("ad_position_box"));
        return close;
    }
}
