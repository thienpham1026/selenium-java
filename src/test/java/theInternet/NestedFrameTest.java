package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;

public class NestedFrameTest {

    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
    }

    @Test
    void verifyFrameContent() {
        WebDriver driver = Browser.getDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("LEFT"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("MIDDLE"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("RIGHT"));

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("BOTTOM"));
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}