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

    /* CONTAINER LOCATOR */
    public WebElement accountInfoSection(){
        WebElement accountSection = driver.findElement(By.className("login-form"));
        return accountSection; 
    }

    /*** ACCOUNT INFORMATION LOCATORS ***/

    /* ACCOUNT INFORMATION HEADER */
    public List<WebElement> banners(){
        List<WebElement> headers = accountInfoSection().findElements(By.cssSelector("div.login-form>h2.title>b"));
        return headers;
    }

    /* ACCOUNT INFORMATION CONTROLS */
    public List<WebElement> radioButtons(){
        WebElement section = accountInfoSection().findElement(By.className("clearfix"));
        List<WebElement> radioBtns = section.findElements(By.cssSelector("*>div.radio>span>input"));
        return radioBtns;
    }

    public WebElement passwordField(){
        WebElement passwordField = accountInfoSection().findElement(By.name("password"));
        return passwordField; 
    }

    public List<WebElement> getDropdowns(){
        List<WebElement> dropdowns = accountInfoSection().findElements(By.cssSelector("select"));
        return dropdowns;
    }

    public ArrayList<WebElement> getCheckBoxes(){
        List<WebElement> checkers = accountInfoSection().findElements(By.className("checker"));
        ArrayList<WebElement> checkboxes = new ArrayList<WebElement>();

        for(WebElement cb: checkers){
            checkboxes.add(cb.findElement(By.cssSelector("*>div.checker>span>input")));
        }
        return checkboxes;
    }

    /*** ADDRESS INFORMATION LOCATORS ***/

    /* ADDRESS INFORMATION HEADER */
    public WebElement firstName(){
        WebElement name = accountInfoSection().findElement(By.name("first_name"));
        return name;
    }

    /* ADDRESS INFORMATION CONTROLS */
    public WebElement lastName(){
        WebElement last = accountInfoSection().findElement(By.name("last_name"));
        return last;
    }

    public WebElement company(){
        WebElement company = accountInfoSection().findElement(By.name("first_name"));
        return company;
    }

    public WebElement addressLineOne(){
        WebElement address = accountInfoSection().findElement(By.name("address1"));
        return address;
    }

    public WebElement addressLineTwo(){
        WebElement address = accountInfoSection().findElement(By.name("address2"));
        return address;
    }

    public WebElement state(){
        WebElement state = accountInfoSection().findElement(By.name("state"));
        return state;
    }

    public WebElement city(){
        WebElement city = accountInfoSection().findElement(By.name("city"));
        return city;
    }

    public WebElement zipcode(){
        WebElement zip = accountInfoSection().findElement(By.name("zipcode"));
        return zip;
    }

    public WebElement mobileNumber(){
        WebElement mnumber = accountInfoSection().findElement(By.name("mobile_number"));
        return mnumber;
    }

    public WebElement createAccount(){
        WebElement submitButton = accountInfoSection().findElement(By.className("btn-default"));
        return submitButton;
    }

}
