package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest {

    @BeforeClass
    void setup() {
        BrowserUtils.launch("chrome");
    }

    @AfterClass
    void tearDown() {
        if (BrowserUtils.getDriver() != null) {
            BrowserUtils.getDriver().quit();
        }
    }

    @Test
    void  ableSelectACheckboxes() {
        WebDriver driver = BrowserUtils.getDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    @Test
    void  ableUnSelectACheckboxes() {
        WebDriver driver = BrowserUtils.getDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox2 =  driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        if (checkbox2.isSelected()) {
            checkbox2.click();
        }

        Assert.assertFalse(checkbox2.isSelected());
    }
}
