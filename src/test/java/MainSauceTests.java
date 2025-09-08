import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MainSauceTests {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static InventoryPage inventoryPage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    @Order(1)
    @DisplayName("Login Test")
    public void loginTest() {
        loginPage.performLogin();
        inventoryPage.goToCart();
        //Assertions.assertEquals("Swag Labs", loginPage.checkTitle(), "Title doesn't match");
    }

    @Test
    @DisplayName("loginTestProblemUser")
    public void loginTestProblemUser() {
        loginPage.performLogin("problem_user", "secret_sauce");
        inventoryPage.goToCart();
    }

    @Test
    @Order(2)
    public void removeBackpackFromCartTest() {
        loginPage.performLogin();
        inventoryPage.addBackpackToCart();
        //inventoryPage.removeBackpackFromCart();
        inventoryPage.removeItem("sauce-labs-backpack");
    }

    @Test
    @Order(3)
    public void addBikeLightTest() {
        loginPage.performLogin();
        //inventoryPage.addBikeLightToCart();
        inventoryPage.addItem("sauce-labs-bike-light");
    }

    @Test
    @Order(4)
    public void removeBikeLightTest() {
        loginPage.performLogin();
        inventoryPage.addBikeLightToCart();
        //inventoryPage.removeBikeLightFromCart();
        inventoryPage.removeItem("sauce-labs-bike-light");
    }

    @Test
    @Order(5)
    public void navigateToCart() {
        loginPage.performLogin();
        inventoryPage.goToCart();
    }

    @Test
    @Order(5)
    public void navigateToCartAndGoBack() {
        loginPage.performLogin();
        inventoryPage.goToCart();
        cartPage.clickBackButton();
    }

    @Test
    @Order(5)
    public void navigateToCartAndPerformCheckout() {
        loginPage.performLogin();
        inventoryPage.goToCart();
        cartPage.checkoutButton();
    }

    @Test
    @Order(5)
    public void navigateToCartAndCheckoutBackpack() {
        loginPage.performLogin();
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();
        cartPage.checkoutButton();
    }

    @Test
    public void navigateToCartAndCheckoutTShirt() {
        loginPage.performLogin();
        inventoryPage.addBackpackToCart();
        inventoryPage.addItem("sauce-labs-bolt-t-shirt");
        inventoryPage.addItem("sauce-labs-fleece-jacket");
        inventoryPage.goToCart();
        cartPage.checkoutButton();
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.enterZipCode();
        checkoutPage.pressContinueButton();
        checkoutPage.pressCancelButton();
    }


    @Test
    @Order(6)
    @DisplayName("Logout Test")
    public void logoutTest() {
        loginPage.performLogin();
        inventoryPage.pressMenuButton();
        inventoryPage.pressLogoutButton();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
