package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {

    @Test
    void  ableSelectACheckboxes() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 =  driver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        driver.quit();
    }

    @Test
    void  ableUnSelectACheckboxes() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox2 =  driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        if (checkbox2.isSelected()) {
            checkbox2.click();
        }

        Assert.assertFalse(checkbox2.isSelected());

        driver.quit();
    }
}
