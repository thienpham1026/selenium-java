package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class FormAuthenticationPage {
    WebDriver driver;

    By usernameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By loginButton = By.cssSelector("button[type=submit]");
    By successFlashMessage = By.className("success");

    public FormAuthenticationPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        return driver.findElement(successFlashMessage).getText().contains("You logged into a secure area!");
    }
}
