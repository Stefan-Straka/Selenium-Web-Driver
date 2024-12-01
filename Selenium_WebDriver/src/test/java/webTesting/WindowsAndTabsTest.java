package webTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowsAndTabsTest {


    private static WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        // driver setup
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();

    }


    @Test
    public void WindowsAndTabs() {

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String handleTab1 = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://the-internet.herokuapp.com/");
        String handleWindow2 = driver.getWindowHandle();
        driver.switchTo().window(handleTab1);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.saucedemo.com/");
        // driver.close();     // will close current tab
        // driver.switchTo().window(handleWindow2).close();    //close window



        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            System.out.println("Switch to tab: " + handle);
            driver.switchTo().window(handle);

            // Print title of the current tab
            System.out.println("Current tab title: " + driver.getTitle());
        }


    }


    @AfterClass
    public void tearDown() {
        // driver.quit();
    }

}
