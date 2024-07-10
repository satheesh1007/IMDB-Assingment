import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IMDBlogoutTest {
        private WebDriver driver;
        private IMDbHomePage imdbHomePage;
        private IMDbLoginPage imdbLoginPage;
        private IMDbMemberPage imdbMemberPage;



        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            imdbHomePage = new IMDbHomePage(driver);
            imdbLoginPage = new IMDbLoginPage(driver);
            imdbMemberPage = new IMDbMemberPage(driver);
        }

        @Test
        public void logoutAndLoginFunctionality() throws Exception{
            driver.get("https://www.imdb.com/");

            // Login to member page
            imdbHomePage.clickSignInLink();
            imdbHomePage.clickGetSignInLink();
            imdbLoginPage.fillInLoginCredentials("satheeshrr1012@gmail.com", "Password123!");
            imdbLoginPage.clickLoginButton();

            // Verify member page title
            Assert.assertEquals("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows", driver.getTitle());

            // Logout from member page

            imdbMemberPage.clickSignoutButton();
            Thread.sleep(5000);
            // Verify login page title
            Assert.assertEquals("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows", driver.getTitle());

            // Login again
            imdbHomePage.clickSignInLink();
            imdbHomePage.clickGetSignInLink();
            Thread.sleep(1000);
            imdbLoginPage.fillInLoginCredentials("ksatheesh1710@gmail.com", "Password123!");
            imdbLoginPage.clickLoginButton();
            Thread.sleep(1000);

            // Verify member page title again
            Assert.assertEquals("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows", driver.getTitle());
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }

