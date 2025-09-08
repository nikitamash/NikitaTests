import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By backpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By bikeLightButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By removeBikeLightButton = By.id("remove-sauce-labs-bike-light");
    private final By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    private final By backpackRemoveButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By bikeLightRemoveButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addTShirtButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addFleeceJacketButton = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public final By CartPage = By.id("CartPage");

    InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void pressMenuButton() {
        click(menuButton);
    }

    public void pressLogoutButton() {
        click(logoutButton);
    }

    public void addBackpackToCart() {
        click(backpackButton);
    }

    public void addBikeLightToCart() {
        click(bikeLightButton);
    }

    public void removeBikeLightFromCart() {
        click(removeBikeLightButton);
    }

    public void removeBackpackFromCart() {
        click(removeBackpackButton);
    }

    public void removeItem(String item){
        click(By.id("remove-" + item));
    }

    public void addItem (String item) {
     click(By .id("add-" + item));
    }

    public void addTShirtButton() {
        click(addTShirtButton);
    }

    public void addFleeceJacketButton() {
        click(addFleeceJacketButton);
    }

    public void goToCart() {
//        driver.findElement(By.className("shopping_cart_link")).click();
        navigateToPage("https://www.saucedemo.com/cart.html");
    }

    public boolean isBackpackInCart() {
        return driver.findElement(removeBackpackButton).isDisplayed();
    }

    public boolean isBikeLightInCart() {
        return driver.findElement(removeBikeLightButton).isDisplayed();
    }

    public boolean isBackpackRemoved() {
        return driver.findElement(backpackRemoveButton).isDisplayed();
    }

    public boolean isBikeLightRemoved() {
        return driver.findElement(bikeLightRemoveButton).isDisplayed();
    }

    public boolean isCartPage() {
        return driver.getCurrentUrl().contains("CartPage");
    }
}
