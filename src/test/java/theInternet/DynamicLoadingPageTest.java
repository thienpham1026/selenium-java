package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class DynamicLoadingPageTest {
    @Test
    void handleLoadingSuccess() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[.='Start']")).click();

        //need to wait load page
        Thread.sleep(10000);
        Assert.assertEquals(driver.findElement(By.cssSelector("#finish >h4")).getText(),"Hello World!");

        driver.quit();
    }

    @Test
    void handleWaitLoadingSuccess() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("#finish > h4")).getText(), "Hello World!");

        driver.quit();
    }
}
