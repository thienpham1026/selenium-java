package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theInternet.pages.HyperLinkPage;

import static supports.Browser.*;

public class HyperLinkTest {

    @BeforeClass
    void setup() {
        openBrowser("chrome");
    }

    @Test
    void verifyNavigateHyperLink() {
        HyperLinkPage hyperLinkPage = new HyperLinkPage();
        hyperLinkPage.open();

        hyperLinkPage.clickHyperLink("200");
        Assert.assertTrue(hyperLinkPage.isPageUrlContain("200"));
        hyperLinkPage.clickHyperLink("here");

        hyperLinkPage.clickHyperLink("301");
        Assert.assertTrue(hyperLinkPage.isPageUrlContain("301"));
        hyperLinkPage.clickHyperLink("here");

        hyperLinkPage.clickHyperLink("404");
        Assert.assertTrue(hyperLinkPage.isPageUrlContain("404"));
        hyperLinkPage.clickHyperLink("here");

        hyperLinkPage.clickHyperLink("500");
        Assert.assertTrue(hyperLinkPage.isPageUrlContain("500"));
        hyperLinkPage.clickHyperLink("here");
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
