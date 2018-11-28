package com.imaginea.pomodoroapp.service;

import com.imaginea.pomodoroapp.repository.TaskRepositoryFactory;

public class TaskServiceFactory {


    public static TaskService getTaskServiceInstance(){

        return new TaskServiceImpl(TaskRepositoryFactory.getTaskRepositoryInstance());
    }
}
