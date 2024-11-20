package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supports.Browser;

import java.util.List;

public class WebTablePage {
    // WebDriver driver;
    List<Person> table1Person = new ArrayList<>();
    List<Person> table2Person = new ArrayList<>();

    // public WebTablePage() {
    //     this.driver = Browser.getDriver();
    // }

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/tables");
        getTables();
    }

    public String getMaxDuePersonOfTable1() {
        return table1Person
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get().getFullName();
    }

    public List<String> getMinPersonOfTable1() {
        Person minDuePerson = table1Person
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .get();

        return table1Person
                .stream()
                .filter(person -> person.getDue() == minDuePerson.getDue())
                .map(Person::getFullName)
                .toList();
    }

    private void getTables() {
        Browser
                .getElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row -> {
                    List<String> cells = row.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
                    table1Person.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
                });
        Browser
                .getElements(By.xpath("//table[@id='table2']/tbody/tr"))
                .forEach(row -> {
                    List<String> cells = row.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
                    table2Person.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
                });
    }

    public String getMaxDuePersonTable1() {
        double[] dueValue = Browser.getElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$", "")))
                .toArray();

        double maxDueValue = Browser.getElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
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
        String firsName = Browser.getText(By.xpath(String.format(cellLocator, indexOfMaxDue, 2))); // 2 -> cot firstName
        String lastName = Browser.getText(By.xpath(String.format(cellLocator, indexOfMaxDue, 1))); // 1 -> cot lastName
        return String.format("%s %s", firsName, lastName);
    }
}
