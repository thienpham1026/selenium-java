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
    private static Actions actions;
    private static WebDriverWait wait;

    // Map to store browser launch functions
    private static final Map<String, Supplier<WebDriver>> browserMap = new HashMap<>();

    static {
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

        Supplier<WebDriver> browserSupplier = browserMap.get(name);
        if (browserSupplier == null) {
            throw new IllegalArgumentException("Unsupported browser: " + name);
        }

        driver = browserSupplier.get();

        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Actions getMouse() {
        return actions;
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
