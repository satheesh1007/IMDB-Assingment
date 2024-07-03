package IMDBTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IMDBTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
    @Test
    public void preventRegistrationWithExistingEmail() {
        // Navigate to IMDb homepage
        driver.get("https://www.imdb.com/");

        // Click "Sign In" link
        driver.findElement(By.linkText("Sign In")).click();

        // Click "Create a New Account" link
        driver.findElement(By.linkText("Create a New Account")).click();

        // Wait for registration page to load
          wait.until(ExpectedConditions.titleContains("Create an IMDb account"));

        // Enter email that is already in use
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("testemail@gmail.com");

        // Enter password
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("password123");

        // Click register button
        driver.findElement(By.xpath("//input[@id='continue']")).click();

        // Wait for error message to be displayed
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-alert-content']")));

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='a-alert-content']"));
       Assert.assertTrue(errorMessage.isDisplayed());
       Assert.assertTrue(errorMessage.getText().contains("This email address is already in use"));

        // Verify registration is not completed
       Assert.assertFalse(driver.getTitle().contains("Account Created"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
