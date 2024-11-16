package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.DropDownPage;

public class DropDownTest {

    @BeforeClass
    void setup() {
        Browser.openBrowser("chrome");
    }

    @Test
    void ableSelectOption() {
        DropDownPage dropDownPage = new DropDownPage();
        dropDownPage.open();

        dropDownPage.selectOption("Option 1");

        Assert.assertTrue(dropDownPage.isSelected("Option 1"));
    }

    @Test
    void ableSelectMultipleOptions() {
        WebDriver driver = Browser.getDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));

        Assert.assertTrue(select.isMultiple());

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());

        select.deselectByVisibleText("Banana");

        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());

        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='grape']")).isSelected());
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
