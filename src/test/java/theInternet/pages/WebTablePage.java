package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supports.Browser;

import java.util.List;

public class WebTablePage {
    WebDriver driver;

    public WebTablePage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/tables");
    }

    public List<WebElement> getTable1() {
        return Browser.getElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
    }
}
