package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static supports.Browser.*;

import theInternet.pages.DynamicLoadingPage;

public class DynamicLoadingPageTest {

    @BeforeClass
    void setup() {
       openBrowser("chrome");
    }

    @Test
    void handleWaitLoadingSuccess() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();

        String expected = dynamicLoadingPage.waitLoadingPage();
        Assert.assertEquals(expected, "Hello World!");
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
