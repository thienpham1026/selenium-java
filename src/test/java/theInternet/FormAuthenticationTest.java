package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    WebDriver driver;

    @BeforeMethod
    void setup()
    {
        driver = new ChromeDriver();
    }

    @Test
    void shouldBeSuccessfully(){
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        driver.quit();
    }

    @Test
    void shouldBeInValidUsername(){
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("thienpt");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
        driver.quit();
    }

    @Test
    void shouldBeInvalidPassword(){
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("superSecretPassword!");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
        driver.quit();
    }
}
