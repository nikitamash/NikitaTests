import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MainSauceTests {
        private static WebDriver driver;
        private static LoginPage loginPage;
        private static InventoryPage inventoryPage;
        private static CartPage cartPage;

        @BeforeEach
        public void setup() {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            loginPage = new LoginPage(driver);
            inventoryPage = new InventoryPage(driver);
            cartPage = new CartPage(driver);
            WebDriverManager.firefoxdriver().setup();
        }


        public void doLogin() {
            loginPage.navigateBaseUrl();
            loginPage.enterUsername();
            loginPage.enterPassword();
            loginPage.pressLoginButton();
        }

        public void doLogin(String user, String password) {
            loginPage.navigateBaseUrl();
            loginPage.enterUsername(user);
            loginPage.enterPassword(password);
            loginPage.pressLoginButton();
        }

        @Test
        @Order(1)
        @DisplayName("Login Test")
        public void loginTest() {
            doLogin();
            inventoryPage.goToCart();
            //Assertions.assertEquals("Swag Labs", loginPage.checkTitle(), "Title doesn't match");
        }

        @Test
        @Order(2)
        public void removeBackpackFromCartTest() {
            doLogin();
            inventoryPage.addBackpackToCart();
            inventoryPage.removeBackpackFromCart();
        }

        @Test
        @Order(3)
        public void addBikeLightTest() {
            doLogin();
            inventoryPage.addBikeLightToCart();
        }

        @Test
        @Order(4)
        public void removeBikeLightTest() {
            doLogin();
            inventoryPage.addBikeLightToCart();
            inventoryPage.removeBikeLightFromCart();
        }

        @Test
        @Order(5)
        public void navigateToCart() {
            doLogin();
            inventoryPage.goToCart();
        }

        @Test
        @Order(5)
        public void navigateToCartAndGoBack() {
            doLogin();
            inventoryPage.goToCart();
            cartPage.clickBackButton();
        }

    @Test
    @Order(5)
    public void navigateToCartAndPerformCheckout() {
        doLogin();
        inventoryPage.goToCart();
        cartPage.checkoutButton();
    }

    @Test
    @Order(5)
    public void navigateToCartAndCheckoutBackpack() {
        doLogin();
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();
        cartPage.checkoutButton();
    }

    @Test
    public void navigateToCartAndCheckoutTShirt() {
        doLogin();
        inventoryPage.addBackpackToCart();
        inventoryPage.addTShirtButton();
        inventoryPage.addFleeceJacketButton();
        inventoryPage.goToCart();
        cartPage.checkoutButton();
    }


        @Test
        @Order(6)
        @DisplayName("Logout Test")
        public void logoutTest() {
            doLogin();
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
