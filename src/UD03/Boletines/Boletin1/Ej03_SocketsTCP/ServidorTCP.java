package UD03.Boletines.Boletin1.Ej03_SocketsTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    /* Realiza un programa servidor TCP que acepte 2 clientes.
     * Mostrar para cada cliente conectados sus puertos local y remoto.
     * Implementar también el programa cliente, donde se muestren los puertos locales
     * y remotos a los que se encuentre conectado, asi como la IP de la máquina remota a la que se conecta.
     */
    public static void main(String[] args) {

        int port = 6000; // Puerto local
        try(
                ServerSocket serverSocket = new ServerSocket(port)
        ){
            System.out.println("Escuchando en " + serverSocket.getLocalPort());

            System.out.println("Esperando primer cliente...");
            Socket clientSocket1 = serverSocket.accept();
            System.out.println("Primer cliente atendido");
            showInfo(clientSocket1);

            System.out.println("Esperando segundo cliente...");
            Socket clientSocket2 = serverSocket.accept();
            System.out.println("Segundo cliente atendido");
            showInfo(clientSocket2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showInfo(Socket client){
        System.out.println("Puerto del cliente: " + client.getPort());
        System.out.println("Cliente conectado al puerto: " + client.getLocalPort());
    }
}
