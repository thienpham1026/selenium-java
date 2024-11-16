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

    List<Person> table1Person;
    WebDriver driver;

    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
        driver = BrowserUtils.getDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        table1Person = new ArrayList<>();
        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row -> {
                    List<String> cells = row.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
                    table1Person.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
                });
    }

    @Test
    void dataTables() {
        double[] dueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$", "")))
                .toArray();

        double maxDueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$", "")))
                .max()
                .getAsDouble();

        int indexOfMaxDue = 0;
        for (int i = 0; i < dueValue.length; i++) {
            if (dueValue[i] == maxDueValue) {
                indexOfMaxDue = i + 1;
            }
        }
        System.out.println(indexOfMaxDue);
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        String firsName = driver.findElement(By.xpath(String.format(cellLocator, indexOfMaxDue, 2))).getText(); // 2 -> cot firstName
        String lastName = driver.findElement(By.xpath(String.format(cellLocator, indexOfMaxDue, 1))).getText(); // 1 -> cot lastName
        Assert.assertEquals(String.format("%s %s", firsName, lastName), "Jason Doe");
    }

    @Test
    void tc05() {
        List<Person> table1Person = new ArrayList<>();
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        for (int i = 1; i <= totalRows; i++) {
            String firstName = driver.findElement(By.xpath(String.format(cellLocator, i, 2))).getText();
            String lastName = driver.findElement(By.xpath(String.format(cellLocator, i, 1))).getText();
            String due = driver.findElement(By.xpath(String.format(cellLocator, i, 4))).getText();
            table1Person.add(new Person(firstName, lastName, due));
        }

        Person maxDuePerson = table1Person
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get();
        Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");
    }

    @Test
    void tc05_2() {
        List<Person> table1Person = new ArrayList<>();

        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row -> {
                    List<String> cells = row.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
                    table1Person.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
                });
        Person maxDuePerson = table1Person
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get();
        Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");
    }

    @Test
    void verifyMaxDuePerson() {
        Person maxDuePerson = table1Person
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get();
        Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");
    }

    @Test
    void verifyMinDueValuePerson() {
        Person minDuePerson = table1Person
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .get();

        List<String> minDuePersonFullName = table1Person
                .stream()
                .filter(person -> person.getDue() == minDuePerson.getDue())
                .map(Person::getFullName)
                .toList();
        Assert.assertEquals(minDuePersonFullName, List.of("John Smith", "Tim Conway"));
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
