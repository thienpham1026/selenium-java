package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supports.Browser;

public class CheckboxesPage {
    WebDriver driver;

    public CheckboxesPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public void check() {
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    public void unCheck() {

    }

    public boolean isCheck() {
        return false;
    }
}
