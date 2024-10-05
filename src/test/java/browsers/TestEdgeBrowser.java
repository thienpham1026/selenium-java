package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEdgeBrowser {

    @Test
    void openWithEdgeBrowser() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openWithEdgeHeadlessMode() {
        EdgeOptions chromeOptions = new EdgeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new EdgeDriver(chromeOptions);
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
