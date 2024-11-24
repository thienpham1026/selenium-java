package supports;

import org.openqa.selenium.By;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class Browser {

    private static WebDriver driver;
    private static Actions actions;
    private static WebDriverWait wait;

    public static void openBrowser(String name) {
        // Default to Chrome if name is null or empty
        if (name == null || name.trim().isEmpty()) {
            name = "chrome";
        }

        switch (name.toLowerCase().trim()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                throw new IllegalArgumentException("Un Support Browser: " + name.toLowerCase());
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static Actions getActions() {
        return actions;
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void check(By locator) {
        if (!isChecked(locator)) {
            driver.findElement(locator).click();
        }
    }

    public static void uncheck(By locator) {
        if (isChecked(locator)) {
            driver.findElement(locator).click();
        }
    }

    public static boolean isChecked(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public static void click(By locator) {
        driver.findElement(locator).click();
    }

    public static List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getElementValue(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute("value");
    }

    public static void fill(By locator, String withText){
        driver.findElement(locator).sendKeys(withText);
    }

    public static void hover(WebElement element){
        actions
                .moveToElement(element)
                .perform();
    }
    
    public static void doubleClick(WebElement element){
        actions
                .doubleClick(element)
                .perform();
    }
    
    public static void executeScript(WebElement element, String jsScript){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jsScript,element);
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
