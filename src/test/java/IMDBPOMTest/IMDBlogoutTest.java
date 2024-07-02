package IMDBPOMTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

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
        public void logoutAndLoginFunctionality() {
            driver.get("https://www.imdb.com/");

            // Login to member page
            imdbHomePage.clickSignInLink();
            imdbHomePage.clickGetSignInLink();
            imdbLoginPage.fillInLoginCredentials("satheeshas1012@gmail.com", "Password123!");
            imdbLoginPage.clickLoginButton();

            // Verify member page title
            Assert.assertEquals("IMDb: Your Account", driver.getTitle());

            // Logout from member page
            //imdbMemberPage.clickSignoutButton();

            WebElement Signout = imdbMemberPage.clickSignoutButton();
            new Actions(getClass())
                    .moveToElement(Signout)
                            .click()
                                    .perform();
            Thread.sleep(5000);


            // Verify login page title
            Assert.assertEquals("IMDb: Login", driver.getTitle());

            // Try to access member page without login
            driver.get("https://www.imdb.com/account");
            Assert.assertEquals("IMDb: Login", driver.getTitle());

            // Login again
            imdbLoginPage.fillInLoginCredentials("satheeshas1012@gmail.com", "Password123!");
            imdbLoginPage.clickLoginButton();

            // Verify member page title again
            Assert.assertEquals("IMDb: Your Account", driver.getTitle());
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }

