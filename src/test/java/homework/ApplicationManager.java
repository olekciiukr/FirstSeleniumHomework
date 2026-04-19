package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;
    BaseHelper base;
    UserHelper user;
    ItemHelper item;

    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        base = new BaseHelper(driver);
        user = new UserHelper(driver);
        item = new ItemHelper(driver);
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void stop() {
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public BaseHelper getBase() {
        return base;
    }
    public UserHelper getUser() {
        return user;
    }
    public ItemHelper getItem() {
        return item;
    }
}
