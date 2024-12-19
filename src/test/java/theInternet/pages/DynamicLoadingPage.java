package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static supports.Browser.*;

public class DynamicLoadingPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public String waitLoadingPage() {
        getElement(By.xpath("//button[.='Start']")).click();
        WebDriverWait wait = getWait();

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4"))).getText();
    }
}