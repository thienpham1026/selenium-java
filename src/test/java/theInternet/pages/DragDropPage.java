package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static supports.Browser.*;

public class DragDropPage {

    By columnA = By.id("column-a");
    By columnB = By.id("column-b");

    public void open() {
        visit("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public void action() {
        Actions actions = getActions();

        actions
                .dragAndDrop(getElement(columnA), getElement(columnB))
                .perform();
    }

    public String getText(String text) {
        return getElement(By.id(String.format("column-%s", text))).findElement(By.tagName("header")).getText();
    }
}
