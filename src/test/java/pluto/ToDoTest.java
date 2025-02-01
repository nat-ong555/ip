package pluto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {

    @Test
    public void todoTask_markedAsDone_success() {
        ToDo task = new ToDo("Return book");
        task.markAsDone();
        assertEquals(" [X] Return book", task.taskStatusMessage());
    }

    @Test
    public void newToDoTask_markedAsUndone_success() {
        ToDo task = new ToDo("Submit assignment");
        assertEquals(" [ ] Submit assignment", task.taskStatusMessage());
    }
}
