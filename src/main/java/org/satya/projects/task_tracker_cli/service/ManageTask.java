package org.satya.projects.task_tracker_cli.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.satya.projects.task_tracker_cli.model.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManageTask {

    private static int taskId =  1;
    private ObjectMapper objectMapper = new ObjectMapper();
    private File file = new File(System.getProperty("user.dir") + "/tasks.json");
    private List<Task> tasks;

    public void addTask(String taskTitle){
        Date currentDateAndTime = new Date();
        Task task = new Task(String.valueOf(taskId),taskTitle,"to-do",currentDateAndTime.toString());
        taskId++;
        try {
            if (file.exists() && file.length()>0){
                tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {});
            } else {
                tasks = new ArrayList<>();
            }
            tasks.add(task);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,tasks);
            System.out.println("Task added successfully!");
        } catch (Exception e){
            System.out.println("ERROR : "+e.getMessage());
        }
    }

    public void updateTask(String taskId, String updatedTaskTitle){
        Date updatedDateAndTime = new Date();
        try{
            if (file.exists() && file.length()>0){
                tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {});
                Task task = tasks.stream()
                        .filter(t -> t.getId().equals(taskId))
                        .findFirst()
                        .orElse(null);
                if (task!=null){
                    task.setUpdatedAt(updatedDateAndTime.toString());
                    task.setDescription(updatedTaskTitle);
                    objectMapper.writerWithDefaultPrettyPrinter()
                            .writeValue(new File("tasks.json"), tasks);

                    System.out.println("Task updated successfully!");
                } else {
                    System.out.println("Task not found");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listAllTasks(){
        try {
            if (file.exists() && file.length()>0){
                tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {});
                tasks.stream()
                        .forEach(task -> System.out.println(task));
            } else {
                System.out.println("You don't have any tasks! Happy Day.");
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void listTasksByStatus(String status) {
        try {
            if (file.exists() && file.length()>0){
                tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {});
                tasks.stream()
                        .filter(task -> task.getStatus().equalsIgnoreCase(status))
                        .forEach(task -> System.out.println(task));
            } else {
                System.out.println("You don't have any "+"\""+status+"\""+" tasks! Happy Day.");
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateTaskStatus(String taskId, String taskStatus) {
        try {
            if (file.exists() && file.length()>0){
                tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {});

                Task task = tasks.stream()
                        .filter(t -> t.getId().equalsIgnoreCase(taskId))
                        .findFirst()
                        .orElse(null);
                if (task!=null){
                    task.setStatus(taskStatus);
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("tasks.json"),tasks);
                    System.out.println("Your Task "+"\""+task.getDescription()+"\""+" status Updated to "+"\""+taskStatus+"\"");
                } else {
                    System.out.println("Task is null!");
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteTask(String taskId) {
        try {
            if (file.exists() && file.length()>1){
                tasks = objectMapper.readValue(file, new TypeReference<List<Task>>() {});
                tasks.removeIf(task -> task.getId().equalsIgnoreCase(taskId));
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("tasks.json"),tasks);
                System.out.println("Your Task "+"\""+taskId+"\""+" is Deleted");
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
