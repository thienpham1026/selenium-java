package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import supports.Browser;

public class DynamicLoadingPage {
    WebDriver driver;

    public DynamicLoadingPage() {
        driver = Browser.getDriver();
    }

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public String waitLoadingPage() {
        driver.findElement(By.xpath("//button[.='Start']")).click();
        WebDriverWait wait = Browser.getWait();

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4"))).getText();
    }
}