import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findCssSelectorInTable() {
        //get all of rows
        List<WebElement> rows = driver.findElements(By.xpath("//tr"));

        WebElement germany = driver.findElement(By.xpath("//*[@id='customers']//tr[2]"));
        System.out.println(germany.getText());

        WebElement maria = driver.findElement(By.xpath("//*[@id='customers']//tr[2]//td[2]"));
        System.out.println(maria.getText());


        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i).getText());
        }
        for (WebElement element : rows) {
            System.out.println(element.getText());
            //get row 2

            System.out.println(germany.getText());
            System.out.println("*************************");

            //get row 2,2 element

            System.out.println(maria.getText());
            System.out.println("*************************");

            //get row 4, last child
            WebElement last = driver.findElement(By.cssSelector("#customers tr:nth-child(4) td:last-child"));
            System.out.println(last.getText());
        }
    }
}

