package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static supports.Browser.*;

public class BodyMassPage {

    public void open() {
        visit("https://www.calculator.net/bmi-calculator.html");
    }

    public void fillCalculator(String age, double height, double weight, String gender) {
        getElement(By.cssSelector("input[value=Clear]")).click();

        WebElement ageField = getElement(By.cssSelector("input#cage"));
        ageField.sendKeys(age);

        if (gender.equalsIgnoreCase("female")) {
            getElement(By.xpath("//label[@for='csex2']/span")).click();
        }

        WebElement heightField = getElement(By.cssSelector("input#cheightmeter"));
        heightField.sendKeys(String.valueOf(height));

        WebElement weightField = getElement(By.cssSelector("input#ckg"));
        weightField.sendKeys(String.valueOf(weight));

        getElement(By.xpath("//input[@type='submit']")).click();
    }

    public boolean isResultCorrect(String expectedBmi) {
        String resultText = getText(By.cssSelector(".rightresult .bigtext b"));

        return resultText.contains(expectedBmi);
    }
}