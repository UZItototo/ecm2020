package com.ecm.service;

import java.net.Socket;

public class EventHandler implements Runnable{

    private Socket socket;

    public EventHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "<>" + socket);
    }
}
