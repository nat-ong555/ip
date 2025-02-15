package pluto;


/**
 * Represents a Parser class. This class processes
 * and handles user commands
 */
public class Parser {
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_MARK = "mark";
    private static final String COMMAND_UNMARK = "unmark";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DELETE = "delete";
    private static final String COMMAND_FIND = "find";
    private static final String COMMAND_SCHEDULE = "schedule";
    private TaskList taskList;

    /**
     * Creates a new Parser to process user commands
     * @param taskList the Task List that contains
     *                 the tasks added by users
     */
    public Parser(TaskList taskList) {
        assert taskList != null : "taskList should not be null";
        this.taskList = taskList;
    }

    /**
     * Parses all the user commands to be
     * handled by the chatbot
     * @param input the String that is the user's command
     * @throws PlutoException if the command format is incorrect
     */
    public String parse(String input) throws PlutoException {
        String[] parts = input.split(" ", 2);
        assert parts.length > 0 : "Input split should produce at least one part";
        String command = parts[0].trim().toLowerCase();
        String response;

        switch (command) {
        case COMMAND_LIST:
            response = taskList.listTasks();
            break;
        case COMMAND_MARK:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a task number to mark.");
            }
            int markIndex = Integer.parseInt(parts[1]) - 1;
            assert markIndex >= 0 : "Mark index should be non-negative";
            response = taskList.markTask(markIndex);
            break;
        case COMMAND_UNMARK:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a task number to unmark.");
            }
            int unmarkIndex = Integer.parseInt(parts[1]) - 1;
            assert unmarkIndex >= 0 : "Unmark index should be non-negative";
            response = taskList.unmarkTask(unmarkIndex);
            break;
        case COMMAND_TODO:
            if (parts.length < 2) {
                throw new PlutoException("The description of a todo cannot be empty.");
            } else {
                ToDo todo = new ToDo(parts[1]);
                response = taskList.addTask(todo);
            }
            break;
        case COMMAND_DEADLINE:
            if (parts.length < 2 || !parts[1].contains(" /by ")) {
                throw new PlutoException("The deadline format is incorrect. "
                        + "Please use: deadline <task> /by <yyyy-mm-dd>");
            } else {
                String[] deadlineParts = parts[1].split(" /by ", 2);
                Deadline deadline = new Deadline(deadlineParts[0], deadlineParts[1]);
                response = taskList.addTask(deadline);
            }
            break;
        case COMMAND_EVENT:
            if (parts.length < 2 || !parts[1].contains(" /from ") || !parts[1].contains(" /to ")) {
                throw new PlutoException("The event format is incorrect. Please use: "
                        + "event <task> /from <yyyy-mm-dd> /to <yyyy-mm-dd>");
            } else {
                String[] eventParts = parts[1].split(" /from | /to ", 3);
                Event event = new Event(eventParts[0], eventParts[1], eventParts[2]);
                response = taskList.addTask(event);
            }
            break;
        case COMMAND_DELETE:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a task number to delete");
            }
            int deleteIndex = Integer.parseInt(parts[1]) - 1;
            assert deleteIndex >= 0 : "Delete index should be non-negative";
            response = taskList.removeTask(deleteIndex);
            break;
        case COMMAND_FIND:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a keyword for searching");
            } else {
                String keyword = parts[1];
                response = taskList.findTasks(keyword);
            }
            break;
        case COMMAND_SCHEDULE:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a date for searching. " +
                        "Use: schedule <yyyy-mm-dd>");
            } else {
                String date = parts[1];
                response = taskList.scheduleTasks(date);
            }
            break;
        default:
            throw new PlutoException("I'm sorry, but I don't know what that means :-(");
        }
        return response;
    }
}
