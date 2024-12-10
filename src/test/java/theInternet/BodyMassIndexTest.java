package calculator;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;
import supports.Browser;

import static supports.Utils.calculateBmi;

public class BodyMassIndexTest {

    @Parameters({"browser"})
    @BeforeMethod
    void setup(String browser){
       Browser.launchBrowser(browser);
    }

    @DataProvider
    Object[][] bmiTestData(){
        return new Object[][]{
                {"26",182,70,"male"},
                {"25",182,45,"male"}
        };
    }


    @Test(dataProvider = "bmiTestData")
    void verifyBMIValue(String age, double height, double weight, String gender){
        BodyMassIndexPage bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage
                .open()
                .selectMetricTab()
                .clearForm();

        bodyMassIndexPage.fillForm(age, height, weight, gender);

        String expectedResult = calculateBmi(weight,height);
        String actualResult = bodyMassIndexPage.getResult();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @AfterMethod(alwaysRun = true)
    void tearDown(ITestResult testResult){
        if(testResult.isSuccess()){
            Browser.captureScreenShot(testResult.getName());
        }
        Browser.quit();
    }
}
