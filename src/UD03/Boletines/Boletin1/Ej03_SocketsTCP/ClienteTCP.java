package UD03.Boletines.Boletin1.Ej03_SocketsTCP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 6000; // Puerto remoto

        try(
                Socket clientSocket = new Socket(host, port) // Try with resources autocloses
        ){
            InetAddress i = clientSocket.getInetAddress ();
            System.out.println ("Puerto local: " + clientSocket.getLocalPort());
            System.out.println ("Puerto Remoto: " + clientSocket.getPort());
            System.out.println ("Nombre Host/IP: " + clientSocket.getInetAddress());
            System.out.println ("Host Remoto: " + i.getHostName());
            System.out.println ("IP Host Remoto: " + i.getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
