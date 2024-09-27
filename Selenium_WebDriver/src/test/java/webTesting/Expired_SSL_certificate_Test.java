package webTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Expired_SSL_certificate_Test
    {

     private static WebDriver driver;

        @BeforeClass
        public void setUp(){


        //Create instance of chrome options class
        ChromeOptions handlingSSL = new ChromeOptions();
        //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);
        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        WebDriver driver = new ChromeDriver(handlingSSL);




        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://expired.badssl.com/");




        }
        @Test
        public void Test()
            {



            }



    @AfterClass
        public void tearDown(){
            //driver.quite();
        }

    }
