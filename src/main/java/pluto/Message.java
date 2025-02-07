package pluto;

/**
 * Represents a Message class. This class
 * is in charge of displaying messages from Pluto
 */
public class Message {

    /**
     * Displays the welcome message when bot is started up
     */
    public void showWelcomeMessage() {
        String greeting = "Hi! I am pluto.Pluto\n" + "What can I do for you today? \n\n";
        System.out.println(greeting);
    }

    /**
     * Displays goodbye message when bot is exited
     */
    public void showGoodbyeMessage() {
        String goodbye = "Bye! Hope to see you again :)";
        System.out.println(goodbye);
    }

    /**
     * Displays message that task is added to the list
     * Displays the new number of tasks in the list
     * @param task the Task to be added
     * @param size an int that shows the new number of tasks in the list
     */
    public void addTaskMessage(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task.toString());
        System.out.println("Now you have " + size + " tasks in your list");

    }

    /**
     * Lists the current task
     * @param task the current Task
     * @param index the index of the Task in the list
     */
    public void listTaskMessage(Task task, int index) {
        System.out.println(index + ". " + task.toString());
    }

    /**
     * Displays the task's status after being marked completed
     * @param task the Task that is marked completed
     */
    public void markTaskMessage(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.taskStatusMessage());
    }

    /**
     * Displays the task's status after being marked as undone
     * @param task the Task to be marked as undone
     */
    public void unmarkTaskMessage(Task task) {
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.println(task.taskStatusMessage());
    }

    /**
     * Displays the message and task list size after
     * a task is removed
     * @param task the Task to be removed
     * @param size the size of the task list after
     *             the specified task is removed
     */
    public void removeTaskMessage(Task task, int size) {
        System.out.println("Noted. I've remove this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + size + " tasks in your list");
    }

    public static void newListMessage() {
        System.out.println("No existing saved file found, creating a new empty list");
    }

    public static void showErrorMessage(String message) {
        System.out.println(message);
    }
}
