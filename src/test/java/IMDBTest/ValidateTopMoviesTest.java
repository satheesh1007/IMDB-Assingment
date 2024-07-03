package IMDBTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ValidateTopMoviesTest {
    @Test
    public void validatetopmovies()throws Exception{

        WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //WebDriverWait wait = new WebDriverWait(driver,10);
//        try {

            driver.get("https://www.imdb.com/");

            WebElement menubutton = driver.findElement(By.id("imdbHeader-navDrawerOpen"));
            menubutton.click();

            WebElement top250link = driver.findElement(By.xpath("//a[contains(.,'Top 250 Movies')]"));
            top250link.click();
            Thread.sleep(10000);


            List<WebElement> movieElements = driver.findElements(By.cssSelector(".lister-list tr"));
            ArrayList<String> topRatedMovies = new ArrayList<>();


            for (WebElement movieElement : movieElements) {
                String ratingText = movieElement.findElement(By.cssSelector(".imdbRating strong")).getText();

                double rating = Double.parseDouble(ratingText);
                if (rating >= 9.0) {
                    String movieTitle = movieElement.findElement(By.cssSelector(".titleColumn a")).getText();
                    topRatedMovies.add(movieTitle);
                    System.out.println(movieTitle);
                }
            }

//        assertEquals("number of movies with 9+ rating is not 7",7, topRatedMovies.size());
//
//        assertTrue("The Shawshank Redemption is not in the list of top-rated movies",topRatedMovies.contains("The Shawshank Redemption"));

//            Assert.assertEquals(topRatedMovies.size(), 7, "There are not 7 movies with a 9+ rating");

             Assert.assertTrue(topRatedMovies.contains("The Shawshank Redemption"),"The Shawshank Redemption is not in the list of 9+ rated movies");
//        }finally {

                driver.quit();
//            }
        }


    }


