package com.imaginea.pomodoroapp.service;

import com.imaginea.pomodoroapp.model.Task;

import java.util.List;

public interface TaskService {

    public void addTask(Task task);

    public void deleteTask(String taskName);

    public void completeTask(String taskName);

    public void setTaskPriority(String taskName);

    public List<Task> getAllTasks();




}
