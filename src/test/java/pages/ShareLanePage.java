package pages;

import jdk.jfr.Description;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ShareLanePage {

    public ShareLanePage(final WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "zip_code")
    private WebElement zipCode;

    @FindBy(css = "[value = 'Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[@class= 'error_message']")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@value= 'Register']")
    private WebElement registerButton;

    @FindBy(name = "first_name")
    private WebElement firstName;

    @FindBy(name = "last_name")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password1")
    private WebElement password1;

    @FindBy(name = "password2")
    private WebElement password2;

    @FindBy(xpath = "//span[@class = 'confirmation_message']")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//td[text() = 'Email']//..//b")
    private WebElement emailText;

    @FindBy(xpath = "//td[text() = 'Password']//..//td[2]")
    private WebElement passwordText;

    @FindBy(xpath = "//input[@value = 'Login']")
    private WebElement loginButton;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//a[text() = 'here']")
    private WebElement returnToHomePageButton;

    @FindBy(xpath = "//span[@class = 'user']")
    private WebElement userHelloText;

    @FindBy(xpath = "//a[text() = 'Logout']")
    private WebElement logoutButton;

    @Description("Метод ввода ZipCode")
    public void setZipCodeAndClickContinueButton(final String code) {
        zipCode.sendKeys(code);
        continueButton.click();
    }

    @Description("Метод регистрации")
    public void registration(final String name, final String lastName, final String email, final String password1,
                             final String password2) {
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password1.sendKeys(password1);
        this.password2.sendKeys(password2);
        registerButton.click();
    }

    @Description("Метод авторизации")
    public void authorization(final String email, final String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
