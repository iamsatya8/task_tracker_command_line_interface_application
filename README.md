# Task Tracker Command Line Interface (Java) - https://github.com/iamsatya8/task_tracker_command_line_interface_application

Task Tracker is a simple Command Line Interface (CLI) application to track and manage your tasks.  
It allows you to add, update, delete, and monitor task status using a JSON file.

___

## Features

- Add tasks
- Update tasks
- Delete tasks
- Mark tasks as:
    - to-do
    - in-progress
    - done
- List:
    - All tasks
    - Tasks by status

## Requirements

- Java (JDK 8 or above)
- Maven

---

## How to Run

1. Clone the repository 
2. Open the project in your IDE (IntelliJ / Eclipse)
3. Run the `Main.java` file
4. Once the application starts, follow the below instructions in the console

## How to Use
### ➕ To Add New Task
- add `<task_title>` Example: `add Buy_The_Grocories`
### ✏️ To Update Task Title
- update `<taskId>` `<task_title>` Example: `update 2 Make_a_toy`
### 📋 To Display Tasks
- To List all the tasks
    - list - `It Lists all the tasks`
- To List the tasks based on task Status
    - list `<task_Status>` Example 1: `list to_do`, Example 2: `list done`, Example 3: `list in_progress`
### ❌ To Delete Task
- delete `<taskId>` Example: `delete 1`
### 🔄 To Update Task Status
- mark `<updated_task_status>` Example 1: `mark done 1`, Example 2: `mark in_progress 2`

---

## Task Details

Each task contains:

- id
- description
- status (to-do / in-progress / done)
- createdAt
- updatedAt

---

## Notes

- Tasks are stored in `tasks.json`
- Use `_` instead of spaces in task names
- Make sure to enter commands exactly as shown above

---
