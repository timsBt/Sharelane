package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ShareLanePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    ShareLanePage shareLanePage;

    @BeforeMethod
    public void openPage() {
        shareLanePage = new ShareLanePage(getDriver());
        getDriver().get("https://sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void loginTest() {
        shareLanePage.setZipCodeAndClickContinueButton("12345");
        assertTrue(shareLanePage.getRegisterButton().isDisplayed());
        shareLanePage.registration("Timur", "Bekmatov", "timur@mail.ru", "12345678", "12345678");
        assertEquals(shareLanePage.getConfirmationMessage().getText(), "Account is created!");
        String email = shareLanePage.getEmailText().getText();
        String pass = shareLanePage.getPasswordText().getText();
        shareLanePage.getReturnToHomePageButton().click();
        assertTrue(shareLanePage.getLoginButton().isDisplayed());
        shareLanePage.authorization(email, pass);
        assertTrue(shareLanePage.getLogoutButton().isDisplayed());
        String nameUser = email.substring(0, 1).toUpperCase() + email.substring(1).replaceAll("_.*", "");
        assertEquals(shareLanePage.getUserHelloText().getText(), "Hello " + nameUser);
    }
}
