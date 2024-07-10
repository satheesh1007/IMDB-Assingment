import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IMDbRegistrationTest {
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
    public void RegistrationPage() {
        // Given the user is on the IMDb homepage
        driver.get("https://www.imdb.com/");

        // When I click the 'Sign In' link and then click the 'Create a New Account' link
        imdbHomePage.clickSignInLink();
        imdbHomePage.clickCreateAccountLink();

        // Fill in the registration form
        registrationPage.enterCustomerName("satheeesh");
        String email = "satheeshskk@gmail.com";
        registrationPage.enterEmail(email);
        registrationPage.enterPassword("password123");
        registrationPage.enterConfirmPassword("password123");
        // Submit the registration form
        registrationPage.clickCreateAccountButton();

        // Then I should be able to complete the registration process and land on the authorized member page
        Assert.assertTrue(driver.getCurrentUrl().contains("your-account"), "User registration failed");

        driver.quit();
    }
}
