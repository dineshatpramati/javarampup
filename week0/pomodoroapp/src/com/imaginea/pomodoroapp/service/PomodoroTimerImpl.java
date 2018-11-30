package com.imaginea.pomodoroapp.service;

import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimerImpl implements PomodoroTimer {

   private Timer taskTimer;



    public PomodoroTimerImpl(Timer taskTimer) {
        this.taskTimer = taskTimer;

    }

    @Override
    public void startTimer(int minutes) {

        System.out.println("Pomodoro Timer started");
        TimerTask taskone = new TimerTask() {
            Timer breakTimer= new Timer();


            @Override
            public void run() {
                System.out.println("Start work");
                TimerTask tasktwo = new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Take a break");
                        cancel();
                    }
                };

                breakTimer.scheduleAtFixedRate(tasktwo,(minutes-minutes/5)*60*1000,1000);


            }
        };

        this.taskTimer.scheduleAtFixedRate(taskone,0,minutes*60*1000);


    }

    @Override
    public void stopTimer() {
        System.out.println("Pomodoro Timer stopped");
        this.taskTimer.cancel();

    }

    @Override
    public void resetTimer() {
        this.taskTimer.cancel();

    }







}
