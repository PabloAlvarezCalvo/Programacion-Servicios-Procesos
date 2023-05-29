package UD03.Boletines.Boletin2.Ej06_ServidorTCPThread.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ThreadServidor extends Thread {
    private Socket clientSocket;

    public ThreadServidor(Socket clientSocket) {
        this.clientSocket = clientSocket;

        InetAddress clientAddress = clientSocket.getInetAddress();
        System.out.println("\n----------------------------------------");
        System.out.println("Dirección cliente: " + clientAddress);
        System.out.println("Puerto cliente: " + clientSocket.getPort());
        System.out.println("Puerto servidor: " + clientSocket.getLocalPort());
    }

    public void run(){

        try {
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            String line;
            do {
                line = dis.readUTF();

                if (!line.equals("*")){
                    System.out.println("Recibido: " + line);
                    DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

                    System.out.println("Enviado: " + line.toUpperCase());
                    dos.writeUTF(line.toUpperCase());
                }
            } while (!line.equals("*"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin de ejecución de hilo");

    }
}
