package UD03.Boletines.Boletin2.Ej06_ServidorTCPThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "localhost";
        int clientPort = 12345;

        try (
                Socket clientSocket = new Socket(InetAddress.getByName(host), clientPort);
        ) {
            String line;
            do {
                System.out.println("Introduzca una cadena de texto. * para salir:");
                line = sc.nextLine();

                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                dos.writeUTF(line);

                if (!line.equals("*")) {
                    System.out.println("Enviado: " + line);

                    DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                    System.out.println("Recibido: " + dis.readUTF());
                } else {

                }

            } while (!line.equals("*"));

            System.out.println("Conexión finalizada.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
