package webTesting;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Screenshots_Test
    {


     private static WebDriver driver;

        @BeforeClass
        public void setUp(){

        driver = new ChromeDriver();


        // driver setup
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://app.hubspot.com/login");
        }
        @Test
        public void Test() throws IOException
            {

            // screenshot of login button
            WebElement login_button = driver.findElement(By.xpath("//button[@id='loginBtn']"));
            vytvor_printscreen(login_button, "./target/screenshots/snimka1.png");

            // screenshot of password field
            WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
            vytvor_printscreen(password, "./target/screenshots/snimka2.png");

            }

            @Test
            public void snimka_celej_obr() throws IOException
                {
                // fullscreen screenshot
                File snimka_celej = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(snimka_celej, new File("./target/screenshots/cela_obr.png"));

                }

    // method for screenshots
    private static void vytvor_printscreen(WebElement web_elemnt, String pathname) throws IOException
        {
        File snimka = web_elemnt.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(snimka, new File(pathname));
        }


    @AfterClass
        public void tearDown(){
            //driver.quite();
        }

    }
