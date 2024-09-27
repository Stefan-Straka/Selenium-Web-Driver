package webTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframe_and_alert_Test
    {

     private static WebDriver driver;

        @BeforeClass
        public void setUp(){

        driver = new ChromeDriver();


        // driver setup
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();

        }
        @Test
        public void Test()
            {

            driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
            // accept cookies
            driver.findElement(By.xpath("//div[@id='accept-choices']")).click();

            // switch to the result frame(right side frame)
            WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
            driver.switchTo().frame(frame1);
            //accepting alert
            driver.findElement(By.xpath("//button[text()='Try it']")).click();
            driver.switchTo().alert().accept();


            //go back to main frame
            driver.switchTo().parentFrame();

            }



    @AfterClass
        public void tearDown(){
            //driver.quite();
        }

    }
