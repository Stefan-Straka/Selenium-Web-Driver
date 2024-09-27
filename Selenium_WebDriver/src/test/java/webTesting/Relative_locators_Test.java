package webTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Relative_locators_Test
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
            public void lokator_above()
                {

                // login user useing relative lokator below
                driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                WebElement uzivatelske_meno = driver.findElement(By.xpath("//input[@name='username']"));
                uzivatelske_meno.sendKeys("Admin");
                WebElement heslo = driver.findElement(RelativeLocator.with(By.tagName("input")).below(uzivatelske_meno));
                heslo.sendKeys("admin123");
                WebElement login_button = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
                    login_button.click();

                }



    @AfterClass
        public void tearDown(){
            //driver.quite();
        }

    }
