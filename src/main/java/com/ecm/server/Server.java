package com.ecm.server;

import com.ecm.service.EventHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangshi
 *
 * @date 20200904
 *
 */
public class Server {
    /**
     * init server
     * 1. init threadPool
     * 2. create ServerSocket
     */
    static void init() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8021);
        ExecutorService pool = Executors.newFixedThreadPool(200);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new EventHandler(socket));
        }
    }

    public static void main(String[] args) {
        try {
            init();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
