package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.HoverPage;

public class HoverTest {

    @DataProvider
    Object[][] testData() {
        return new Object[][]{
                {0, "name: user1"},
                {1, "name: user2"},
                {2, "name: user3"},
        };
    }

    @BeforeClass
    void setup() {
        Browser.openBrowser("chrome");
    }

    @Test(dataProvider = "testData")
    void ableToHoverImage(int imageIndex, String expectedImageName) {
        HoverPage hoverPage = new HoverPage();
        hoverPage.open();

        String imageName = hoverPage.ableHover(imageIndex);
        Assert.assertEquals(imageName, expectedImageName);
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
