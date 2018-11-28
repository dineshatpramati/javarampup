package com.imaginea.pomodoroapp.service;

import com.imaginea.pomodoroapp.model.Task;
import com.imaginea.pomodoroapp.repository.TaskRepository;

import java.util.List;

public class TaskServiceImpl implements TaskService {


    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(Task task) {

        taskRepository.addTask(task);

    }

    @Override
    public void deleteTask(String taskName) {

        taskRepository.deleteTask(taskName);
    }

    @Override
    public void completeTask(String taskName) {

        taskRepository.completeTask(taskName);

    }

    @Override
    public void setTaskPriority(String taskName) {

        taskRepository.setTaskPriority(taskName);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

}
