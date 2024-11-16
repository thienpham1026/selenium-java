package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;

public class JSAlertTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
        driver = Browser.getDriver();
        Browser.visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void clickJsAlertSuccessfully() {
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You successfully clicked an alert");
    }

    @Test
    void verifyClickOKinJsAlertConfirmSuccessfully() {
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");
    }

    @Test
    void verifyClickCancelInJsAlertConfirmSuccessfully() {
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    void verifyInputJsAlertPromptSuccessfully() {
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: hello");
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
