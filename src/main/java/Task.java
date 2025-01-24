public class Task {
    protected static int i = 0;
    protected int index;
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.index = i++;
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return isDone ? "[X]" : "[ ]";
    }

    public void markAsDone() {
        System.out.println();
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    public String taskStatusMessage() {
        return " " + this.getStatusIcon() + " " + this.description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
