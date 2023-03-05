package ravn.Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ravn.Contexts.*;

public interface SignUpPageFunctions extends Waits{

    default public void setTitle(WebDriver driver, String title){

        System.out.println("\nAutomation practice: Sign Up Registration Page\n");

        SignUpPage element = new SignUpPage(driver);

        for(WebElement rb: element.radioButtons()){
            if(rb.getAttribute("value").contains(title)){
                rb.click();
                System.out.println("*** Clicked on " +title+ " radiobutton");
                break;
            }
        }
    }

    default public void enterPassword(WebDriver driver, String password){
        SignUpPage element = new SignUpPage(driver);

        element.passwordField().click();
        element.passwordField().sendKeys(password);
        System.out.println("*** Password entered");
    }

    default public void setDob(WebDriver driver, String date){
        SignUpPage element = new SignUpPage(driver);

        String [] splitDate = date.split("/");
        int dropdowns = element.getDropdowns().size();

        for(int i=0; i<dropdowns; i++){
            Select select = new Select(element.getDropdowns().get(i));

            if(i==0){
                element.getDropdowns().get(i).click();
                select.selectByVisibleText(splitDate[0]);
                System.out.println("*** Selected day in dropdown: " + splitDate[0]);

            } else if(i==1){
                element.getDropdowns().get(i).click();
                select.selectByVisibleText(splitDate[1]);
                System.out.println("*** Selected month in dropdown: " + splitDate[1]);

            } else if(i==2){
                element.getDropdowns().get(i).click();
                select.selectByVisibleText(splitDate[2]);
                System.out.println("*** Selected year in dropdown: " + splitDate[2]);

            }
        }
    }

    default public void selectCheckboxes(WebDriver driver){
        SignUpPage element = new SignUpPage(driver);

        for(WebElement cb: element.getCheckBoxes()){
            cb.click();
            System.out.println("*** Clicked on: " + cb.getAttribute("name") + " checkbox");
        }
    }
    
}
