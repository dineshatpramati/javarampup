package com.imaginea.pomodoroapp;

import com.imaginea.pomodoroapp.model.Task;
import com.imaginea.pomodoroapp.service.TaskService;
import com.imaginea.pomodoroapp.service.TaskServiceFactory;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PomodoroApp {

    public static void main(String[] args) {
	// write your code here

        List<Task> tasklist = new ArrayList<>();


        TaskService taskService = TaskServiceFactory.getTaskServiceInstance();

        Scanner  sc = new Scanner(System.in);

        System.out.println("Enter option from menu below to do operations ->");
        System.out.println("Press 1.Add new task in todo list, 2.Mark existing task as completed ,3.Delete an existing task from todo list,4.View all tasks ,5.Exit ");

        int selectedoption ;
        selectedoption = sc.nextInt();

        do{

            switch(selectedoption){
                case 1:
                    System.out.println("Enter Task Name ");

                    String taskname = scan();
                    if (taskname!=null && !taskname.isEmpty()){
                        taskService.addTask(new Task(taskname));
                    }

                    break;

                case 2:
                    System.out.println("Enter Task Name to be marked as complete ");
                    String completedtaskname = scan();

                    if (completedtaskname!=null && !completedtaskname.isEmpty()){
                        taskService.completeTask(completedtaskname);
                    }
                    break;

                case 3:
                    System.out.println("Enter Task Name to be deleted ");

                    String deletedtaskname = scan();
                    if (deletedtaskname!=null && !deletedtaskname.isEmpty()){
                        taskService.deleteTask(deletedtaskname);
                    }
                    break;

                case 4:
                    System.out.println("Tasks in your todo list ->");
                    String format = "%-40s%-40s%s%n";
                    tasklist = taskService.getAllTasks();
                    System.out.printf(format,"Taskname","Priority","isCompleted");
                    for(Task task : tasklist){
                        System.out.printf(format,task.getName(),task.getPriority(),task.isCompleted());
                    }

                    break;

                default:
                    System.out.println("Incorrect menu option selected , please enter valid menu option");

            }
            System.out.println("Enter menu option");

            selectedoption = sc.nextInt();

        }
        while(selectedoption!=5);

    }


    public static String scan() {
        Scanner s = new Scanner(System.in);
        String input;
        if (s.hasNextLine()) {
            input = s.nextLine();
        } else {
            input = "ERROR";
        }
        return input;
    }




}
