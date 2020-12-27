package com.company;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    private int port;

    private String directory;

    public Main(int port, String directory) {
        this.port = port;
        this.directory = directory;
    }

    void start() {
        try (var server = new ServerSocket(this.port)) {
            while (true) {
                var socket = server.accept();
                var thread = new Handler(socket, this.directory);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var port = Integer.parseInt(args[0]);
        var directory = args[1];
        new Main(port, directory).start();
    }
}
