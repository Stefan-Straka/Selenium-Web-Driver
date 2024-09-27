package webTesting;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Scroll_down_and_all_links_Test
    {


     private static WebDriver driver;

        @BeforeClass
        public void setUp(){

            driver = new ChromeDriver();


            // driver setup
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


            driver.navigate().to("https://automationexercise.com/signup");
            //consent click
            driver.findElement(By.xpath("//p[@class='fc-button-label' and text()='Consent']")).click();

        }


            @Test
            public void snimka_celej_obr()
                {
                    // login
                    driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Adam");
                    driver.findElement(By.xpath("//input[@name='email' and @data-qa='signup-email']")).sendKeys("adam123@gmail.com");
                    driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']")).click();

                // selecting date and newsletter
                driver.findElement(By.xpath("//select[@id='days']")).click();
                driver.findElement(By.xpath("//option[@value='4']")).click();
                driver.findElement(By.xpath("//input[@id='newsletter']")).click();


                // testing if special offers checkbox is not checked by default
                WebElement box = driver.findElement(By.xpath("//input[@id='optin']"));
                boolean ch_box = box.isSelected();
                Assertions.assertFalse(ch_box);

                // scroll down
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,350)");


                }

                @Test
                public void allLinks(){

                List<WebElement> alltags = driver.findElements(By.tagName("a"));
                System.out.println("All links: "+alltags.size());



                for (int i = 0; i < alltags.size(); i++) {
                    System.out.println("tags: "+alltags.get(i).getAttribute("href"));
                    System.out.println("tags: "+alltags.get(i).getText());
                }

                }



    @AfterClass
        public void tearDown(){
            //driver.quite();
        }

    }
