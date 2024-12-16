package theInternet.pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class FormAuthenticationPage {

    By usernameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By loginButton = By.cssSelector("button[type=submit]");
    By successFlashMessage = By.className("success");


    public void open() {
        visit("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        fill(usernameTextBox, username);
        fill(passwordTextBox, password);
        click(loginButton);
    }

    public boolean isLoggedIn() {
        return getText(successFlashMessage).contains("You logged into a secure area!");
    }

    public boolean isMessageContent(String type, String message) {
        return getText(By.className(type)).contains(message);
    }
}
