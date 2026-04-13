package homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTests extends TestBase {
    @Test
    public void registrationTest(){
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Aleksey");
        driver.findElement(By.id("LastName")).sendKeys("Lu");
        int i = (int)(System.currentTimeMillis() % 100000);
        driver.findElement(By.id("Email")).sendKeys("test" + i + "@mail.com");
        driver.findElement(By.id("Password")).sendKeys("Aa12345!");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Aa12345!");
        driver.findElement(By.id("register-button")).click();

        Assert.assertTrue(driver.findElement(By.className("result")).isDisplayed());



    }


}
