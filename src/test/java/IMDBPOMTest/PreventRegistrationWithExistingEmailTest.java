package IMDBPOMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class PreventRegistrationWithExistingEmailTest {
        private WebDriver driver;
        private IMDbHomePage imdbHomePage;
        private RegistrationPage registrationPage;
        private WebDriverWait wait;

       // private  wait;

    @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            imdbHomePage = new IMDbHomePage(driver);
            registrationPage = new RegistrationPage(driver);
        }

        @Test
        public void preventRegistrationWithExistingEmail() {
            // Given the user is on the IMDb homepage
            driver.get("https://www.imdb.com/");

            // When I click the 'Sign In' link and then click the 'Create a New Account' link
            imdbHomePage.clickSignInLink();
            imdbHomePage.clickCreateAccountLink();

            // When I am on the account registration page
//            String RegistrationPageTitle = "Create an IMDb account";
//            wait.until(ExpectedConditions.titleContains(RegistrationPageTitle));



            // When I attempt to register with an email "testemail@gmail.com" that is already in use
            registrationPage.enterCustomerName("testuser");
            registrationPage.enterEmail("testemail@gmail.com");
            registrationPage.enterPassword("password123");
            registrationPage.enterConfirmPassword("password123");
            registrationPage.clickCreateAccountButton();

//            WebDriverWait wait = new WebDriverWait(driver, 20);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(registrationPage.isErrorDisplayed()));

            // Then I should see an error message displayed and not be allowed to complete the registration
            Assert.assertTrue(registrationPage.isErrorDisplayed());
        }

        @AfterMethod
        public void teardown() {
            driver.quit();
        }
    }

