# Pluto User Guide

// Product screenshot goes here

Pluto is an easy-to-use task managing chatbot that helps you to organize your tasks.
This guide will walk you through the available commands and what they do.

## Commands

### Listing all tasks: `list`
Lists out all the tasks in your task list

Format: `list`

### Marking a task: `mark`
Marks a task as completed

Format: `mark TASK_INDEX_NUMBER`

Example: 
- `mark 2` Marks the task at index 2 as completed

### Unmarking a task: `unmark`
Marks a task as not completed

Format: `unmark TASK_INDEX_NUMBER`

5. todo
   - Adds a ToDo task (a task with no date specified) to your task list 

   - Format: `todo TASK_DESCRIPTION`

6. deadline
   - Adds a Deadline task (a task with specified end date) to your task list

   - Format: `deadline TASK_DESCRIPTION /by YYYY-MM-DD`

7. event
   - Adds an Event task (a task with specified start and end date) to your task list

   - Format: `event TASK_DESCRIPTION /from YYYY-MM-DD /to YYYY-MM-DD`

8. delete
   - Deletes a task from your task list

   - Format: `delete TASK_INDEX_NUMBER`

9. find
   - Finds all the tasks with the specified keyword in your task list

   - Format: `find KEYWORD`

10. schedule
   - Lists out all the tasks due/happening on a specified date

   - Format: `schedule YYYY-MM-DD`


## Adding deadlines

// Describe the action and its outcome.

// Give examples of usage

Example: `keyword (optional arguments)`

// A description of the expected outcome goes here

```
expected output
```

## Feature ABC

// Feature details


## Feature XYZ

// Feature details
