import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class IMDbMemberPage {
    private WebDriver driver;

    public IMDbMemberPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickSignoutButton()throws Exception {
        WebElement accountdropdown = driver.findElement(By.xpath("//label[@class='ipc-btn ipc-btn--single-padding ipc-btn--center-align-content ipc-btn--default-height ipc-btn--core-baseAlt ipc-btn--theme-baseAlt ipc-btn--on-textPrimary ipc-text-button navbar__flyout__text-button-after-mobile navbar__user-menu-toggle__button']"));
        WebElement signout = driver.findElement(By.xpath("//a[@class='ipc-list__item imdb-header-account-menu__sign-out']"));
        accountdropdown.click();
        Thread.sleep(1000);
        signout.click();
        Thread.sleep(1000);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(accountdropdown).moveToElement(signout).build().perform();

    }

}
