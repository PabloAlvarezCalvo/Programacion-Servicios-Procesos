package ud03.Ej03_CuadradoNumeroTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        try {
            //Abrir socket
            cliente = new Socket(host, puerto);
            InetAddress i = cliente.getInetAddress();
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());

            double cuadrado = Math.pow(Integer.parseInt(dis.readUTF()), 2);
            dos.writeUTF(Double.toString(cuadrado));

            //Cerrar recursos
            dis.close();
            dos.close();
            cliente.close(); //Cierra el socket

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
