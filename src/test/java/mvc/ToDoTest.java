package mvc;

import mvc.pages.ToDoPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Utils;

import static supports.Browser.*;

public class ToDoTest {
    ToDoPage toDoPage;

    @BeforeClass
    void setup(){
        openBrowser("chrome");
        toDoPage = new ToDoPage();
        toDoPage.open();
    }

    @Test
    void ableCreateNewTask(){
        int numberItemsLeftBefore = toDoPage.getItemsLeft();
        String taskName = String.format("task %s", Utils.generateRandomString(24));

        toDoPage.addNewTask(taskName);
        int numberItemsLeftAfter = toDoPage.getItemsLeft();
        Assert.assertTrue(toDoPage.isTaskExist(taskName));
        Assert.assertEquals(numberItemsLeftAfter-numberItemsLeftBefore,1);
    }

    @Test
    void ableMarkCompleteTask(){
        String taskName = String.format("task %s",Utils.generateRandomString(24));
        toDoPage.addNewTask(taskName);
        int numberItemsLeftBefore = toDoPage.getItemsLeft();

        toDoPage.markComplete(taskName);

        int numberItemsLeftAfter = toDoPage.getItemsLeft();
        Assert.assertTrue(toDoPage.isTaskCompleted(taskName));
        Assert.assertEquals(numberItemsLeftAfter-numberItemsLeftBefore,-1);
    }

    @Test
    void ableDeleteTask(){
        String taskName = String.format("task %s",Utils.generateRandomString(24));
        toDoPage.addNewTask(taskName);
        int numberItemsLeftBefore = toDoPage.getItemsLeft();

        toDoPage.delete(taskName);

        int numberItemsLeftAfter = toDoPage.getItemsLeft();
        Assert.assertFalse(toDoPage.isTaskExist(taskName));
        Assert.assertEquals(numberItemsLeftAfter-numberItemsLeftBefore,-1);
    }

    @Test
    void ableEditTaskName(){
        String taskName = String.format("task %s",Utils.generateRandomString(24));
        String newTaskName = String.format("task %s",Utils.generateRandomString(24));
        System.out.println(taskName);
        System.out.println(newTaskName);

        toDoPage.addNewTask(taskName);
        int numberItemsLeftBefore = toDoPage.getItemsLeft();

        toDoPage.editTaskName(taskName,newTaskName);

        int numberItemsLeftAfter = toDoPage.getItemsLeft();
        Assert.assertTrue(toDoPage.isTaskExist(newTaskName));
        Assert.assertEquals(numberItemsLeftAfter,numberItemsLeftBefore);
    }

    @AfterMethod
    void captureScreenshot(){

    }

    @AfterClass
    void tearDown(){
       quit();
    }
}
