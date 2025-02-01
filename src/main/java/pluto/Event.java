package pluto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate from;
    protected LocalDate to;

    /**
     * Creates a new Task, Event, where users can
     * specify a start and end date for a task
     * @param description a String that describes the task
     * @param from a String that specifies the start date of a task
     * @param to a String that specifies the end date of a task
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }

    /**
     * Creates a new Task, Event, where users can
     * specify a start and end date for a task, along with
     * the completion status of the task
     * @param description a String that describes the task
     * @param from a String that specifies the start date of a task
     * @param to a String that specifies the end date of a task
     * @param isDone a boolean value that shows the completion status of a task
     */
    public Event(String description, String from, String to, boolean isDone) {
        super(description, isDone);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }

    @Override
    public String toString() {
        String fromDate = from.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        String toDate = to.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[E]" + super.taskStatusMessage() + " (from: " + fromDate + " to: " + toDate + ")";
    }

    /**
     * Converts a task to file format to be stored in tasks file
     * @return a String to be stored in tasks file
     */
    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}
