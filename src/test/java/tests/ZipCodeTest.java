package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ShareLanePage;

import static org.testng.Assert.assertEquals;

public class ZipCodeTest extends BaseTest {

    ShareLanePage shareLanePage;

    @BeforeMethod
    public void openPage() {
        shareLanePage = new ShareLanePage(getDriver());
        getDriver().get("https://sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void checkZipCode4digitsNumbersTest() {
        shareLanePage.setZipCodeAndClickContinueButton("1234");
        assertEquals(shareLanePage.getErrorMessage().getText(), "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void checkZipCode4digitsLettersTest() {
        shareLanePage.setZipCodeAndClickContinueButton("AAAAA");
        assertEquals(shareLanePage.getErrorMessage().getText(), "Oops, error on page. ZIP code should have 5 digits");
    }
}
