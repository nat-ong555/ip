public abstract class Task {
    protected static int i = 0;
    protected int index;
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.index = i++;
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.index = i++;
        this.description = description;
        this.isDone = isDone;
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

    public abstract String toFileFormat();

    public static Task fromFileFormat(String line) {
        String[] parts = line.split(" \\| ");
        boolean isDone = parts[1].equals("1");
        switch (parts[0]) {
            case "T":
                return new ToDo(parts[2], isDone);
            case "D":
                return new Deadline(parts[2], parts[3], isDone);
            case "E":
                return new Event(parts[2], parts[3], parts[4], isDone);
            default:
                return null;
        }
    }
}
