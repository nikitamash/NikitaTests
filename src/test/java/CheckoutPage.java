import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By LastName = By.id("last-name");

    protected CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void enterFirstName() {
        enterText(firstName, "Nikita");
    }
    public void enterLastName() {
        enterText(LastName, "Mashanskii");
    }
}

