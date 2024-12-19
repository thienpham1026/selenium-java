package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theInternet.pages.DropDownPage;

import static supports.Browser.*;

public class DropDownTest {
    DropDownPage dropDownPage;

    @BeforeClass
    void setup() {
        openBrowser("chrome");
        dropDownPage = new DropDownPage();
    }

    @Test
    void ableSelectOption() {
        dropDownPage.open("https://the-internet.herokuapp.com/dropdown");
        dropDownPage.selectOption("Option 1");

        Assert.assertTrue(dropDownPage.isSelected("Option 1"));
    }

    @Test
    void ableSelectMultipleOptions() {
        dropDownPage.open("https://output.jsbin.com/osebed/2");
        boolean isMulti = dropDownPage.selectedMultiOption();
        Assert.assertTrue(isMulti);

        dropDownPage.selectMultiOption("Banana", "Apple");

        Assert.assertTrue(dropDownPage.isMultiSelected("banana"));
        Assert.assertTrue(dropDownPage.isMultiSelected("apple"));

        dropDownPage.deSelectOption("Banana");

        Assert.assertFalse(dropDownPage.isMultiSelected("banana"));
        Assert.assertTrue(dropDownPage.isMultiSelected("apple"));

        dropDownPage.deSelectAll();

        Assert.assertFalse(dropDownPage.isMultiSelected("banana"));
        Assert.assertFalse(dropDownPage.isMultiSelected("apple"));
        Assert.assertFalse(dropDownPage.isMultiSelected("orange"));
        Assert.assertFalse(dropDownPage.isMultiSelected("grape"));
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
