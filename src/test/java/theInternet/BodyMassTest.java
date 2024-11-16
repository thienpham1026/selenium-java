package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.BodyMassPage;

public class BodyMassTest {

    @BeforeClass
    void setup(){
        Browser.openBrowser("chrome");
    }

    @Test
    void calculatorBMI() {
        BodyMassPage bodyMassPage = new BodyMassPage();
        bodyMassPage.open();

        bodyMassPage.fillCalculator("30", "160", "51");

//        Assert.assertTrue(bodyMassPage.isResultCorrect("19.9"));
    }

    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
