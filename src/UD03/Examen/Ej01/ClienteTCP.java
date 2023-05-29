package UD03.Examen.Ej01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "localhost";
        int serverPort = 6000;

        try (
                Socket socket = new Socket(host, serverPort)
        ) {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String line;
            do {
                System.out.println("Introduce una pregunta para el servidor. FIN para salir:");
                line = sc.nextLine().trim();

                dos.writeUTF(line);

                if (!line.equals("FIN")) {
                    System.out.println("Recibido:");
                    System.out.println(dis.readUTF().trim());
                }

            } while (!line.equals("FIN"));

            System.out.println("Fin ejecución cliente.");

            // Liberar recursos
            dis.close();
            dos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
