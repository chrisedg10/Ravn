package ravn.Functions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ravn.Contexts.*;

public interface AccountVerificationFunctions extends Waits{
    default public void verifyTitle(WebDriver driver, String title){
        System.out.println("\nAutomation practice: Confirmation page\n");

        AccountVerificationPage element = new AccountVerificationPage(driver);
        waitUntilElementIsVisible(driver, element.verificationTitle());

        String text = element.verificationTitle().getText();

        try {
            Assert.assertTrue(element.verificationTitle().isDisplayed());
            try{
                Assert.assertEquals(text, title);
                System.out.println("*** " + text + " is visible");
            } catch (AssertionError e){
                System.out.println("Assert failed: " + e.getMessage());
            }
        } catch (AssertionError e) {
            System.out.println("Assert failed: " + e.getMessage());
        }
    }

    default public void completeValidation(WebDriver driver){
        AccountVerificationPage element = new AccountVerificationPage(driver);

        element.continueButton().click();
        System.out.println("*** Clicked on Continue Button");
    }
}
