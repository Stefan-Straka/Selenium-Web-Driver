package webTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Windows_and_Tabs_Test
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
            public void oknaAkarty()
                {

                    driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                    String handleTAB1 = driver.getWindowHandle();
                    driver.switchTo().newWindow(WindowType.WINDOW);
                    driver.get("https://the-internet.herokuapp.com/");
                    String handleWindow2 = driver.getWindowHandle();
                    driver.switchTo().window(handleTAB1);
                    driver.switchTo().newWindow(WindowType.TAB);
                    driver.get("https://www.saucedemo.com/");
                    String handleWIN1_TAB2 = driver.getWindowHandle();
                    driver.close();     // will close current tab

                    driver.switchTo().window(handleWindow2).close();    //close window



                /*  code for closing Specific Windows or Tabs

                for (String windowHandle : allWindowHandles) {
                    driver.switchTo().window(windowHandle);

                    // Close the window if some conditions are met"
                    if (driver.getTitle().contains("Example")) {
                        driver.close(); // This will close the current window
                    }
                }
                */



                }



    @AfterClass
        public void tearDown(){
            //driver.quite();
        }

    }
