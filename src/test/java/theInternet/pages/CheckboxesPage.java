package theInternet.pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class CheckboxesPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void tick(String checkbox) {
        check(By.cssSelector(checkbox));
    }

    public void unCheck(String checkbox) {
        uncheck(By.cssSelector(checkbox));
    }

    public boolean isChecked(String checkbox) {
        return getElement(By.cssSelector(checkbox)).isSelected();
    }
}
