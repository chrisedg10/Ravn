package ravn;

import static org.junit.Assert.fail;

import org.testng.annotations.*;

import ravn.Constants.WebDriverBase;
import ravn.Functions.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends WebDriverBase implements HomePageFunctions, LoginFunctions, SignUpPageFunctions{
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
    public void loginPage(String name, String email){
        getSignUpBanner(driver);
        enterNewCredentials(driver, name, email);
    }

    @Parameters({ "title", "password", "dob" })
    @Test(priority = 2)
    public void fillOutInfo(String title, String password, String dob){
        setTitle(driver, title);
        enterPassword(driver, password);
        setDob(driver, dob);
        selectCheckboxes(driver);
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
