import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userNameField = By.id("user-name");
    private By userPasswordField = By.id("password");
    private By loginButton = By.id("login-button");
    private String defaultUser = "standard_user";
    private String defaultPassword = "secret_sauce";

    LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername() {
        enterText(userNameField, defaultUser);
    }

    public void enterUsername(String username) {
        enterText(userNameField, username);
    }

    public void enterPassword() {
        enterText(userPasswordField, defaultPassword);
    }

    public void enterPassword(String password) {
        enterText(userPasswordField, password);
    }

    public void pressLoginButton() {
        click(loginButton);
    }


    public String checkTitle() {
        return driver.getTitle();
    }
}
