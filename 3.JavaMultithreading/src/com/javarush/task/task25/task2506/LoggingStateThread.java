package com.javarush.task.task25.task2506;

/**
 * Created by Admin on 19.09.2017.
 */
public class LoggingStateThread extends Thread {
    Thread thread;
    State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        state = this.thread.getState();
    }

    @Override
    public void run() {
        System.out.println(state);
        while (true) {
            State tmpstate = thread.getState();
            if (state != tmpstate) {
                state = tmpstate;
                System.out.println(state);
                if (state == State.TERMINATED) return;
            }
        }

    }
}
