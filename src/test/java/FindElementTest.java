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

public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        //maximize browser to window
        driver.manage().window().maximize();
        //wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName() {
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getAttribute("class"));

        //list
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());


    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let car work"));
        System.out.println(linkText.getText());

    }

    @Test
    public void findElementByPartialLinkText() {
        WebElement partialLink = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLink.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //driver.findElement(By.tagName("h1"));
        //tagName "h1" -> css "h1"
        driver.findElement(By.cssSelector("h1"));

        //driver.findElement(By.id("city"));
        //id "city" -> css "#city"
        driver.findElement(By.cssSelector("#city"));

        //driver.findElement(By.className("telephone"));
        //className "telephone" -> css ".telephone"
        driver.findElement(By.cssSelector(".telephone"));

        //CSS->[attr='par']
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='city']"));

        //contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));
        //end to -> $
        driver.findElement(By.cssSelector("[href$='work']"));

        //composite css
        //tag+class+pare
        driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
        //tag+class
        driver.findElement(By.cssSelector("div.social-networks"));

        // > one step down
        driver.findElement(By.cssSelector(".logo>img"));
        // space 2 or more steps down
        driver.findElement(By.cssSelector(".feedback-page .top-banner"));

        //<tag> or <id> or <class>:nth-child(n)
        WebElement feedback = driver.findElement(By.cssSelector(".feedback-card:nth-child(6)"));
        System.out.println(feedback.getText());

    }

    @Test
    public void findElementByXpath() {
        //       // some_tag[@attribute='value']
        //        //*[@attribute='value']
        //         //tag[2]
        //         //tag[@attr='value1' and @attr2='value']
        //         // tag[@attr='value1' or @attr2='value']
        //         // tag[@attr='value1' not @attr2='value']
        //        text(); contains();

        // driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        //driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//*[@class='telephone']"));

        //driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.xpath("//a[@href='/search']"));
        //driver.findElement(By.cssSelector("[for='city']"));
        driver.findElement(By.xpath("//*[@for='city']"));

//                //contains -> *
//                driver.findElement(By.cssSelector("[href*='car']"));
        driver.findElement(By.xpath("//a[contains(@href,'car')]"));
//                //start -> ^
//                driver.findElement(By.cssSelector("[href^='/let']"));
        driver.findElement(By.xpath("//a[starts-with(@href,'/let')]"));
//                //end to -> $
//                driver.findElement(By.cssSelector("[href$='work']"));

        //text
        //WebElement text = driver.findElement(By.xpath("//*[contains(text(),'This car exceeded my')]"));
        WebElement text = driver.findElement(By.xpath("//p[contains(.,'This car exceeded my')]"));
        System.out.println(text.getText());

        // //tag+class+pare
        //                driver.findElement(By.cssSelector("a.navigation-link[href='/login']"));
        driver.findElement(By.xpath("//a[@class='navigation-link' and @href='/login']"));
        //                //tag+class
        //                driver.findElement(By.cssSelector("div.social-networks"));
        driver.findElement(By.xpath("//div[@class='social-networks']"));


        //// > one step down
        //                driver.findElement(By.cssSelector(".logo>img"));
        driver.findElement(By.xpath("//a[@class='logo']/img"));
        //                // space 2 or more steps down
        //                driver.findElement(By.cssSelector(".feedback-page .top-banner"));
        driver.findElement(By.xpath("//div[@class='feedback-page']//*[@class='top-banner']"));

    }
    //cssSelector -> div>a        xPath -> div/a   -one step
    //cssSelector -> div a        xPath -> div//a   one or more steps


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
