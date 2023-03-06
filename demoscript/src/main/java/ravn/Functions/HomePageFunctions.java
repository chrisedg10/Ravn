package ravn.Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ravn.Contexts.*;

public interface HomePageFunctions extends Waits{
    
    default public void verifySelectedLink(WebDriver driver){
        System.out.println("\nAutomation practice: Landing page\n");

        HomePage home = new HomePage(driver);

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

        implicitWait(driver);
        waitUntilElementIsVisible(driver, links.slider());

        for (WebElement link : links.homeLinks()) {
            String text = link.getText();
            
            if (text.contains(name)) {
                try{
                    Assert.assertEquals(text, "Logged in as " + name);
                    System.out.println("*** " + text + " is visible");
                } catch (AssertionError e){
                    System.out.println("Assert failed: " + e.getMessage());
                }
                break;
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
        
}
