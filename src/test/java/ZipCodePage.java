import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZipCodePage {

    /**
     * Конструктор класса для инициализации вэб элементов.
     */
    public ZipCodePage(final WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "zip_code")
    private WebElement zipCode;

    @FindBy(css = "[value = 'Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[@class= 'error_message']")
    private WebElement errorMessage;

    public void setZipCodeAndClickContinueButton(final String code) {
        zipCode.sendKeys(code);
        continueButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
