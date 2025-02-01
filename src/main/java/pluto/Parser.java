package pluto;

public class Parser {
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_MARK = "mark";
    private static final String COMMAND_UNMARK = "unmark";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DELETE = "delete";
    private static final String COMMAND_FIND = "find";
    private TaskList taskList;


    public Parser(TaskList taskList) {
        this.taskList = taskList;
    }

    public void parse(String input) throws PlutoException {
        String[] parts = input.split(" ", 2);
        String command = parts[0].trim().toLowerCase();

        switch (command) {
        case COMMAND_LIST:
            taskList.listTasks();
            break;
        case COMMAND_MARK:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a task number to mark.");
            }
            int markIndex = Integer.parseInt(parts[1]) - 1;
            taskList.markTask(markIndex);
            break;
        case COMMAND_UNMARK:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a task number to unmark.");
            }
            int unmarkIndex = Integer.parseInt(parts[1]) - 1;
            taskList.unmarkTask(unmarkIndex);
            break;
        case COMMAND_TODO:
            if (parts.length < 2) {
                throw new PlutoException("The description of a todo cannot be empty.");
            } else {
                ToDo todo = new ToDo(parts[1]);
                taskList.addTask(todo);
            }
            break;
        case COMMAND_DEADLINE:
            if (parts.length < 2 || !parts[1].contains(" /by ")) {
                throw new PlutoException("The deadline format is incorrect. Please use: deadline <task> /by <yyyy-mm-dd>");
            } else {
                String[] deadlineParts = parts[1].split(" /by ", 2);
                Deadline deadline = new Deadline(deadlineParts[0], deadlineParts[1]);
                taskList.addTask(deadline);
            }
            break;
        case COMMAND_EVENT:
            if (parts.length < 2 || !parts[1].contains(" /from ") || !parts[1].contains(" /to ")) {
                throw new PlutoException("The event format is incorrect. Please use: " +
                        "event <task> /from <yyyy-mm-dd> /to <yyyy-mm-dd>");
            } else {
                String[] eventParts = parts[1].split(" /from | /to ", 3);
                Event event = new Event(eventParts[0], eventParts[1], eventParts[2]);
                taskList.addTask(event);
            }
            break;
        case COMMAND_DELETE:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a task number to delete");
            }
            int deleteIndex = Integer.parseInt(parts[1]) - 1;
            taskList.removeTask(deleteIndex);
            break;
        case COMMAND_FIND:
            if (parts.length < 2) {
                throw new PlutoException("Please provide a keyword for searching");
            } else {
                String keyword = parts[1];
                taskList.findTasks(keyword);
            }
            break;
        default:
            throw new PlutoException("I'm sorry, but I don't know what that means :-(");
        }
    }
}