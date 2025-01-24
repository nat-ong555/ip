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

    public void addTaskMessage(String task) {
        System.out.println(" added: " + task);
    }

    public void listTaskMessage(String task, int index) {
        System.out.println(index + ". " + task);
    }
}
