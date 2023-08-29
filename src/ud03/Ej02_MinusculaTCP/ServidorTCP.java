package ud03.Ej02_MinusculaTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    /*
     */

    public static void main(String[] args) {
        int port = 6000;// Puerto

        try (
                ServerSocket serverSocket = new ServerSocket(port)
        ){
            System.out.println("[Servidor] Escuchando en " + serverSocket.getLocalPort());
            Socket clientSocket = serverSocket.accept(); // esperando a un cliente

            // Realizar acciones con cliente
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            String message = "MENSAJE MAYÚSCULAS";
            System.out.println("Enviando: " + message);
            dos.writeUTF(message);

            System.out.println("Recibido => " + dis.readUTF());

            // Cerrar recursos
            dis.close();
            dos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
