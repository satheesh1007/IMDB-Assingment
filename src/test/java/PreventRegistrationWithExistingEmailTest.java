import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


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

            // When I attempt to register with an email "testemail@gmail.com" that is already in use
            registrationPage.enterCustomerName("testuser");
            String email = "testemail@gmail.com";
            registrationPage.enterEmail(email);
            registrationPage.enterPassword("password123");
            registrationPage.enterConfirmPassword("password123");
            registrationPage.clickCreateAccountButton();

            // Then I should see an error message displayed and not be allowed to complete the registration
            String expectedErrorMessage = "You indicated you're a new customer, but an account already exists with the email address "+email+".";
           String error = registrationPage.GetText();
            Assert.assertEquals(error,expectedErrorMessage);
        }

        @AfterMethod
        public void teardown() {
            driver.quit();
        }
    }

