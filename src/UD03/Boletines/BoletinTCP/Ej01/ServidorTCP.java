package UD03.Boletines.BoletinTCP.Ej01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    /*
     * Crea un programa servidor que pueda atender hasta 3 clientes. Debe enviar a cada
     * cliente un mensaje indicando el número de cliente que es. Este número será 1, 2 o 3.
     * El cliente mostrará el mensaje recibido.
     * Cambia el programa para que lo haga para N clientes,
     * siendo N un parámetro que tendrás que definir en el programa.
     */

    private final static int MAX_CONNECTIONS = 3;

    public static void main(String[] args) {
        int port = 12345;
        int clientsCount = 0;

        try (
                ServerSocket serverSocket = new ServerSocket(port)
        ){

            do {
                System.out.println("Esperando conexiones...");
                Socket clienteSocket = serverSocket.accept();
                clientsCount++;

                DataOutputStream dos = new DataOutputStream(clienteSocket.getOutputStream());

                System.out.printf("Conectado cliente %d.\n", clientsCount);
                dos.writeUTF("Cliente " + clientsCount);

                dos.close();
                clienteSocket.close();

            } while (clientsCount < MAX_CONNECTIONS);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
