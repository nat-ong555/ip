package pluto;

import java.util.Scanner;

/**
 * Represents the main Pluto class. This class
 * runs the main function that starts the chatbot
 */
public class Pluto {
    private TaskList taskList;
    private Message message;
    private Storage storage;
    private Parser parser;

    /**
     * Creates the chatbot Pluto
     */
    public Pluto() {
        this.message = new Message();
        this.storage = new Storage("tasks.txt");
        this.taskList = new TaskList(storage.loadTasks());
        this.parser = new Parser(taskList);
    }

    /**
     * Runs the chatbot's main program
     */
    public void run() {
        message.showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            try {
                input = scanner.nextLine();
                if (input.equals("bye")) {
                    message.showGoodbyeMessage();
                    break;
                }
                parser.parse(input);
                storage.saveTasks(taskList.getTaskList());
            } catch (PlutoException e) {
                System.out.println("OOPS! " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("OOPS! Task number is out of range");
            } catch (NumberFormatException e) {
                System.out.println("OOPS! Task number must be a valid number");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Pluto().run();
    }
}
