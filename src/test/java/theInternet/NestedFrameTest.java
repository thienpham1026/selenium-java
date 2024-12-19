package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static supports.Browser.*;

public class NestedFrameTest {

    @BeforeClass
    void setUp() {
        openBrowser("chrome");
    }

    @Test
    void verifyFrameContent() {
        WebDriver driver = getDriver();
        visit("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertTrue(getText(By.tagName("body")).contains("LEFT"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(getText(By.id("content")).contains("MIDDLE"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertTrue(getText(By.tagName("body")).contains("RIGHT"));

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(getText(By.tagName("body")).contains("BOTTOM"));
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}