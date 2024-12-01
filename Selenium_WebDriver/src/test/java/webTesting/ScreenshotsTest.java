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

public class ScreenshotsTest {


    private static WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();


        // driver setup
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void screenshotTest() throws IOException {

        driver.navigate().to("https://app.hubspot.com/login");
        // consent click
        WebElement consent = driver.findElement(By.xpath("//button[@id='hs-eu-confirmation-button']"));
        consent.click();

        // screenshot of login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginBtn']"));
        createPrintscreen(loginButton, "./target/screenshots/snimka1.png");

        // screenshot of Next button
        WebElement nextButton = driver.findElement(By.xpath("//button[@id='loginBtn']"));
        createPrintscreen(nextButton, "./target/screenshots/snimka2.png");

    }

    @Test
    public void fullScreenScreenshot() throws IOException {
        // full screen screenshot
        File fullScreenScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fullScreenScreenshot, new File("./target/screenshots/cela_obr.png"));

    }

    // method for screenshots
    private static void createPrintscreen(WebElement webElement, String pathname) throws IOException {
        File screenshot = webElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(pathname));
    }


    @AfterClass
    public void tearDown() {
         driver.quit();
    }

}
