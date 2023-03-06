package ravn.Functions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ravn.Contexts.*;

public interface SignUpPageFunctions extends Waits{

    default public void setTitle(WebDriver driver, String title){

        System.out.println("\nAutomation practice: Sign Up Registration Page\n");

        SignUpPage element = new SignUpPage(driver);

        waitUntilElementIsClickable(driver, element.passwordField());

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
            waitUntilElementIsClickable(driver, element.getDropdowns().get(i));
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
            waitUntilElementIsClickable(driver, cb);
            cb.click();
            System.out.println("*** Clicked on: " + cb.getAttribute("name") + " checkbox");
        }
    }

    default public void enterAddressInfo(WebDriver driver, String firstName, String lastName, 
    String company, String addLnOne, String addLnTwo, String country, String state, String city, String zipCode, String mobile){
        SignUpPage element = new SignUpPage(driver);

        waitUntilElementIsClickable(driver, element.createAccount());

        element.firstName().sendKeys(firstName);
        System.out.println("*** Entered " + firstName + " in First Name field");

        element.lastName().sendKeys(lastName);
        System.out.println("*** Entered " + lastName + " in Last Name field");
        
        element.company().sendKeys(company);
        System.out.println("*** Entered " + company + " in Company field");
        
        element.addressLineOne().sendKeys(addLnOne);
        System.out.println("*** Entered " + addLnOne + " in Address Line One field");
        
        element.addressLineTwo().sendKeys(addLnTwo);
        System.out.println("*** Entered " + addLnTwo + " in Address Line One field");

        Select select = new Select(element.getDropdowns().get(3));
        select.selectByValue(country);

        element.state().sendKeys(state);
        System.out.println("*** Entered " + state + " in State field");

        element.city().sendKeys(city);
        System.out.println("*** Entered " + city + " in City field");

        element.zipcode().sendKeys(zipCode);
        System.out.println("*** Entered " + zipCode + " in ZipCode field");

        element.mobileNumber().sendKeys(mobile);
        System.out.println("*** Entered " + mobile + " in Mobile field");

        element.mobileNumber().sendKeys(Keys.TAB);
        element.createAccount().sendKeys(Keys.ENTER);
        System.out.println("*** Clicked on Create Account button");

    }
    
}
