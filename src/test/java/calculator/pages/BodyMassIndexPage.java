package calculator.pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class BodyMassIndexPage {
    /**
     * convention
     * suffix to define type of element
     * **Tab => tab
     * **TextBox txt => Text Field
     * **Button btn => button
     */

    private By metricTab = By.cssSelector("li#menuon a");
    private By clearButton = By.cssSelector("input[value=Clear]");
    private By ageTextBox = By.cssSelector("input#cage");
    private By maleRadioButton = By.cssSelector("td label.cbcontainer:first-child");
    private By femaleRadioButton = By.cssSelector("td label.cbcontainer:last-child");
    private By heightTextBox = By.cssSelector("input#cheightmeter");
    private By weightTextBox = By.cssSelector("input#ckg");
    private By calculateButton = By.xpath("//input[@type='submit' and @value='Calculate']");
    private By resultLabel = By.cssSelector(".rightresult .bigtext b");

    // Fluent way
    public BodyMassIndexPage open() {
        visit("https://www.calculator.net/bmi-calculator.html");
        return this;
    }

    public BodyMassIndexPage selectMetricTab() {
        click(metricTab);
        return this;
    }

    public void clearForm() {
        click(clearButton);
    }

    public void fillForm(String age, double height, double weight, String gender) {
        fill(ageTextBox, age);

        if (gender.equalsIgnoreCase("male")) {
            click(maleRadioButton);
        } else {
            click(femaleRadioButton);
        }
        fill(heightTextBox, String.valueOf(height));
        fill(weightTextBox, String.valueOf(weight));
        click(calculateButton);
    }

    public String getResult() {
        return getText(resultLabel);
    }
}
