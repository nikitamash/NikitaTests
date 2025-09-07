
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By pressCancelButton = By.id("cancel");
    private By pressContinueButton = By.id("continue");


    protected CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName() {
        enterText(firstName, Utils.getFirstName());
    }

    public void enterLastName() {
        enterText(lastName, Utils.getLastName());
    }

    public void enterZipCode() {
        enterText(zipCode, Utils.getZipCode());
    }

    public void pressContinueButton() {
        click(pressContinueButton);
    }

    public void pressCancelButton(){
        click(pressCancelButton);
    }
}

