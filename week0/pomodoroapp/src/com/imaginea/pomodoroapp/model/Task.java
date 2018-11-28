package com.imaginea.pomodoroapp.model;

import java.util.Date;

public class Task {


    private String name;
    private int priority;
    private Date taskdate;



    private boolean completed;

    private static final String DEFAULT_TASKNAME = "Default Task";

    private static final int DEFAULT_PRIORITY = 1;


    public Task(String name) {
        this(name,DEFAULT_PRIORITY,new Date(),false);
    }

    public Task(String name, int priority, Date taskdate, boolean completed) {
        this.name = name;
        this.priority = priority;
        this.taskdate = taskdate;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(Date taskdate) {
        this.taskdate = taskdate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }














}
