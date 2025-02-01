package pluto;

import java.util.Scanner;

public class Pluto {
    private TaskList taskList;
    private Message message;
    private Storage storage;

    /**
     * Creates the chatbot Pluto
     */
    public Pluto() {
        this.message = new Message();
        this.storage = new Storage("tasks.txt");
        this.taskList = new TaskList(storage.loadTasks());
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
                        if (parts.length < 2) {
                            throw new PlutoException("Please provide a task number to mark.");
                        }
                        int markIndex = Integer.parseInt(parts[1]) - 1;
                        taskList.markTask(markIndex);
                        break;

                    case "unmark":
                        if (parts.length < 2) {
                            throw new PlutoException("Please provide a task number to unmark.");
                        }
                        int unmarkIndex = Integer.parseInt(parts[1]) - 1;
                        taskList.unmarkTask(unmarkIndex);
                        break;

                    case "todo":
                        if (parts.length < 2) {
                            throw new PlutoException("The description of a todo cannot be empty.");
                        } else {
                            ToDo todo = new ToDo(parts[1]);
                            taskList.addTask(todo);
                        }
                        break;

                    case "deadline":
                        if (parts.length < 2 || !parts[1].contains(" /by ")) {
                            throw new PlutoException("The deadline format is incorrect. Please use: deadline <task> /by <yyyy-mm-dd>");
                        } else {
                            String[] deadlineParts = parts[1].split(" /by ", 2);
                            Deadline deadline = new Deadline(deadlineParts[0], deadlineParts[1]);
                            taskList.addTask(deadline);
                        }
                        break;

                    case "event":
                        if (parts.length < 2 || !parts[1].contains(" /from ") || !parts[1].contains(" /to ")) {
                            throw new PlutoException("The event format is incorrect. Please use: " +
                                    "event <task> /from <yyyy-mm-dd> /to <yyyy-mm-dd>");
                        } else {
                            String[] eventParts = parts[1].split(" /from | /to ", 3);
                            Event event = new Event(eventParts[0], eventParts[1], eventParts[2]);
                            taskList.addTask(event);
                        }
                        break;

                    case "delete":
                        if (parts.length < 2) {
                            throw new PlutoException("Please provide a task number to delete");
                        }
                        int deleteIndex = Integer.parseInt(parts[1]) - 1;
                        taskList.removeTask(deleteIndex);
                        break;

                    default:
                        throw new PlutoException("I'm sorry, but I don't know what that means :-(");
                }

                storage.saveTasks(taskList.getTaskList());
            } catch (PlutoException e) {
                System.out.println("OOPS! " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("OOPS! pluto.Task number is out of range");
            } catch (NumberFormatException e) {
                System.out.println("OOPS! pluto.Task number must be a valid number.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Pluto().run();
    }
}
