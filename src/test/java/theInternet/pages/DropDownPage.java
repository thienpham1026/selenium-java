package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class DropDownPage {
    WebDriver driver;

    public DropDownPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String option) {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByVisibleText(option);
    }

    public boolean isSelected(String option) {
        return driver.findElement(By.xpath(String.format("//*[@id='dropdown']/option[.='%s']", option))).isSelected();
    }
}
