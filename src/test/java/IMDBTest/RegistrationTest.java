package IMDBTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest {
    @Test
    public void navigateToAccountRegistration() throws Exception {
        // Set the path to the ChromeDriver executable
        // System.setProperty("webdriver.chrome.driver", "path_to_chrome_driver");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Navigate to IMDb homepage
        driver.get("https://www.imdb.com/");

        // Click the 'Sign In' link
        driver.findElement(By.linkText("Sign In")).click();

        // Click the 'Create a New Account' link
        driver.findElement(By.xpath("//a[normalize-space()='Create a New Account']")).click();

        // Verify redirection to account registration page
        Assert.assertTrue(driver.getTitle().contains("Registration"), "Not on the registration page");

        // Fill in the registration form
        driver.findElement(By.xpath("//input[@placeholder='First and last name']")).sendKeys("satheeesh");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("satheeshs@gmail.com");
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Password123!");
        driver.findElement(By.xpath("//input[@name='passwordCheck']")).sendKeys("Password123!");

        // Submit the registration form
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(5000);
        // Verify successful registration
        Assert.assertTrue(driver.getCurrentUrl().contains("your-account"), "User registration failed");



        // Quit the driver to close the browser
        driver.quit();
    }

}