package com.example.demo;

import java.util.concurrent.atomic.AtomicReference;

public class Worker implements Runnable {

    volatile int taskNumber = 1;
    public void run() {
        try {
            while(taskNumber <= 10) {
                synchronized(this) {
                    if(taskNumber !=  Integer.parseInt(Thread.currentThread().getName())) {
                        this.notifyAll();
                        this.wait();
                    }
                    if(taskNumber == Integer.parseInt(Thread.currentThread().getName())) {
                        if(Integer.parseInt(Thread.currentThread().getName()) % 2 == 0){
                            System.out.println("Consumer " + taskNumber++);
                        } else {
                            System.out.println("Producer " + taskNumber++);
                        }
                        this.notifyAll();
                    }
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
    public static void main(String args[]) {
        Worker worker = new Worker();
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(worker, i + "");
            thread.start();
        }
    }
}

