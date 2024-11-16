package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class HyperLinkPage {
    WebDriver driver;

    public HyperLinkPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickHyperLink(String hyperLink) {
        Browser.click(By.linkText(hyperLink));
    }

    public boolean isPageUrlContain(String hyperLink) {
        return Browser.getCurrentUrl().contains(String.format("https://the-internet.herokuapp.com/status_codes/%s", hyperLink));
    }
}
