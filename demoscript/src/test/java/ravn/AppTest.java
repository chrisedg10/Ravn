package ravn;

import static org.junit.Assert.fail;

import org.testng.annotations.*;

import ravn.Constants.WebDriverBase;
import ravn.Functions.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends WebDriverBase implements HomePageFunctions{
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

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
