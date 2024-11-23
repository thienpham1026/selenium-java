package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class DropDownPage {
    //WebDriver driver;
    Select select;

    public void open(String url) {
        Browser.visit(url);
        getDropDown();
    }

    private void getDropDown() {
        Browser.getElement(By.xpath("//select[@id='dropdown']"));
        Browser.getElement(By.id("fruits"));
    }

    public void selectOption(String option) {
        dropdown = new Select(Browser.getElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByVisibleText(option);
    }

    public boolean isSelected(String option) {
        return Browser.getElement(By.xpath(String.format("//*[@id='dropdown']/option[.='%s']", option))).isSelected();
    }

    public boolean selectedMultiOption() {
        select = new Select(Browser.getElement(By.id("fruits")));
        return select.isMultiple();
    }

    public void selectMultiOption(String option1, String option2) {
        select = new Select(Browser.getElement(By.id("fruits")));

        select.selectByVisibleText(option1);
        select.selectByVisibleText(option2);
    }

    public void deSelectOption(String option) {
        select = new Select(Browser.getElement(By.id("fruits")));
        select.deselectByVisibleText(option);
    }

    public void deSelectAll() {
        select = new Select(Browser.getElement(By.id("fruits")));
        select.deselectAll();
    }

    public boolean isMultiSelected(String option) {
        return Browser.getElement(By.xpath(String.format("//*[@id='fruits']/option[@value='%s']", option))).isSelected();
    }
}
