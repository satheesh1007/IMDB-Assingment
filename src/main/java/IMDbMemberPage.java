import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IMDbMemberPage {
    private WebDriver driver;
   // private final By logoutButton = By.linkText("Logout");

    private final By signout = By.xpath("//a[@class='ipc-list__item imdb-header-account-menu__sign-out']");


    public IMDbMemberPage(WebDriver driver) {
        this.driver = driver;
    }

//    public void clickLogoutButton() {
//        driver.findElement(logoutButton).click();
//    }

    public void clickSignoutButton() {
        driver.findElement(signout).click();

    }

}
