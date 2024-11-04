package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicLoadingPageTest {

    @BeforeClass
    void setup() {
        BrowserUtils.launch("chrome");
    }

    @Test
    void handleWaitLoadingSuccess() {
        WebDriver driver = BrowserUtils.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4"))).getText();

        Assert.assertEquals(content, "Hello World!");
    }

    @AfterClass
    void tearDown() {
        if (BrowserUtils.getDriver() != null) {
            BrowserUtils.getDriver().quit();
        }
    }
}
