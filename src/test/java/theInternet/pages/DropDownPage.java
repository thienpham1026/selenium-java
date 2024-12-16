package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static supports.Browser.getElement;
import static supports.Browser.visit;

public class DropDownPage {
    Select select;

    public void open(String url) {
        visit(url);
    }

    public void selectOption(String option) {
        select = new Select(getElement(By.xpath("//select[@id='dropdown']")));
        select.selectByVisibleText(option);
    }


    public boolean isSelected(String option) {
        return getElement(By.xpath(String.format("//*[@id='dropdown']/option[.='%s']", option))).isSelected();
    }

    public boolean selectedMultiOption() {
        select = new Select(getElement(By.id("fruits")));
        return select.isMultiple();
    }

    public void selectMultiOption(String option1, String option2) {
        select = new Select(getElement(By.id("fruits")));

        select.selectByVisibleText(option1);
        select.selectByVisibleText(option2);
    }

    public void deSelectOption(String option) {
        select = new Select(getElement(By.id("fruits")));
        select.deselectByVisibleText(option);
    }

    public void deSelectAll() {
        select = new Select(getElement(By.id("fruits")));
        select.deselectAll();
    }

    public boolean isMultiSelected(String option) {
        return getElement(By.xpath(String.format("//*[@id='fruits']/option[@value='%s']", option))).isSelected();
    }
}
