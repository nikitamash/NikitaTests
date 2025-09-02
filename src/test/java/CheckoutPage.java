import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By LastName = By.id("last-name");
    private By ZipCode = By.id("postal-code");
    private By pressCancelButton = By.id("cancel");
    private By pressContinueButton = By.id("continue");


    protected CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName() {
        enterText(firstName, "Nikita");
    }

    public void enterLastName() {
        enterText(LastName, "Mashanskii");
    }

    public void enterZipCode() {
        enterText(ZipCode, "9036");
    }

    public void pressContinueButton() {
        click(pressContinueButton);
    }

    public void pressPressCancelButton(){
        click(pressCancelButton);
    }
}

