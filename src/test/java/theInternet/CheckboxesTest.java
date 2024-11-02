package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest {

    WebDriver driver;
    @BeforeClass
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    void  ableSelectACheckboxes() {
        WebElement checkbox1 =  driver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    @Test
    void  ableUnSelectACheckboxes() {
        WebElement checkbox2 =  driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        if (checkbox2.isSelected()) {
            checkbox2.click();
        }

        Assert.assertFalse(checkbox2.isSelected());
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
