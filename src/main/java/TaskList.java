import java.util.ArrayList;
public class TaskList {
    private ArrayList<String> taskList;
    private Message message;

    public TaskList() {
        this.taskList = new ArrayList<>();
        this.message = new Message();
    }

    public void addTask(String task) {
        this.taskList.add(task);
        message.addTaskMessage(task);
    }

    public void listTasks() {
        for (int i = 0; i < taskList.size(); i++) {
            int index = i + 1;
            message.listTaskMessage(taskList.get(i), index);
        }
    }
}
