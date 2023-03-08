package ravn.Functions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ravn.Contexts.*;

public interface AccountVerificationFunctions extends Waits{
    default public void verifyTitle(WebDriver driver, String title){
        System.out.println("\nAutomation practice: Confirmation page\n");

        AccountVerificationPage element = new AccountVerificationPage(driver);
        waitUntilElementIsVisible(driver, element.verificationTitle());

        String text = element.verificationTitle().getText();

        Assert.assertEquals(text, title);
        System.out.println("*** " + text + " is visible");

    }

    default public void completeValidation(WebDriver driver){
        AccountVerificationPage element = new AccountVerificationPage(driver);

        waitUntilElementIsClickable(driver, element.continueButton());
        element.continueButton().click();
        System.out.println("*** Clicked on Continue Button");
        
    }

    default public void closeAdd(WebDriver driver){
        AdvertisementLocators ad = new AdvertisementLocators(driver);
        AccountVerificationPage element = new AccountVerificationPage(driver);

        implicitWait(driver);

        if(ad.addContainer().isEnabled()){
            System.out.println("*** Ad Element Found");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].remove()", ad.addContainer());
            System.out.println("*** Clicked on Close Add Button");
        }

        if(element.continueButton().isDisplayed()){
            element.continueButton().click();
        }
        
        driver.navigate().refresh();
    }
}
