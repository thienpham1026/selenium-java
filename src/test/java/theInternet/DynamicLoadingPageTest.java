package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
