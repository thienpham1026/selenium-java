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

    public void check(String checkbox) {
        Browser.check(By.cssSelector(checkbox));
    }

    public void unCheck(String checkbox) {
        Browser.uncheck(By.cssSelector(checkbox));
    }

    public boolean isCheck(String checkbox) {
        return driver.findElement(By.cssSelector(checkbox)).isSelected();
    }
}
