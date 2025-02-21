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

### Adding a To Do task: `todo`
Adds a ToDo task (a task with no date specified) to your task list 

Format: `todo TASK_DESCRIPTION`

Example: `todo read book` Adds a ToDo task with description "read book" to your task list

### Adding a Deadline task: `deadline`
Adds a Deadline task (a task with specified end date) to your task list

Format: `deadline TASK_DESCRIPTION /by YYYY-MM-DD`

Example: `deadline return book /by 2025-02-10` Adds a Deadline task with description "return book" by Feb 10 2025 to your task list

### Adding an Event task: `event`
Adds an Event task (a task with specified start and end date) to your task list

Format: `event TASK_DESCRIPTION /from YYYY-MM-DD /to YYYY-MM-DD`

Example: `event book fair /from 2025-01-03 /to 2025-01-05` Adds an Event task with description "book fair" from Jan 3 2025 to Jan 5 2025 to your task list

### Deleting a task: `delete`
Deletes a task from your task list

Format: `delete TASK_INDEX_NUMBER`

Example: `delete 3` Deletes the task at index 3 from your task list

### Finding tasks by keyword: `find`
Finds all the tasks with the specified keyword in your task list

Format: `find KEYWORD`

Example: `find book` Returns all the tasks in your task list that contains the word "book"

### Listing tasks for a specific date: `schedule`
Lists out all the tasks due/happening on a specified date

Format: `schedule YYYY-MM-DD`

Example: `schedule 2025-02-10` Returns a list of all the tasks due/happening on Feb 10 2025


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
