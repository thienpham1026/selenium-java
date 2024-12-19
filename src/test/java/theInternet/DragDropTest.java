package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theInternet.pages.DragDropPage;

import static supports.Browser.*;

public class DragDropTest {

    @BeforeClass
    void setup() {
        openBrowser("chrome");
    }

    @Test
    void successfullyDragA2B() {
        DragDropPage dragDropPage = new DragDropPage();
        dragDropPage.open();
        dragDropPage.action();

        Assert.assertEquals(dragDropPage.getText("a"), "B");
        Assert.assertEquals(dragDropPage.getText("b"), "A");
    }

    @AfterClass
    void tearDown() {
        quit();
    }
}
