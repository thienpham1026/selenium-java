package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class DropDownPage {
    WebDriver driver;
    Select select;

    public DropDownPage() {
        this.driver = Browser.getDriver();
        //select = new Select(Browser.findElement(By.id("fruits")));
    }

    public void open(String url) {
        Browser.visit(url);
    }

    public void selectOption(String option) {
        select = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        select.selectByVisibleText(option);
    }


    public boolean isSelected(String option) {
        return driver.findElement(By.xpath(String.format("//*[@id='dropdown']/option[.='%s']", option))).isSelected();
    }

    public boolean selectedMultiOption() {
        select = new Select(driver.findElement(By.id("fruits")));
        return select.isMultiple();
    }

    public void selectMultiOption(String option1, String option2) {
        select = new Select(driver.findElement(By.id("fruits")));

        select.selectByVisibleText(option1);
        select.selectByVisibleText(option2);
    }

    public void deSelectOption(String option) {
        select = new Select(driver.findElement(By.id("fruits")));
        select.deselectByVisibleText(option);
    }

    public void deSelectAll() {
        select = new Select(driver.findElement(By.id("fruits")));
        select.deselectAll();
    }

    public boolean isMultiSelected(String option) {
        return driver.findElement(By.xpath(String.format("//*[@id='fruits']/option[@value='%s']", option))).isSelected();
    }
}
