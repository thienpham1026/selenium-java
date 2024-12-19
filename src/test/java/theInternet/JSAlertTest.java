package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static supports.Browser.*;

public class JSAlertTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        openBrowser("chrome");
        driver = getDriver();
        visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void clickJsAlertSuccessfully() {
        getElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        Assert.assertEquals(getText(By.id("result")), "You successfully clicked an alert");
    }

    @Test
    void verifyClickOKinJsAlertConfirmSuccessfully() {
        getElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();

        Assert.assertEquals(getText(By.id("result")), "You clicked: Ok");
    }

    @Test
    void verifyClickCancelInJsAlertConfirmSuccessfully() {
        getElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(getText(By.id("result")), "You clicked: Cancel");
    }

    @Test
    void verifyInputJsAlertPromptSuccessfully() {
        getElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();

        Assert.assertEquals(getText(By.id("result")), "You entered: hello");
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
