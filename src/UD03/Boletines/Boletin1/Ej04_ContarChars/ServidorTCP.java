package UD03.Boletines.Boletin1.Ej04_ContarChars;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    /* Usando Sockets TCP realiza un programa cliente que introduzca cadenas por teclado hasta introducir un asterisco.
     * Las cadenas se enviarán a un programa servidor.
     * El programa servidor aceptará la conexión de un único cliente y por cada cadena recibida
     * le devolverá al cliente el número de caracteres de la misma.
     * El programa servidor finalizará cuando reciba un asterisco como cadena.
     */

    public static void main(String[] args) {
        int port = 6000;

        try(
                ServerSocket serverSocket = new ServerSocket(port)
        ){
            System.out.println("Esperando conexión...");
            Socket clientSocket = serverSocket.accept();

            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            String line;
            do {
                line = dis.readUTF();

                if (!line.equals("*")) {
                    System.out.println("Recibido: " + line);
                    dos.writeUTF(Integer.toString(line.length()));
                }

            } while(!line.equals("*"));

            dos.close();
            dis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
