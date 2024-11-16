package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.CheckboxesPage;

public class CheckboxesTest {
    CheckboxesPage checkboxesPage;

    @BeforeClass
    void setup() {
        Browser.openBrowser("chrome");
        checkboxesPage = new CheckboxesPage();
        checkboxesPage.open();
    }

    @Test
    void ableSelectACheckboxes() {
        checkboxesPage.check("#checkboxes input:nth-child(1)");
        Assert.assertTrue(checkboxesPage.isChecked("#checkboxes input:nth-child(1)"));

        checkboxesPage.check("#checkboxes input:nth-child(3)");
        Assert.assertTrue(checkboxesPage.isChecked("#checkboxes input:nth-child(3)"));
    }

    @Test
    void ableUnSelectACheckboxes() {
        checkboxesPage.unCheck("#checkboxes input:nth-child(3)");
        Assert.assertFalse(checkboxesPage.isChecked("#checkboxes input:nth-child(3)"));
    }

    @AfterClass
    void tearDown() {
        Browser.quit();
    }
}
