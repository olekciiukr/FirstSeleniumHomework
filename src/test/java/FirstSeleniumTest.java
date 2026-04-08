import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    //before-> setUP
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        driver = new ChromeDriver();
        //driver.get("https://www.google.com");//without history
        driver.navigate().to("https://www.google.com");// with history
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    //test
    @Test
    public void openGoogle() {
        System.out.println("Hello");

    }

    //after-> tearDown
    @AfterMethod
    public void tearDown() {
        driver.quit();//all tabs && close browser
        //driver.close();//only one tab (if only one- > close browser)
    }
}



