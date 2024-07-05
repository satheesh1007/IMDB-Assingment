package IMDBTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class IMDbRegistrationTest {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to IMDb homepage
        driver.get("https://www.imdb.com/");

        // Click on the 'Menu' to view the Menu panel
        driver.findElement(By.id("imdbHeader-navDrawerOpen")).click();

        // Select the 'Top 250 Movies' sub-link
        driver.findElement(By.xpath("//a[contains(.,'Top 250 Movies')]")).click();

        // Collect all movies with a 9+ rating into an ArrayList
        List<WebElement> movies = driver.findElements(By.xpath("//td[@class='ratingColumn']//strong[contains(text(), '9')]"));
        ArrayList<String> movieTitles = new ArrayList<>();
        for (WebElement movie : movies) {
            movieTitles.add(movie.findElement(By.xpath("./ancestor::td/preceding-sibling::td/a")).getText());
        }

        // Validate the number of movies is 7 in the ArrayList
        Assert.assertEquals(movieTitles.size(), 7);

        // Validate that the movie "The Shawshank Redemption" is listed in the ArrayList
        Assert.assertTrue(movieTitles.contains("The Shawshank Redemption"));
    }
}

