package org.example.task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8189);    // запускаем сервер на прослушивание порта 8189
            System.out.println("Server start and wait clients...");
            while (true) {
                // Как только клиент подключится, создаем сокет (соединение)
                socket = server.accept();
                System.out.println("Client connected");
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
