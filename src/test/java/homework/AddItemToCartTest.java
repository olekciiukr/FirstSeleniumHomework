package homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase {

    @Test
    public void addItemToCartTest() {
        click(By.cssSelector(".ico-login"));
        type(By.id("Email"), "aleks12345@gmail.com");
        type(By.id("Password"), "Aa12345!");
        click(By.cssSelector("input.login-button"));

        click(By.xpath("(//input[@value='Add to cart'])[2]"));
        click(By.cssSelector(".cart-label"));

        Assert.assertTrue(isPresent(By.xpath("//a[text()='14.1-inch Laptop']")));


    }


}
