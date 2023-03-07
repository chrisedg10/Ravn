package ravn.Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ravn.Contexts.*;

public interface LoginFunctions extends Waits{

    default public void getSignUpBanner(WebDriver driver){

        System.out.println("\nAutomation practice: Login page\n");

        LoginPage login = new LoginPage(driver);

        waitUntilElementIsVisible(driver, login.signUpBanner());

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

    default public void enterNewCredentials(WebDriver driver, String name, String email) throws IOException{
        LoginPage login = new LoginPage(driver);

        String refactoredEmail = refactorEmail(email);

        login.nameInput().sendKeys(name);
        System.out.println("*** Entered " + name + " in name field");

        login.emailInput().sendKeys(refactoredEmail);
        System.out.println("*** Entered " + refactoredEmail + " in email field");

        String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "ravn" + File.separator + "TestFile" + File.separator + "credentials.txt";

        FileWriter writer = new FileWriter(path);
            writer.write(refactoredEmail);
            writer.close();
        
        login.signUpButton().click();
        System.out.println("*** Clicked on Sign Up button");

    }

    default public void negativeLogin(WebDriver driver, String email, String password){
        LoginPage login = new LoginPage(driver);

        waitUntilElementIsVisible(driver, login.logInBanner());

        String refactoredEmail = refactorEmail(email);

        login.logInEmail().sendKeys(refactoredEmail);
        System.out.println("*** Entered " + refactoredEmail + " in Email Field");

        login.logInPassword().sendKeys(password);
        System.out.println("*** Entered Password");

        login.logInButton().click();
        System.out.println("*** Clicked on Login button");

        try {
            Assert.assertTrue(login.logInErrorMessage().isDisplayed());
            try{
                System.out.println("*** The following error was displayed: " + login.logInErrorMessage().getText());
            } catch (AssertionError e){
                System.out.println("Assert failed: " + e.getMessage());
            }
        } catch (AssertionError e) {
            System.out.println("Assert failed: " + e.getMessage());
        }

        System.out.println("\n*** Execution Finished ***\n");

    }

    default public void LogIn(WebDriver driver, String password) throws IOException{

        System.out.println("\nAutomation practice: Login page\n");
        LoginPage login = new LoginPage(driver);

        String path = "src" + File.separator + "main" + File.separator + "java" + File.separator + "ravn" + File.separator + "TestFile" + File.separator + "credentials.txt";

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        bufferedReader.close();
        fileReader.close();

        login.logInEmail().sendKeys(line);
        System.out.println("*** Entered " + line + " in Email Field");

        login.logInPassword().sendKeys(password);
        System.out.println("*** Entered Password");

        login.logInButton().click();
        System.out.println("*** Clicked on Login button");

    }
}
