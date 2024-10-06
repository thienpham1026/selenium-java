package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFirefoxBrowser {

    @Test
    void openWithFirefoxBrowser() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openWithFirefoxHeadlessMode() {
        FirefoxOptions chromeOptions = new FirefoxOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new FirefoxDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openEdgeBrowser() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://selenium.dev");
        driver.quit();
    }
}
