package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.findElement(By.xpath("//input[@id='cage']")).sendKeys(age);
        driver.findElement(By.xpath("//label[@for='csex2']/span")).click();
        driver.findElement(By.xpath("//input[@id='cheightmeter']")).sendKeys(height);
        driver.findElement(By.xpath("//input[@id='ckg']")).sendKeys(weight);

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public boolean isResultCorrect(String expectedBmi) {
        String resultText = driver.findElement(By.xpath("//*[contains(text(), 'BMI = ')]")).getText();

        // Normalize the result text by removing extra parts
        String actualBmi = resultText.replace("BMI = ", "").replace(" kg/m²", "").trim();

        // Compare the actual BMI with the expected one
        return actualBmi.contains(expectedBmi);
    }
}
