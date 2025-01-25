import java.util.ArrayList;
public class TaskList {
    private ArrayList<Task> taskList;
    private Message message;

    public TaskList() {
        this.taskList = new ArrayList<>();
        this.message = new Message();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
        message.addTaskMessage(task, taskList.size());
    }

    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            int index = i + 1;
            message.listTaskMessage(taskList.get(i), index);
        }
    }

    public void markTask(int taskIndex) {
        Task t = taskList.get(taskIndex);
        t.markAsDone();
        message.markTaskMessage(t);
    }

    public void unmarkTask(int taskIndex) {
        Task t = taskList.get(taskIndex);
        t.markAsUndone();
        message.unmarkTaskMessage(t);
    }

    public void removeTask(int taskIndex) throws PlutoException {
        if (taskIndex < 0 || taskIndex >= taskList.size()) {
            throw new PlutoException("Task number is out of range.");
        }
        Task removedTask = taskList.remove(taskIndex);
        message.removeTaskMessage(removedTask, taskList.size());
    }
}
