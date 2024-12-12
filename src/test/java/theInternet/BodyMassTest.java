package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static supports.Browser.*;
import static supports.Utils.calculateBmi;

import theInternet.pages.BodyMassPage;

public class BodyMassTest {
    @BeforeClass
    void setup() {
        openBrowser("chrome");
    }

    @DataProvider
    Object[][] bmiTestData() {
        return new Object[][]{
                {"26", 182, 70, "male"},
                {"25", 182, 45, "male"},
                {"31", 160, 51, "female"}
        };
    }

//    @Test(dataProvider = "bmiTestData")
//    void calculatorBMI(String age, double height, double weight, String gender) {
//        BodyMassPage bodyMassPage = new BodyMassPage();
//        bodyMassPage.open();
//
//        bodyMassPage.fillCalculator(age, height, weight, gender);
//
//        String expectedResult = calculateBmi(weight, height);
//
//        Assert.assertTrue(bodyMassPage.isResultCorrect(expectedResult));
//    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
