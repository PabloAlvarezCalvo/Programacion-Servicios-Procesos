package UD03.Boletines.BoletinTCP.Ej01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try (
                Socket clientSocket = new Socket(host, port)
        ){
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            System.out.println("Conexión establecida.");
            System.out.println(dis.readUTF());

            dis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
