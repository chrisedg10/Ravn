package ravn;

import static org.junit.Assert.fail;

import org.testng.annotations.*;

import ravn.Constants.WebDriverBase;
import ravn.Functions.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends WebDriverBase implements HomePageFunctions, LoginFunctions{
    @Parameters({ "browser", "URL" })
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser, String URL) throws Exception {
        webDriverSetUp(browser);
        driver.get(URL);
        driver.manage().deleteAllCookies();
        System.out.println("\n***Execution Started***\n");
    }

    @Parameters({ "linkText", "name", "email" })
    @Test(priority = 0)
    public void initTest(String linkText, String name, String email){
        verifySelectedLink(driver);
        selectLink(driver, linkText);
        getSignUpBanner(driver);
        enterNewCredentials(driver, name, email);
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
