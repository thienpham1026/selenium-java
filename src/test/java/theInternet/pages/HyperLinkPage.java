package theInternet.pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class HyperLinkPage {

    public void open() {
        visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickHyperLink(String hyperLink) {
        click(By.linkText(hyperLink));
    }

    public boolean isPageUrlContain(String hyperLink) {
        return getCurrentUrl().contains(String.format("https://the-internet.herokuapp.com/status_codes/%s", hyperLink));
    }
}
