package com.imaginea.pomodoroapp.repository;

public class TaskRepositoryFactory {

    public static TaskRepository getTaskRepositoryInstance(){
        return  new TaskRepositoryImpl();
    }

}
