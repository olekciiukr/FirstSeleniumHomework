package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper {
    WebDriver driver;

    public UserHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void login() {
        driver.findElement(By.cssSelector(".ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("aleks12345@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Aa12345!");
        driver.findElement(By.cssSelector("input.login-button")).click();
    }

}
