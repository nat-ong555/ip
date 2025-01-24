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

            if (input.equals("bye")) {
                message.showGoodbyeMessage();
                break;
            } else if (input.equals("list")) {
                taskList.listTasks();
            } else {
                taskList.addTask(input);
            }
        }

        scanner.close();
    }
    public static void main(String[] args) {
        new Pluto().run();
    }
}
