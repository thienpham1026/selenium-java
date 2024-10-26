package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
    void ableSelectMultipleOptions() {
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

    @Test
    void ableSelectDateForFlight() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree"))).click();

        //select city
        wait.until(ExpectedConditions.elementToBeClickable(By.id("city-to-roundtrip"))).click();

        wait
                .until(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(
                                By.cssSelector("#to-bookYourTripTo-vietnam div"))
                )
                .stream()
                .filter(row -> row.getText().contains("Hanoi (HAN), Vietnam"))
                .findFirst()
                .ifPresent(WebElement::click);


        // select depart date
        WebElement dateWidgetFrom = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#byt-datespicker .ui-datepicker-calendar"))).get(0);

        List<WebElement> dateCells = dateWidgetFrom.findElements(By.tagName("td"));
        dateCells.stream()
                .filter(element -> element.getText().contains("26"))
                .findFirst()
                .ifPresent(WebElement::click);

        // select return date
        wait.until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By.cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(0)
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("31"))
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
