package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BrowserUtils {
    private static WebDriver driver;
    private static Actions mouse;
    private static WebDriverWait wait;

    public static void launch(String name) {
        // Default to Chrome if name is null or empty
        if (name == null || name.trim().isEmpty()) {
            name = "chrome";
        }

        switch (name.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + name);
        }

        // Initialize Actions and WebDriverWait
        mouse = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Actions getMouse() {
        return mouse;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
