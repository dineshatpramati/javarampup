package com.imaginea.pomodoroapp.repository;

import com.imaginea.pomodoroapp.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements  TaskRepository {


    private List<Task> tasks = new ArrayList<>();


    @Override
    public void addTask(Task task) {
        this.tasks.add(task);
        System.out.println("Task "+task.getName()+"  has been added to your ToDo List ");
    }

    @Override
    public void deleteTask(String taskName) {

        boolean istaskexisting = false;

        if(this.tasks.removeIf(t->t.getName().equals(taskName))){
            istaskexisting=true;
            System.out.println("Task "+taskName+ "  deleted successfully from list");
        }

        if(!istaskexisting){
            System.out.println("Task not found ");
        }


    }

    @Override
    public void completeTask(String taskName) {

        boolean istaskexisting = false;

        for(Task t:this.tasks){

            if(t.getName().equals(taskName)){
                t.setCompleted(true);
                System.out.println("Task "+taskName+ " has been marked as completed !");
                istaskexisting = true;
            }

        }
        if(!istaskexisting){
            System.out.println("Task not found ");
        }


    }

    @Override
    public void setTaskPriority(String taskName) {

    }

    @Override
    public List<Task> getAllTasks() {
        return this.tasks;
    }
}
