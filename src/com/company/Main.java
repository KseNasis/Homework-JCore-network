package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Запускаем сервер");
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("Новое соединение принято");
            final String name = in.readLine();
            out.println(String.format("Привет %s, твой порт  %d", name, clientSocket.getPort()));

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
