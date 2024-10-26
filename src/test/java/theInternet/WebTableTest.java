package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest {

    @Test
    void dataTables() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        double[] dueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$","")))
                .toArray();

        double maxDueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$","")))
                .max()
                .getAsDouble();

        int indexOfMaxDue = 0;
        for(int i =0;i<dueValue.length;i++){
            if(dueValue[i]==maxDueValue){
                indexOfMaxDue = i+1;
            }
        }
        System.out.println(indexOfMaxDue);
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        String firsName = driver.findElement(By.xpath(String.format(cellLocator,indexOfMaxDue,2))).getText(); // 2 -> cot firstName
        String lastName = driver.findElement(By.xpath(String.format(cellLocator,indexOfMaxDue,1))).getText(); // 1 -> cot lastName
        Assert.assertEquals(String.format("%s %s",firsName,lastName),"Jason Doe");
    }
}
