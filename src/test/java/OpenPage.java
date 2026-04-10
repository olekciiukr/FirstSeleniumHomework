import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenPage {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    @Test
    public void openPage() {
        System.out.println("Open Page");
    }

    @Test
    public void find10Elements() {
        driver.findElement(By.className("ico-register"));
        driver.findElement(By.className("ico-login"));
        driver.findElement(By.className("cart-label"));
        driver.findElement(By.className("ico-wishlist"));
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.className("button-1"));
        driver.findElements(By.linkText("Books"));
        driver.findElements(By.linkText("Computers"));
        driver.findElements(By.linkText("Electronics"));
        driver.findElements(By.linkText("Apparel & Shoes"));


    }

    @Test
    public void findElementsByCss() {
        driver.findElements(By.cssSelector(".ico-register"));
        driver.findElement(By.cssSelector(".ico-login"));
        driver.findElement(By.cssSelector(".cart-label"));
        driver.findElement(By.cssSelector(".ico-wishlist"));
        driver.findElement(By.cssSelector("#small-searchterms"));
        driver.findElement(By.cssSelector("input[value='Search']"));
        driver.findElement(By.cssSelector("a[href='/books']"));
        driver.findElement(By.cssSelector("a[href='/computers']"));
        driver.findElement(By.cssSelector("a[href='/electronics']"));
        driver.findElement(By.cssSelector("a[href='/apparel-shoes']"));


    }

    @Test
    public void findElementByXpath() {
        driver.findElements(By.xpath("//a[@class = 'ico-register']"));
        driver.findElements(By.xpath("//a[@class = 'ico-login']"));
        driver.findElements(By.xpath("//span[@class = 'cart-label']"));
        driver.findElements(By.xpath("//span[@class = 'ico-wishlist']"));
        driver.findElements(By.xpath("//input[@id = 'small-searchterms']"));
        driver.findElements(By.xpath("//a[@href = '/books']"));
        driver.findElements(By.xpath("//a[@href = '/computers']"));
        driver.findElements(By.xpath("//a[@href = '/electronics']"));
        driver.findElements(By.xpath("//a[@href = '/apparel-shoes']"));


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
