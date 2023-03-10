package ravn.Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ravn.Contexts.*;

public interface HomePageFunctions extends Waits{
    
    default public void verifySelectedLink(WebDriver driver){
        System.out.println("\nAutomation practice: Landing page\n");

        HomePage home = new HomePage(driver);

        waitUntilElementIsVisible(driver, home.slider());

        for (WebElement link : home.homeLinks()) {
            String text = link.getText();
            String style = link.getAttribute("style");

            if (style != null && style.length() != 0) {
                System.out.println("** The hyperlink " + text + " is currently selected");
                break;
            } 
        }
    }

    default public void selectLink(WebDriver driver, String linkText){
        HomePage home = new HomePage(driver);

        waitUntilElementIsVisible(driver, home.slider());

        for (WebElement link : home.homeLinks()) {
            String text = link.getText();

            if (text.contains(linkText)) {
                link.click();
                System.out.println("** Clicked on: " + linkText);
                break;
            } 
        }
    }

    default public void verifyUsername(WebDriver driver, String name){

        System.out.println("\nAutomation practice: Home page\n");
        HomePage links = new HomePage(driver);

        waitUntilElementIsVisible(driver, links.slider());

        for (WebElement link : links.homeLinks()) {
            String text = link.getText();
            
            if (text.contains(name)) {
                Assert.assertEquals(text, "Logged in as " + name);
                System.out.println("*** " + text + " is visible");
            } 
        }
    }

    default public void logOut(WebDriver driver){
        HomePage links = new HomePage(driver);

        for (WebElement link : links.homeLinks()) {
            String text = link.getText();
            
            if (text.contains("Logout")) {
                link.click();
                System.out.println("*** Clicked on LogOut link");
                break;
            } 
        }
    }

    default public void deleteAccount(WebDriver driver){
        HomePage links = new HomePage(driver);

        for (WebElement link : links.homeLinks()) {
            String text = link.getText();
            
            if (text.contains("Delete")) {
                link.click();
                System.out.println("*** Clicked on Delete Account link");
                break;
            } 
        }
    }    
}
