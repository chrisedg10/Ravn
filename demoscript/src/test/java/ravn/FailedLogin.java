package ravn;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.testng.annotations.*;

import ravn.Constants.WebDriverBase;
import ravn.Functions.*;

public class FailedLogin extends WebDriverBase implements HomePageFunctions, LoginFunctions, 
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
        selectLink(driver, linkText);
    }

    @Parameters({ "email", "password" })
    @Test(priority = 1)
    public void loginPage(String email, String password) throws IOException{
        negativeLogin(driver, email, password);
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
