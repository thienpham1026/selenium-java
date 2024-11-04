package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HoverTest {

    @DataProvider
    Object[][] testData() {
        return new Object[][]{
                {0, "name: user1"},
                {1, "name: user2"},
                {2, "name: user3"},
        };
    }

    @BeforeClass
    void setup() {
        BrowserUtils.launch("chrome");
    }

    @Test(dataProvider = "testData")
    void ableToHoverImage(int imageIndex, String expectedImageName) {
        WebDriver driver = BrowserUtils.getDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);

        actions
                .moveToElement(
                        driver
                                .findElements(By.cssSelector("#content .figure"))
                                .get(imageIndex))
                .perform();

        String imageName = driver.findElements(By.cssSelector(".figcaption h5")).get(imageIndex).getText();
        Assert.assertEquals(imageName, expectedImageName);
    }

    @AfterClass
    void tearDown() {
        if (BrowserUtils.getDriver() != null) {
            BrowserUtils.getDriver().quit();
        }
    }
}
