package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.FormAuthenticationPage;

public class FormAuthenticationTest {

    @BeforeClass
    void setup() {
        Browser.openBrowser("chrome");
    }

    @Test
    void shouldBeSuccessfully() {

        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith","tomsmith");

        Assert.assertTrue(formAuthenticationPage.isLoggedIn());

        //Assert.assertEquals(formAuthenticationPage.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @Test
    void shouldBeInValidUsername() {

        FormAuthenticationPage loginPage = new FormAuthenticationPage();
        loginPage.login("thienpt", "SuperSecretPassword!");

        //Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
    }

    @Test
    void shouldBeInvalidPassword() {

        FormAuthenticationPage loginPage = new FormAuthenticationPage();
        loginPage.login("tomsmith", "superSecretPassword!");

        //Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
    }

    @AfterClass
    void tearDown() {
        BrowserUtils.quit();
    }
}
