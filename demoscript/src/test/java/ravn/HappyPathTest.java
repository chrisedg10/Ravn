package ravn;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.testng.annotations.*;

import ravn.Constants.WebDriverBase;
import ravn.Functions.*;

/**
 * Unit test for simple App.
 */
public class HappyPathTest extends WebDriverBase implements HomePageFunctions, LoginFunctions, 
SignUpPageFunctions, AccountVerificationFunctions{
    @Parameters({ "browser", "URL" })
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser, String URL) throws Exception {
        webDriverSetUp(browser);
        driver.get(URL);
        driver.manage().deleteAllCookies();
        System.out.println("\n***Execution Started***\n");
    }

    @Parameters({ "linkText" })
    @Test(priority = 0)
    public void initTest(String linkText){
        verifySelectedLink(driver);
        selectLink(driver, linkText);
    }

    @Parameters({ "name", "email" })
    @Test(priority = 1)
    public void loginPage(String name, String email) throws IOException{
        getSignUpBanner(driver);
        enterNewCredentials(driver, name, email);
    }

    @Parameters({ "title", "password", "dob", "firstName", "lastName", 
    "company", "addLnOne", "addLnTwo", "country", "state", "city", "zipCode", "mobile" })
    @Test(priority = 2)
    public void fillOutInfo(String title, String password, String dob, String fistName, String lastName, String company, 
    String addLnOne, String addLnTwo, String country, String state, String city, String zipCode, String mobile){
        setTitle(driver, title);
        enterPassword(driver, password);
        setDob(driver, dob);
        selectCheckboxes(driver);
        enterAddressInfo(driver, fistName, lastName, company, addLnOne, addLnTwo, country, state, city, zipCode, mobile);
    }

    @Parameters({ "confirmTitle" })
    @Test(priority = 3)
    public void completeCreation(String confirmTitle){
        verifyTitle(driver, confirmTitle);
        completeValidation(driver);
        closeAdd(driver);
    }

    @Parameters({ "name" })
    @Test(priority = 4)
    public void verifyAccount(String name){
        verifyUsername(driver, name);
        logOut(driver);
    }

    @Parameters({ "password", "name" })
    @Test(priority = 5)
    public void LogInApp(String password, String name) throws IOException{
        LogIn(driver, password);
        verifyUsername(driver, name);
    }

    @Parameters({ "deleteTitle" })
    @Test(priority = 6)
    public void closeAccount(String deleteTitle){
        deleteAccount(driver);
        verifyTitle(driver, deleteTitle);
        System.out.println("\n***Execution Finished***\n");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
