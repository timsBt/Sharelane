import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
