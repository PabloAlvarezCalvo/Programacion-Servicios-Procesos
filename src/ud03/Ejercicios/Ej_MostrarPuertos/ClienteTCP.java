package ud03.Ejercicios.Ej_MostrarPuertos;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        String Host = "localhost";
        int Puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        try {
            //ABRIR SOCKET
            cliente = new Socket(Host, Puerto);
            InetAddress i = cliente.getInetAddress();
            System.out.println("[Cliente] conectado");
            System.out.println("[Cliente] Puerto local: " + cliente.getLocalPort());
            System.out.println("[Cliente] Puerto Remoto: " + cliente.getPort());
            System.out.println("[Cliente] Host Remoto: " + i.getHostName());
            System.out.println("Cliente] IP Host Remoto: " + i.getHostAddress());
            cliente.close(); //Cierra el socket

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
