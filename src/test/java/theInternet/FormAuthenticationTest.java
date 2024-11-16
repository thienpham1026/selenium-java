package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.FormAuthenticationPage;

public class FormAuthenticationTest {

    @DataProvider
    Object[][] testData() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "success", "https://the-internet.herokuapp.com/secure", "You logged into a secure area!"},
                {"thienpt", "SuperSecretPassword!", "error", "https://the-internet.herokuapp.com/login", "Your username is invalid!"},
                {"tomsmith", "SuperSecretPassword", "error", "https://the-internet.herokuapp.com/login", "Your password is invalid!"}
        };
    }

    @BeforeMethod
    void setup() {
        Browser.openBrowser("chrome");
    }

    @Test(dataProvider = "testData")
    void loginWithDataProvider(String username, String password, String type, String expectedUrl, String expectedText) {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login(username, password);

        Assert.assertEquals(Browser.getCurrentUrl(), expectedUrl);
        Assert.assertTrue(formAuthenticationPage.isMessageContent(type, expectedText));
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }
}
