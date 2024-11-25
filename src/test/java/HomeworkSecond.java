import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomeworkSecond extends Base{
@Test
    public void authPositive(){
    browser.get("https://www.saucedemo.com/");

    WebElement username = browser.findElement(By.xpath("//input[@placeholder='Username']"));
    WebElement password = browser.findElement(By.xpath("//input[@placeholder='Password']"));
    WebElement login = browser.findElement(By.xpath("//input[@id='login-button']"));

    username.sendKeys("standard_user");
    password.sendKeys("secret_sauce");
    login.click();

    assertEquals("https://www.saucedemo.com/inventory.html",browser.getCurrentUrl());
}
@Test
    public void authNegative(){
    browser.get("https://www.saucedemo.com/");

    WebElement username = browser.findElement(By.xpath("//input[@placeholder='Username']"));
    WebElement password = browser.findElement(By.xpath("//input[@placeholder='Password']"));
    WebElement login = browser.findElement(By.xpath("//input[@id='login-button']"));

    username.sendKeys("standard_user");
    password.sendKeys("secret_sauc");
    login.click();

    WebElement error = browser.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']"));
    // Check element in website
    assertTrue(error.isDisplayed());
}
}
