package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HyperLinkTest {

    @BeforeClass
    void setup() {
        BrowserUtils.launch("chrome");
    }

    @Test
    void verifyNavigateHyperLink() {
        WebDriver driver = BrowserUtils.getDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

        String href = driver.findElement(By.linkText("200")).getAttribute("href");

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.findElement(By.linkText("here")).click();

        href = driver.findElement(By.linkText("301")).getAttribute("href");

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        href = driver.findElement(By.linkText("404")).getAttribute("href");
        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        href = driver.findElement(By.linkText("500")).getAttribute("href");
        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();
    }

    @AfterClass
    void tearDown() {
        if (BrowserUtils.getDriver() != null) {
            BrowserUtils.getDriver().quit();
        }
    }
}
