package UD03.Boletines.BoletinTCP.Ej02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;

        try(
                Socket clientSocket = new Socket(host, port)
        ){
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            Scanner sc = new Scanner(System.in);

            String line;
            do {
                System.out.println("Introduzca un texto, * para salir:");
                line = sc.nextLine();
                if (!line.equals("*")) {
                    dos.writeUTF(line);
                    System.out.println("Recibido: ");
                    System.out.println(dis.readUTF());
                } else {
                    dos.writeUTF(line);
                }
            } while (!line.equals("*"));

            dis.close();
            dos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
