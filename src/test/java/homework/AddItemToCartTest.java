package homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase {

    @Test
    public void addItemToCartTest() throws InterruptedException {
        app.getUser().login();
        app.getBase().click(By.xpath("//a[text()='14.1-inch Laptop']/../../..//input[@value='Add to cart']"));
        driver.get("https://demowebshop.tricentis.com/cart");
        app.getBase().click(By.cssSelector(".cart-label"));
        Assert.assertTrue(app.getBase().isPresent(By.xpath("//a[text()='14.1-inch Laptop']")));


    }


}
