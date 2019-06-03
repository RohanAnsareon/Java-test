package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;


public class ChatServer {
    public int port;
    public LinkedList<MyServer> servers = new LinkedList<>();
    public ServerSocket server;

    public ChatServer(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(port);
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    this.servers.add(new MyServer(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }

//****************************Server*Class********************************************

    class MyServer extends Thread {
        public Socket socket;
        public BufferedReader reader;
        public BufferedWriter writer;

        public MyServer(Socket socket) throws IOException {
            this.socket = socket;
            this.reader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            start();
        }

        @Override
        public void run() {
            String word;
            try {
                while (true) {
                    word = reader.readLine();
                    if (word.equals("stop")) {
                        break;
                    }
                    for (MyServer vr : servers) {
                        if (vr.socket != this.socket) {
                            vr.send(word);
                        }
                    }
                }
            } catch (IOException e) { }
        }

        private void send(String msg) {
            try {
                writer.write(msg + "\n");
                writer.flush();
            } catch (IOException ignored) { }
        }
    }
}
