package ud03.Ej01_SocketsTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    /*
     * Realiza un programa servidor TCP que acepte 3 clientes.
     * Para cada cliente, mostrar sus puertos local y remoto.
     * Se deberá implementar también el programa cliente que se conecte a dicho servidor.
     * Mostrar los puertos locales y remotos a los que está conectado su socket,
     * y la dirección IP de la máquina remota a la que se conecta.
     */
    public static void main(String[] args) throws IOException {

        int port = 6000;// Puerto
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Escuchando en " + serverSocket.getLocalPort());

        System.out.println("Esperando primer cliente");
        socketInfo(serverSocket.accept());

        System.out.println("Esperando segundo cliente");
        socketInfo(serverSocket.accept());

        System.out.println("Esperando tercer cliente");
        socketInfo(serverSocket.accept());

        serverSocket.close();	// Cierro socket servidor
    }

    private static void socketInfo(Socket client){
        System.out.println("Puerto del cliente: " + client.getPort());
        System.out.println("Puerto local para el cliente: " + client.getLocalPort());
        System.out.println("---------------------------");
    }
}
