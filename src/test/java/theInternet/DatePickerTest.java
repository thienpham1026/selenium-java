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

public class DatePickerTest {

    @Test
    void selectADate() {
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

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By
                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(0) // get current month
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("31"))
                .findFirst()
                .ifPresent(WebElement::click);

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By
                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(1) // get next month
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("5"))
                .findFirst()
                .ifPresent(WebElement::click);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Done')]"))).click();

        driver.quit();
    }
}
