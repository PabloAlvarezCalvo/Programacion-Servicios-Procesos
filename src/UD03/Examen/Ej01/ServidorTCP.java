package UD03.Examen.Ej01;

import Ej01.threads.ThreadServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) {
        int serverPort = 6000;

        try (
                ServerSocket serverSocket = new ServerSocket(serverPort)
        ){
            while(true) {
                System.out.println("Esperando conexión...");
                Socket clientSocket = serverSocket.accept();
                Thread threadServidor = new ThreadServidor(clientSocket);
                threadServidor.start();
            }
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        }

    }
}