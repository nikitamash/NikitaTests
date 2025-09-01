import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By backpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By bikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By TShirtButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By removeBikeLightButton = By.id("remove-sauce-labs-bike-light");
    private By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    private By removeTShirtButton= By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private static CartPage cartPage;

    CartPage(WebDriver driver) {
        super(driver);
    }

        public void addBackpackToCart() {
        click(backpackButton);
    }

        public void addBikeLightToCart() {
        click(bikeLightButton);
    }

        public void TShirtButton() {
        click(TShirtButton);
    }

        public void checkoutButton() {
            click(checkoutButton);
    }

        public void clickBackButton() {
            click(continueShoppingButton);
        }

        public void removeBikeLightFromCart() {
            click(removeBikeLightButton);
        }

        public void removeBackpackFromCart() {
            click(removeBackpackButton);
    }
        public void removeTShirtButton() {
        click(removeTShirtButton);
    }
        public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        navigateToPage("https://www.saucedemo.com/cart.html");
}
}