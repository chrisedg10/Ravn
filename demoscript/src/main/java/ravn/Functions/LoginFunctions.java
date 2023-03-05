package ravn.Functions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ravn.Contexts.*;

public interface LoginFunctions extends Waits{

    default public void getSignUpBanner(WebDriver driver){

        System.out.println("\nAutomation practice: Login page\n");

        LoginPage login = new LoginPage(driver);

        String text = login.signUpBanner().getText();

        try {
            Assert.assertTrue(login.signUpBanner().isDisplayed());
            try{
                Assert.assertEquals(text, "New User Signup!");
                System.out.println("*** " + text + " is visible");
            } catch (AssertionError e){
                System.out.println("Assert failed: " + e.getMessage());
            }
        } catch (AssertionError e) {
            System.out.println("Assert failed: " + e.getMessage());
        }
    }

    default public String refactorEmail(String email){
        String [] emailAux = email.split("@");
        String prefix = RandomStringUtils.randomAlphanumeric(5);
        email = emailAux[0] + "+" + prefix + "@" + emailAux[1];
        return email;
    }

    default public void enterNewCredentials(WebDriver driver, String name, String email){
        LoginPage login = new LoginPage(driver);

        String refactoredEmail = refactorEmail(email);

        login.nameInput().sendKeys(name);
        System.out.println("*** Entered " + name + " in name field");

        login.emailInput().sendKeys(refactoredEmail);
        System.out.println("*** Entered " + refactoredEmail + " in email field");
        
        login.signUpButton().click();
        System.out.println("*** Clicked on Sign Up button");

    }
}