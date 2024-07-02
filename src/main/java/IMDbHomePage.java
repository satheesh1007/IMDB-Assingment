import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IMDbHomePage {
    private WebDriver driver;
    private By signInLink = By.linkText("Sign In");

    private By getSignInLink = By.xpath("//span[normalize-space()='Sign in with IMDb']");

    private By createAccountLink = By.linkText("Create a New Account");
    public IMDbHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInLink() {
        driver.findElement(signInLink).click();
    }

    public void clickGetSignInLink(){
        driver.findElement(getSignInLink).click();
    }

    public void  clickCreateAccountLink(){
        driver.findElement(createAccountLink).click();
    }

}

