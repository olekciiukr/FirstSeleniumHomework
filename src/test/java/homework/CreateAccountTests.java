package homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateAccountTests extends TestBase {
    @Test
    public void registrationTest() {
        click(By.linkText("Register"));
        click(By.id("gender-male"));
        type(By.id("FirstName"), "Aleksey");
        type(By.id("LastName"), "Lu");
        int i = (int) (System.currentTimeMillis() % 100000);
        type(By.id("Email"), "test" + i + "@mail.com");
        type(By.id("Password"), "Aa12345!");
        type(By.id("ConfirmPassword"), "Aa12345!");
        click(By.id("register-button"));

        Assert.assertTrue(isPresent(By.className("result")));



    }


}
