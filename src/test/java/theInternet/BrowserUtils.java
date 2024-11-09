package theInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserUtils {
    private static WebDriver driver;
    private static Actions mouse;
    private static WebDriverWait wait;

    // Map to store browser launch functions
    private static final Map<String, Supplier<WebDriver>> browserMap = new HashMap<>();

    static {
        // Initialize the browser map without WebDriverManager
        browserMap.put("chrome", () -> {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");
            return new ChromeDriver(chromeOptions);
        });

        browserMap.put("firefox", FirefoxDriver::new);
        browserMap.put("edge", EdgeDriver::new);
    }

    public static void launch(String name) {
        // Set default browser to "chrome" if name is null or empty
        name = (name == null || name.trim().isEmpty()) ? "chrome" : name.toLowerCase();

        // Fetch the appropriate browser from the map, or throw an exception if not found
        Supplier<WebDriver> browserSupplier = browserMap.get(name);
        if (browserSupplier == null) {
            throw new IllegalArgumentException("Unsupported browser: " + name);
        }

        // Launch the browser
        driver = browserSupplier.get();

        // Initialize Actions and WebDriverWait for the driver
        mouse = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        }
    }
}
