package IMDBTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IMDBPreventRegistrationWithExistingEmail {
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

        driver.findElement(By.xpath("//input[@placeholder='First and last name']")).sendKeys("satheeesh");
        // Enter email that is already in use
        String email = "testemail@gmail.com";
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(email);
        // Enter password
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Password123!");
        driver.findElement(By.xpath("//input[@name='passwordCheck']")).sendKeys("Password123!");
        // Click register button
        driver.findElement(By.xpath("//input[@id='continue']")).click();

        // Verify error message is displayed
        String errorMessage = driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
        String expectedErrorMessage = "You indicated you're a new customer, but an account already exists with the email address "+email+".";
       // Assert.assertEquals(errorMessage.getText().equals(expectedErrorMessage),"Error message mismatch");
        Assert.assertEquals(errorMessage,expectedErrorMessage);
        // Wait for error message to be displayed

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
