package UD03.Boletines.BoletinTCP.Ej02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) {
        int port = 12345;

        try (
                ServerSocket serverSocket = new ServerSocket(port);
        ){

            System.out.println("Esperando conexión...");
            Socket clientSocket = serverSocket.accept();

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            String line;
            do {
                line = dis.readUTF();

                if (!line.equals("*")) {
                    System.out.println("Recibido: " + line);
                    dos.writeUTF("La cadena contiene " + Integer.toString(line.length()) + " caracteres.");
                }
            } while (!line.equals("*"));

            dis.close();
            dos.close();
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
