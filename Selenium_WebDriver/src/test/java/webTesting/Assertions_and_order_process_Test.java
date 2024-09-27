package webTesting;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assertions_and_order_process_Test
    {

    private static WebDriver driver;

    @BeforeClass
    public void setUp(){

    driver = new ChromeDriver();


    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().deleteAllCookies();

    }

    @Test
    public void TestPrihlasenia()
        {
        driver.navigate().to("https://www.saucedemo.com/");

        //Login
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
            username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
            password.sendKeys("secret_sauce");
        WebElement login_button = driver.findElement(By.xpath("//input[@id='login-button']"));
            login_button.click();


        //Asserting If I logged successfully
        String actual_URL = driver.getCurrentUrl();
        String expected_URL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actual_URL, expected_URL);



        WebElement backpack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
            backpack.click();
        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
            cart.click();


        // Checking if button 'Continue shopping' is available
        WebElement Continue_shopping = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
        boolean is_button_available = Continue_shopping.isDisplayed();
        Assertions.assertTrue(is_button_available);

        // filling order formular
        WebElement Checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
            Checkout.click();
        WebElement first_name = driver.findElement(By.xpath("//input[@id='first-name']"));
            first_name.sendKeys("Jim");
        WebElement last_name = driver.findElement(By.xpath("//input[@id='last-name']"));
            last_name.sendKeys("Brown");
        WebElement postal_code = driver.findElement(By.xpath("//input[@id='postal-code']"));
            postal_code.sendKeys("81103");
        WebElement continue_button = driver.findElement(By.xpath("//input[@id='continue']"));
            continue_button.click();
            WebElement finish_button = driver.findElement(By.xpath("//button[@id='finish']"));
        finish_button.click();


        // Checking if website display 'Thank you for your order!' message
        WebElement completed_order_message = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String actual_message_text = completed_order_message.getText();
        String expected_message_text = "Thank you for your order!";
        Assertions.assertTrue(actual_message_text.contains(expected_message_text));

        WebElement backHome_button = driver.findElement(By.xpath("//button[@id='back-to-products']"));
        backHome_button.click();


        //Logout
        WebElement burger_button = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        burger_button.click();
        WebElement logout_button = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        logout_button.click();

        }



    @AfterClass
    public void tearDown(){
    //driver.quite();
    }

    }
