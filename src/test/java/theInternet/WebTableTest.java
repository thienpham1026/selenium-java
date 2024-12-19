package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theInternet.pages.WebTablePage;

import java.util.List;

import static supports.Browser.*;

public class WebTableTest {
    WebTablePage webTablePage;

    @BeforeClass
    void setUp() {
        openBrowser("chrome");
        webTablePage = new WebTablePage();
        webTablePage.open();
    }

    @Test
    void dataTables() {
        Assert.assertEquals(webTablePage.getMaxDuePersonTable1(), "Jason Doe");
    }

    @Test
    void verifyMaxDuePerson() {
        Assert.assertEquals(webTablePage.getMaxDuePersonOfTable1(), "Jason Doe");
    }

    @Test
    void verifyMinDueValuePerson() {
        Assert.assertEquals(webTablePage.getMinDuePersonOfTable1(), List.of("John Smith", "Tim Conway"));
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
