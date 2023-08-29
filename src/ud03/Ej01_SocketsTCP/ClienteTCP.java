package ud03.Ej01_SocketsTCP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 6000; // remote port

        Socket clientSocket = new Socket(host, port); // Establece conexión

        InetAddress i = clientSocket.getInetAddress ();
        System.out.println ("Puerto local: " + clientSocket.getLocalPort());
        System.out.println ("Puerto Remoto: " + clientSocket.getPort());
        System.out.println ("Nombre Host/IP: " + clientSocket.getInetAddress());
        System.out.println ("Host Remoto: " + i.getHostName());
        System.out.println ("IP Host Remoto: " + i.getHostAddress());

        clientSocket.close(); // Cierra el socket
    }

}
