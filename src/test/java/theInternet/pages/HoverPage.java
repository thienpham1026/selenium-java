package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static supports.Browser.*;

public class HoverPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/hovers");
    }

    public String ableHover(int imageIndex) {
        Actions actions = getActions();

        actions
                .moveToElement(
                        all(By.cssSelector("#content .figure"))
                                .get(imageIndex))
                .perform();

        return all(By.cssSelector(".figcaption h5")).get(imageIndex).getText();
    }
}
