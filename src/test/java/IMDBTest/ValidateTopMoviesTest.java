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

import static org.testng.AssertJUnit.assertEquals;

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

            WebElement top250link = driver.findElement(By.xpath("//span[normalize-space()='Top 250 Movies']"));
            top250link.click();
            Thread.sleep(10000);


            List<WebElement> movieElements = driver.findElements(By.xpath("//td[@class='ratingColumn']//strong[contains(text(),'9')]"));

            ArrayList<String> movieTitle = new ArrayList<>();

            for (WebElement movieElement : movieElements) {
                String ratingText = movieElement.findElement(By.xpath("//*[name()='svg']")).getText();

                double rating = Double.parseDouble(ratingText);
               if (rating >= 9.0) {
                    String movieTitles = movieElement.findElement(By.tagName("h3")).getText();
                   movieTitle.add(movieTitles);
                    System.out.println(movieTitles);
                }
            }
            Assert.assertEquals(7,movieTitle.size());

            Assert.assertTrue(movieTitle.contains("The Shawshank Redemption"));

       // assertEquals("number of movies with 9+ rating is not 7",7, topRatedMovies.size());
       //Assert.assertEquals(topRatedMovies.size(), "7" ,"There are not 7 movies with a 9+ rating");
//        assertTrue("The Shawshank Redemption is not in the list of top-rated movies",topRatedMovies.contains("The Shawshank Redemption"));

//            Assert.assertEquals(topRatedMovies.size(), 7, "The number of movies with a 9+ rating is not 7.");
//
//             Assert.assertTrue(topRatedMovies.contains("The Shawshank Redemption"),"The Shawshank Redemption is not in the list of 9+ rated movies");
//
             //System.out.println("TopRatedMovies with 9+ rating:"+topRatedMovies);

//        }finally {

                driver.quit();
//
        }


    }


