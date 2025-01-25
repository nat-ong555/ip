import java.util.ArrayList;

// for displaying messages from Pluto
public class Message {
    public void showWelcomeMessage() {
        String greeting = "Hi! I am Pluto\n" + "What can I do for you today? \n\n";
        System.out.println(greeting);
    }

    public void showGoodbyeMessage() {
        String goodbye = "Bye! Hope to see you again :)";
        System.out.println(goodbye);
    }

    public void addTaskMessage(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task.toString());
        System.out.println("Now you have " + size + " tasks in your list");

    }

    public void listTaskMessage(Task task, int index) {
        System.out.println(index + ". " + task.toString());
    }

    public void markTaskMessage(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.taskStatusMessage());
    }

    public void unmarkTaskMessage(Task task) {
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.println(task.taskStatusMessage());
    }

    public void removeTaskMessage(Task task, int size) {
        System.out.println("Noted. I've remove this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + size + " tasks in your list");
    }
}
