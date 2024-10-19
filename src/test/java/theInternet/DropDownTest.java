package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {

    @Test
    void ableSelectOption() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByVisibleText("Option 1");

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='dropdown']/option[@value='1']")).isSelected());
        driver.quit();
    }

    @Test
    void ableSelectMultipleOptions(){
        WebDriver driver = new ChromeDriver();
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

        driver.quit();
    }

    /*
     Open Browser
     Navigate to https://www.vietnamairlines.com/vn/en/home
     Agree Cookies
     Select To City
     Select One Way
     Select Depart date [X]
     */
    @Test
    void ableSelectDateForFlight() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-popup-blocking");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        Thread.sleep(1000);
        driver.findElement(By.id("cookie-agree")).click();
        Thread.sleep(5000);


        // Select one way
//        driver.findElement(By.id("oneway")).click();
        //select to city
        driver.findElement(By.id("city-to-roundtrip")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[.='Hanoi (HAN), Vietnam']")).click();
        Thread.sleep(5000);

        // Click on Depart Date
//        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active' and text()='26']/..")).click();
//        driver.findElement(By.xpath("//td[@data-month='9' and @data-year='2024']/a[@class='ui-state-default ui-state-active' and text()='30']")).click();
        driver.findElement(By.className("confirm-dates")).click();

    }
}
