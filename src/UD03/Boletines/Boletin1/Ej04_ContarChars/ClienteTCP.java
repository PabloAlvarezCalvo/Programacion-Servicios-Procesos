package UD03.Boletines.Boletin1.Ej04_ContarChars;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String host = "localhost";
        int port = 6000;

        try(
                Socket clientSocket = new Socket(host, port);
        ){
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            String line;
            do {
                System.out.println("Introduzca una cadena de texto. * para salir:");
                line = sc.nextLine();

                dos.writeUTF(line);

                if (!line.equals("*")) {
                    System.out.println("Enviando: " + line);
                    System.out.println("Recibido:" + dis.readUTF());
                }

            } while (!line.equals("*"));

            dos.close();
            dis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
