import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IMDbLoginPage {
        private WebDriver driver;
        private final By  emailInput = By.id("ap_email");
        private final By passwordInput = By.id("ap_password");
        private final By loginButton = By.xpath("//input[@id='signInSubmit']");

        public IMDbLoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void fillInLoginCredentials(String email, String password) {
            driver.findElement(emailInput).sendKeys(email);
            driver.findElement(passwordInput).sendKeys(password);
        }

        public void clickLoginButton() {
            driver.findElement(loginButton).click();
        }
    }

