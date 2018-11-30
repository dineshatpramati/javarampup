package com.imaginea.pomodoroapp;

import com.imaginea.pomodoroapp.client.PomodoroConsoleClient;
import com.imaginea.pomodoroapp.service.PomodoroTimer;

import java.util.Timer;
import java.util.TimerTask;


public class PomodoroApp {

    public static void main(String[] args) {

       PomodoroConsoleClient client = new PomodoroConsoleClient();
       client.startClient();






    }
}

