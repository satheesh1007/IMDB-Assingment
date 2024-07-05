package IMDBTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LogoutAndLoginTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void logoutAndLogin() throws InterruptedException {
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
    private void logoutFromIMDb() throws InterruptedException {
        //driver.findElement(By.id("imdb-header-navDrawerButton")).click();
//        WebElement SignoutLink = driver.findElement(By.xpath("//a[normalize-space()='Sign out' and @class='desktop-main']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(SignoutLink).build().perform();
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e)
//        {
//            System.out.println("Expection");
//        }
        driver.findElement(By.id("Sign out")).click();
//        WebElement Signout = driver.findElement(Signout);
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(Signout);
//        actions.click();
//        actions.perform();
//        Thread.sleep(5000);


    }
}

