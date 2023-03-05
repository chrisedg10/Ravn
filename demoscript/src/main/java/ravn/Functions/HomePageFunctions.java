package ravn.Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        
}
