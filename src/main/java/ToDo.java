import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.taskStatusMessage();
    }
}
