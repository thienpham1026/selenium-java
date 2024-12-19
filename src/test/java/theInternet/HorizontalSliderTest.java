package theInternet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static supports.Browser.*;

import java.io.File;
import java.io.IOException;

public class HorizontalSliderTest {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    @BeforeClass
    void setup() {
        openBrowser("chrome");
        driver = getDriver();
        actions = getActions();
        wait = getWait();
    }

    @Test
    void ableToHorizontalSlidePointer() {
       visit("https://the-internet.herokuapp.com/horizontal_slider");

       WebElement pointer = getElement(By.cssSelector(".sliderContainer input"));
       int offsetWidth = pointer.getSize().getWidth();
       int offsetHeight = pointer.getSize().getHeight();
       System.out.printf("%d %d", offsetHeight, offsetWidth);

       actions.clickAndHold(pointer)
               .moveByOffset(offsetWidth, 0)
               .release()
               .perform();

       Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("range"), "5")));
    }

    @Test
    void ableScrollDown() throws InterruptedException {
        visit("https://the-internet.herokuapp.com/infinite_scroll");

        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0, 1000).perform();
            Thread.sleep(1000);
        }
    }

    @Test
    void contextClick() {
        visit("https://the-internet.herokuapp.com/context_menu");

        actions.contextClick(getElement(By.id("hot-spot"))).perform();

        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    @Test
    void keyPress() {
        visit("https://the-internet.herokuapp.com/key_presses");

        actions.keyDown(Keys.ESCAPE).perform();

        Assert.assertEquals(getElement(By.id("result")).getText(), "You entered: ESCAPE");
    }

    @Test
    void captureScreenshot() throws IOException {
        visit("https://www.selenium.dev/");

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("target/selenium.png");
        FileUtils.copyFile(srcFile, destFile);
    }

    @AfterMethod(alwaysRun = true)
    void captureScreenshot(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            captureScreenShot(testResult.getName());
        }
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
