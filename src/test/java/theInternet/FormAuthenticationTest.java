package theInternet;

import org.testng.Assert;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.FormAuthenticationPage;

public class FormAuthenticationTest {

    @Test
    void shouldBeSuccessfully() {
        Browser.openBrowser("chrome");

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith","SuperSecretPassword!");

        Assert.assertEquals(Browser.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(formAuthenticationPage.isLoggedIn());

        Browser.quit();
    }

    @Test
    void shouldBeInValidUsername() {
        Browser.openBrowser("chrome");

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("thienpt", "SuperSecretPassword!");

        Assert.assertEquals(Browser.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
        Assert.assertTrue(formAuthenticationPage.isNotLoggedIn());

        Browser.quit();
    }

    @Test
    void shouldBeInvalidPassword() {

        Browser.openBrowser("chrome");

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith", "superSecretPassword!");

        Assert.assertEquals(Browser.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
        Assert.assertTrue(formAuthenticationPage.isNotLoggedIn());

        Browser.quit();
    }
}
