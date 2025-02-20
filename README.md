# Pluto ChatBot

Pluto is a chatbot for managing your tasks and schedule

## Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.

## Commands

### help
Lists out all possible commands that Pluto can execute

Format: help

### list
Lists out all the tasks in your task list

Format: list

### mark
Marks a task as completed

Format: mark TASK_INDEX_NUMBER

### unmark
Marks a task as not completed

Format: unmark TASK_INDEX_NUMBER

### todo
Adds a ToDo task (a task with no date specified) to your task list 

Format: todo TASK_DESCRIPTION

### deadline
Adds a Deadline task (a task with specified end date) to your task list

Format: deadline TASK_DESCRIPTION /by YYYY-MM-DD

### event
Adds an Event task (a task with specified start and end date) to your task list

Format: event TASK_DESCRIPTION /from YYYY-MM-DD /to YYYY-MM-DD
