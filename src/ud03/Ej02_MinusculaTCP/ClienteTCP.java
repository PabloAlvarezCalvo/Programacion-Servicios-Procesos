package ud03.Ej02_MinusculaTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;

public class ClienteTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 6000; // Puerto remoto

        try (
                Socket clientSocket = new Socket(host, port);
        ){
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            String line = dis.readUTF();
            System.out.println("Recibido: " + line);
            System.out.println("Enviando: " + line.toLowerCase(Locale.ROOT));
            dos.writeUTF(line.toLowerCase(Locale.ROOT));

            // Cerrar recursos
            dis.close();
            dos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
