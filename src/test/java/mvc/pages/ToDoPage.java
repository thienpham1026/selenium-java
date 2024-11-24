package mvc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import supports.Browser;

import java.util.List;

import static supports.Browser.*;

public class ToDoPage {
    public void open(){
        visit("https://todomvc.com/examples/react/dist/#/");
    }

    public void addNewTask(String taskName){
        fill(By.className("new-todo"),taskName+"\n");
    }

    public void markComplete(String taskName){
        getTask(taskName).findElement(By.tagName("input")).click();
    }

    public void delete(String taskName){
        hover(getTask(taskName));
        getTask(taskName).findElement(By.tagName("button")).click();
    }
//    /*
//    <div class="input-container">
//        <input class="new-todo" id="todo-input" type="text" data-testid="text-input" value="task vkfmfqsB1FaGXP01lepET53l">
//        <label class="visually-hidden" for="todo-input">Edit Todo Input</label>
//     </div>
//     */

    /*
    <li class="" data-testid="todo-item">
       <div class="view">
           <div class="input-container">
               <input class="new-todo" id="todo-input" type="text" data-testid="text-input" value="task">
               <label class="visually-hidden" for="todo-input">Edit Todo Input</label>
           </div>
       </div>
   </li>
     */
    public void editTaskName(String taskName,String newName){
        WebElement task = getTask(taskName);

        doubleClick(task);
        WebElement editTaskNameTextBox = task.findElement(By.cssSelector("input.new-todo"));
        executeScript(editTaskNameTextBox,"arguments[0].value = ''");
        editTaskNameTextBox.sendKeys(newName,Keys.ENTER);


//
//
//
////        WebElement todoEditInput = browser.find(editTodoBtn, todoToEdit);
//        browser.executeScript("arguments[0].value = ''",
//                todoEditInput);

//        browser.type(todoEditInput, newTodoName + Keys.ENTER);
    }



    public boolean isTaskExist(String taskName){
        List<WebElement> tasks = getElements(By.cssSelector(".todo-list li"));
        if (tasks.isEmpty())  return  false;

        String lastTaskName=  tasks.get(tasks.size()-1).getText();
        return taskName.contains(lastTaskName);
    }

    public WebElement getTask(String taskName){
        List<WebElement> tasks = getElements(By.cssSelector(".todo-list li"));
        return tasks.stream()
                .filter(task -> task.getText().equals(taskName))
                .findFirst()
                .get();
    }

    public boolean isTaskCompleted(String taskName){
        return getTask(taskName).getAttribute("class").contains("completed");
    }

    public int getItemsLeft(){
        if(getElements(By.className("todo-count")).isEmpty()) return 0;

        String itemsLeftContext = Browser.getText(By.className("todo-count"));
        return Integer.parseInt(itemsLeftContext.split(" ")[0]);
    }
}