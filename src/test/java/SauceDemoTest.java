package com.example.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SauceDemoTest {
    private WebDriver driver;

    @BeforeAll
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // WebDriverManager скачает драйвер
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void authenticate() {
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void testAddToCart() {
        WebElement addButton = driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"));
        addButton.click();
        WebElement cartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();
        WebElement item = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        Assertions.assertEquals("Sauce Labs Backpack", item.getText());
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
