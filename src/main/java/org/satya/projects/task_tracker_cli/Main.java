package org.satya.projects.task_tracker_cli;

import org.satya.projects.task_tracker_cli.service.ManageTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Task Tracker Application!");
        ManageTask manageTask = new ManageTask();

        while (true){
            Scanner scanner = new Scanner(System.in);
            String instruction = scanner.nextLine();
            String[] instructionArray = instruction.split(" ");

            switch (instructionArray[0].toLowerCase()){
                case "add":
                    String taskTitle = instructionArray[1];
                    manageTask.addTask(taskTitle);
                    break;
                case "update":
                    String taskId = instructionArray[1];
                    String updatedTaskTitle = instructionArray[2];
                    manageTask.updateTask(taskId,updatedTaskTitle);
                    break;
                case "list":
                    if (instructionArray.length>1){
                        String status = instructionArray[1];
                        manageTask.listTasksByStatus(status);
                    } else {
                        manageTask.listAllTasks();
                    }
                    break;
                case "mark":
                    manageTask.updateTaskStatus(instructionArray[2],instructionArray[1]);
                    break;
                case "delete":
                    manageTask.deleteTask(instructionArray[1]);
                    break;
                default:
                    System.out.println("Enter the proper instruction to mange your tasks");
            }
        }
    }
}