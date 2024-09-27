package webTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hover_and_wait_types_Test
    {

     private static WebDriver driver;

        @BeforeClass
        public void setUp(){


        driver = new ChromeDriver();


        // driver setup
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().to("https://www.alza.sk/");


        }
        @Test
        public void Test()
            {
                // Hover over to show products
                WebElement hover = driver.findElement(By.xpath("//a[text()='Veľké spotrebiče']"));
                Actions action = new Actions(driver);
                action.moveToElement(hover).perform();


            // explicit wait
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Veľké spotrebiče']")));


            // fluent wait
            Wait<WebDriver> wait_fluent = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            wait_fluent.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Veľké spotrebiče']")));


            }



    @AfterClass
        public void tearDown(){
            //driver.quite();
        }

    }
