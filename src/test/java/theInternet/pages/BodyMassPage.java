package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supports.Browser;

public class BodyMassPage {
    WebDriver driver;

    public BodyMassPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        Browser.visit("https://www.calculator.net/bmi-calculator.html");
    }

    public void fillCalculator(String age, String height, String weight) {
        WebElement ageField = driver.findElement(By.xpath("//input[@id='cage']"));
        ageField.clear();
        ageField.sendKeys(age);

        // checkbox: Female
        driver.findElement(By.xpath("//label[@for='csex2']/span")).click();

        WebElement heightField = driver.findElement(By.xpath("//input[@id='cheightmeter']"));
        heightField.clear();
        heightField.sendKeys(height);

        WebElement weightField = driver.findElement(By.xpath("//input[@id='ckg']"));
        weightField.clear();
        weightField.sendKeys(weight);

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public boolean isResultCorrect(String expectedBmi) {
        String resultText = driver.findElement(By.xpath("//div[@class='bigtext']")).getText();
        String actualBmi = resultText.replaceAll("[^\\d.]", "").trim();

        return actualBmi.contains(expectedBmi);
    }
}
