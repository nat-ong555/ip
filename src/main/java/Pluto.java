import java.util.Scanner;

public class Pluto {
    private TaskList taskList;
    private Message message;

    public Pluto() {
        this.message = new Message();
        this.taskList = new TaskList();
    }

    public void run() {
        message.showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 2) {
                if (parts[0].equals("mark")) {
                    int taskIndex = Integer.parseInt(parts[1]) - 1;
                    taskList.markTask(taskIndex);
                } else if (parts[0].equals("unmark")) {
                    int taskIndex = Integer.parseInt(parts[1]) - 1;
                    taskList.unmarkTask(taskIndex);
                } else {
                    Task t = new Task(input);
                    taskList.addTask(t);
                }
            } else {
                if (input.equals("bye")) {
                    message.showGoodbyeMessage();
                    break;
                } else if (input.equals("list")) {
                    taskList.listTasks();
                } else {
                    Task t = new Task(input);
                    taskList.addTask(t);
                }
            }
        }

        scanner.close();
    }
    public static void main(String[] args) {
        new Pluto().run();
    }
}
