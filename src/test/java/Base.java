import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    WebDriver browser;

    @BeforeMethod
    public void setup(){
        // Open browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browser = new ChromeDriver(options);
    }

    @AfterMethod
    public void closed(){
        browser.close();
    }
}