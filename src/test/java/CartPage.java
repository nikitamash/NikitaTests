import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private static CartPage cartPage;

    CartPage(WebDriver driver) {
        super(driver);
    }

        public void checkoutButton() {
            click(checkoutButton);
    }


        public void clickBackButton() {
            click(continueShoppingButton);
        }

        public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        navigateToPage("https://www.saucedemo.com/cart.html");
    }
}