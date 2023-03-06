package ravn;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.testng.annotations.*;

import ravn.Constants.WebDriverBase;
import ravn.Functions.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends WebDriverBase implements HomePageFunctions, LoginFunctions, 
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

    @Test(priority = 3)
    public void completeCreation(){
        verifyTitle(driver);
        completeValidation(driver);
    }

    @Parameters({ "name" })
    @Test(priority = 4)
    public void verifyAccount(String name){
        verifyUsername(driver, name);
        logOut(driver);
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
