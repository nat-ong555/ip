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
            input = scanner.nextLine().trim();

            if (input.equals("bye")) {
                message.showGoodbyeMessage();
                break;
            } else if (input.equals("list")) {
                taskList.listTasks();
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0];

            switch (command) {
                case "mark":
                    int markIndex = Integer.parseInt(parts[1]) - 1;
                    taskList.markTask(markIndex);
                    break;

                case "unmark":
                    int unmarkIndex = Integer.parseInt(parts[1]) - 1;
                    taskList.unmarkTask(unmarkIndex);
                    break;

                case "todo":
                    if (parts.length < 2) {
                        System.out.println("OOPS! The description of a todo cannot be empty.");
                    } else {
                        ToDo todo = new ToDo(parts[1]);
                        taskList.addTask(todo);
                    }
                    break;

                case "deadline":
                    if (parts.length < 2 || !parts[1].contains(" /by ")) {
                        System.out.println("OOPS! The deadline format is incorrect.");
                    } else {
                        String[] deadlineParts = parts[1].split(" /by ", 2);
                        Deadline deadline = new Deadline(deadlineParts[0], deadlineParts[1]);
                        taskList.addTask(deadline);
                    }
                    break;

                case "event":
                    if (parts.length < 2 || !parts[1].contains(" /from ") || !parts[1].contains(" /to ")) {
                        System.out.println("OOPS! The event format is incorrect.");
                    } else {
                        String[] eventParts = parts[1].split(" /from | /to ", 3);
                        Event event = new Event(eventParts[0], eventParts[1], eventParts[2]);
                        taskList.addTask(event);
                    }
                    break;

                default:
                    System.out.println("OOPS! I'm sorry, but I don't know what that means :-(");
                    break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Pluto().run();
    }
}
