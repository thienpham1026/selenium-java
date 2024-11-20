package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebTableTest {
    WebDriver driver;
    WebTablePage webTablePage;

    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
        webTablePage = new WebTablePage();
        webTablePage.open();
    }

    @Test
    void dataTables() {
        Assert.assertEquals(webTablePage.getMaxDuePersonTable1(), "Jason Doe");
    }

    // @Test
    // void tc05() {
    //     List<Person> table1Person = new ArrayList<>();
    //     String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
    //     int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
    //     for (int i = 1; i <= totalRows; i++) {
    //         String firstName = driver.findElement(By.xpath(String.format(cellLocator, i, 2))).getText();
    //         String lastName = driver.findElement(By.xpath(String.format(cellLocator, i, 1))).getText();
    //         String due = driver.findElement(By.xpath(String.format(cellLocator, i, 4))).getText();
    //         table1Person.add(new Person(firstName, lastName, due));
    //     }

    //     Person maxDuePerson = table1Person
    //             .stream()
    //             .max(Comparator.comparing(Person::getDue))
    //             .get();
    //     Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");
    // }

    // @Test
    // void tc05_2() {
    //     List<Person> table1Person = new ArrayList<>();

    //     driver
    //             .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
    //             .forEach(row -> {
    //                 List<String> cells = row.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
    //                 table1Person.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
    //             });
    //     Person maxDuePerson = table1Person
    //             .stream()
    //             .max(Comparator.comparing(Person::getDue))
    //             .get().getFullName();
    //     Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");
    // }

    @Test
    void verifyMaxDuePerson() {
        Assert.assertEquals(webTablePage.getMaxDuePersonOfTable1(), "Jason Doe");
    }

    @Test
    void verifyMinDueValuePerson() {
        Assert.assertEquals(webTablePage.getMinDuePersonOfTable1(), List.of("John Smith", "Tim Conway"));
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
