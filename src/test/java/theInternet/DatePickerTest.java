package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static supports.Browser.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DatePickerTest {

//    @BeforeClass
//    void setup() {
//        openBrowser("chrome");
//    }
//
//    @Test
//    void selectADate() {
//        WebDriver driver = getDriver();
//        driver.manage().window().maximize();
//        visit("https://www.vietnamairlines.com/vn/en/home");
//        WebDriverWait wait = getWait();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree"))).click();
//
//        // Allow notifications
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_setting_values.notifications", 1); // Allow notifications
//
//        //select city
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("city-to-roundtrip"))).click();
//
//        wait
//                .until(ExpectedConditions
//                        .visibilityOfAllElementsLocatedBy(
//                                By.cssSelector("#to-bookYourTripTo-vietnam div"))
//                )
//                .stream()
//                .filter(row -> row.getText().contains("Ho Chi Minh City (SGN), Vietnam"))
//                .findFirst()
//                .ifPresent(WebElement::click);
//
//        wait
//                .until(
//                        ExpectedConditions
//                                .visibilityOfAllElementsLocatedBy(
//                                        By
//                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
//                .get(0) // get current month
//                .findElements(By.tagName("a"))
//                .stream()
//                .filter(cell -> cell.getText().contains("29"))
//                .findFirst()
//                .ifPresent(WebElement::click);
//
//        wait
//                .until(
//                        ExpectedConditions
//                                .visibilityOfAllElementsLocatedBy(
//                                        By
//                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
//                .get(1) // get next month
//                .findElements(By.tagName("a"))
//                .stream()
//                .filter(cell -> cell.getText().contains("2"))
//                .findFirst()
//                .ifPresent(WebElement::click);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Done')]"))).click();
//    }
//
//    @AfterClass
//    void tearDown() {
//        quit();
//    }

    public static void main(String[] args) {
        // Define the date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Create the date string
        String dateString = "31/10/2024";

        try {
            // Parse the date string into a Date object
            Date date = dateFormat.parse(dateString);

            // Create a Calendar object and set the date
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Get the day of the month
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            // Print the day of the month
            System.out.println("Day: " + dayOfMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LocalDate today = LocalDate.now();

        // Get the day of the month
        int dayOfMonth = today.getDayOfMonth();

        // Print the current day of the month
        System.out.println("Current Day of the Month: " + dayOfMonth);
        System.out.println("Next Day of the Month: " + today.plusDays(7).getDayOfMonth());
    }
}
