package pluto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate from;
    protected LocalDate to;
    public Event(String description, String from, String to) {
        super(description);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }

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

    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}
