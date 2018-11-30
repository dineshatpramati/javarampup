package com.imaginea.pomodoroapp.client;

import com.imaginea.pomodoroapp.model.Task;
import com.imaginea.pomodoroapp.service.PomodoroTimer;
import com.imaginea.pomodoroapp.service.PomodoroTimerImpl;
import com.imaginea.pomodoroapp.service.TaskService;
import com.imaginea.pomodoroapp.service.TaskServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class PomodoroConsoleClient {

    public void startClient(){

        List<Task> tasklist = new ArrayList<>();


        TaskService taskService = TaskServiceFactory.getTaskServiceInstance();

        PomodoroTimer pomodoro = new PomodoroTimerImpl(new Timer());

        Scanner sc = new Scanner(System.in);

        displayMenu();

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

                case 5:
                    pomodoro.startTimer(5);
                    break;

                case 6:
                    pomodoro.stopTimer();
                    break;

                default:
                    System.out.println("Incorrect menu option selected , please enter valid menu option");

            }
            System.out.println("Enter menu option");

            selectedoption = sc.nextInt();

        }
        while(selectedoption!=7);

    }


    public void displayMenu(){


        System.out.println("Enter option from menu below to do operations ->");
        System.out.println("1.Add new task in todo list ");
        System.out.println("2.Mark existing task as completed ");
        System.out.println("3.Delete an existing task from todo list");
        System.out.println("4.View all tasks ");
        System.out.println("5.Start Pomodoro Timer ");
        System.out.println("6.Stop Pomodoro Timer ");

        System.out.println("7.Exit");



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
