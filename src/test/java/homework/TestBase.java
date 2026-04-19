package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;
    ApplicationManager app = new ApplicationManager();
    @BeforeMethod
    public void setUp(){
        app.init();
        driver = app.getDriver();
    }
    @AfterMethod
    public  void tearDown(){
        app.stop();
    }

}
