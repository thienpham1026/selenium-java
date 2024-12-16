package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

public class HoverPage {
    WebDriver driver;

    public HoverPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/hovers");
    }

    public String ableHover(int imageIndex) {
        Actions actions = Browser.getActions();

        actions
                .moveToElement(Browser
                                .all(By.cssSelector("#content .figure"))
                                .get(imageIndex))
                .perform();

        return Browser.all(By.cssSelector(".figcaption h5")).get(imageIndex).getText();
    }
}
