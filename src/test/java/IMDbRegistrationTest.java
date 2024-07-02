import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class IMDbRegistrationTest {
    @Test
    public void preventRegistrationWithExistingEmail() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));



        try {
            // Navigate to IMDb homepage
            driver.get("https://www.imdb.com/");

            // Click the 'Sign In' link
            driver.findElement(By.linkText("Sign In")).click();

            // Click the 'Create a New Account' link
            driver.findElement(By.linkText("Create a New Account")).click();

            // Verify redirection to account registration page
            Assert.assertTrue(driver.getTitle().contains("Registration"), "Not on the registration page");

            // Fill in the registration form with an existing email
            driver.findElement(By.id("ap_customer_name")).sendKeys("Test User");
            driver.findElement(By.id("ap_email")).sendKeys("testemail@gmail.com");
            driver.findElement(By.id("ap_password")).sendKeys("Password123!");
            driver.findElement(By.id("ap_password_check")).sendKeys("Password123!");

            // Submit the registration form
            driver.findElement(By.id("continue")).click();

            // Verify the error message for existing email
            WebElement errorMessage = driver.findElement(By.xpath("//div[@id='auth-error-message-box']//span"));
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed");
            Assert.assertTrue(errorMessage.getText().contains("already in use"), "Error message text is incorrect or missing");

        } finally {
            // Quit the driver to close the browser
            driver.quit();
        }
    }
}

