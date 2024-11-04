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
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<Actions> mouse = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

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
                
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + name);
        }

        // Initialize Actions and WebDriverWait
        mouse.set(new Actions(driver.get()));
        wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(30)));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static Actions getMouse() {
        return mouse.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void quit() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            mouse.remove();
            wait.remove();
        }
    }
}
