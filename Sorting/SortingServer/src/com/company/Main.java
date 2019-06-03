package com.company;

import java.io.IOException;

public class Main {
    public static final int PORT = 27001;

    public static void main(String[] args) {
        ChatServer server = new ChatServer(PORT);
        try {
            server.run();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
