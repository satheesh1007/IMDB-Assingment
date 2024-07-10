import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

        private final WebDriver driver;

        private final By customerName = By.id("ap_customer_name");
        private final By emailInput = By.id("ap_email");
        private final By passwordInput = By.id("ap_password");
        private final By confirmPasswordInput = By.id("ap_password_check");
        private final By createAccountButton = By.xpath("//input[@id='continue']");
        private final By errorMessage = By.xpath("//span[@class='a-list-item']");


        public RegistrationPage(WebDriver driver) {
            this.driver = driver;
        }
        public void enterCustomerName(String customerName1){
            driver.findElement(customerName).sendKeys(customerName1);

        }

        public void enterEmail(String email) {
            driver.findElement(emailInput).sendKeys(email);
        }

        public void enterPassword(String password) {
            driver.findElement(passwordInput).sendKeys(password);
        }

        public void enterConfirmPassword(String confirmPassword) {
            driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        }

        public void clickCreateAccountButton() {
            driver.findElement(createAccountButton).click();
        }

        public String GetText(){
            return driver.findElement(errorMessage).getText();
        }
    }

