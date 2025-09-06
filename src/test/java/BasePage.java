import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String BASE_URL = "https://www.saucedemo.com/";
    //private static LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        //loginPage = new LoginPage(driver);
    }

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void navigateBaseUrl() {
        driver.get(BASE_URL);
    }

    public void click(By id){
        wait.until(ExpectedConditions.elementToBeClickable(id)).click();
        //driver.findElement(id).click();
    }

    public void enterText(By id, String text){
        driver.findElement(id).sendKeys(text);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}