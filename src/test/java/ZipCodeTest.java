import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZipCodeTest extends BaseTest {

    ZipCodePage zipCodePage;

    @BeforeMethod
    public void openPage() {
        zipCodePage = new ZipCodePage(getDriver());
        getDriver().get("https://sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void checkZipCode4digitsNumbersTest() {
        zipCodePage.setZipCodeAndClickContinueButton("1234");
        Assert.assertEquals(zipCodePage.getErrorMessage(), "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void checkZipCode4digitsLettersTest() {
        zipCodePage.setZipCodeAndClickContinueButton("AAAAA");
        Assert.assertEquals(zipCodePage.getErrorMessage(), "Oops, error on page. ZIP code should have 5 digits");
    }
}
