package IMDBTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogoutAndLoginTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void logoutAndLogin() {
        // Given the user is on the IMDb homepage
        driver.get("https://www.imdb.com/");
        // And I am logged into the member page
         loginToIMDb("satheeshas1012@gmail.com", "Password123!");

        // When I log out from the application
         logoutFromIMDb();

        // Then I should be redirected to the login page and not be able to access the member page
         String loginPageUrl = "https://www.imdb.com/ap/signin";
         String currentPageUrl = driver.getCurrentUrl();
         assert currentPageUrl.equals(loginPageUrl);
        try {
            driver.findElement(By.id("imdb-header-user-menu")).isDisplayed();
            assert false; // Should not be able to access member page
        } catch (Exception e) {
            // Expected exception
        }

        // When I am on the login page
        driver.get(loginPageUrl);

        // And I fill in my email and password correctly
        loginToIMDb("satheeshas1012@gmail.com", "Password123!");

        // Then I should be able to login and access the member page again
        try {
            driver.findElement(By.id("imdb-header-user-menu")).isDisplayed();
            assert true; // Should be able to access member page
        } catch (Exception e) {
            assert false; // Should not throw exception
        }
    }

    private void loginToIMDb(String email, String password) {
        driver.findElement(By.xpath("//a[@class='ipc-btn ipc-btn--single-padding ipc-btn--center-align-content ipc-btn--default-height ipc-btn--core-baseAlt ipc-btn--theme-baseAlt ipc-btn--on-textPrimary ipc-text-button imdb-header__signin-text']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Sign in with IMDb']")).click();
        driver.findElement(By.id("ap_email")).sendKeys(email);
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
    }
    private void logoutFromIMDb() {
        driver.findElement(By.id("imdb-header-navDrawerButton")).click();
        driver.findElement(By.id("Sign out")).click();
        //WebElement Signout = ();
//            new Actions(getClass())
//                    .moveToElement(Signout)
//                            .click()
//                                    .perform();
//            Thread.sleep(5000);


    }
}

