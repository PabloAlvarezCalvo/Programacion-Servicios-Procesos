package UD03.Examen.Ej01.threads;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadServidor extends Thread {
    private Socket clientSocket;

    public ThreadServidor(Socket clientSocket) {
        super();
        this.clientSocket = clientSocket;
    }


    public void run() {

        System.out.println("Conectado con cliente. Dir: " + clientSocket.getInetAddress() + ", puerto: " + clientSocket.getPort());

        try (
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())
        ){
            String line;

            do {
                line = dis.readUTF().trim();

                if (!line.equalsIgnoreCase("FIN")) {

                    if (line.charAt(0) == '¿' && line.charAt(line.length() - 1) == '?') {

                        // Entonces es pregunta
                        switch (line) {
                            case "¿Cómo te llamas?" -> {
                                dos.writeUTF("Me llamo Servidor del Ejercicio 1.");
                            }

                            case "¿Cuántas líneas de código tienes?" -> {
                                dos.writeUTF("Tengo 82 líneas de código.");
                            }

                            default -> {
                                // No he entendido la pregunta
                                dos.writeUTF("Lo siento, no he entendido la pregunta.");
                            }
                        }
                    } else {
                        dos.writeUTF("Lo siento, no he recibido una pregunta.");
                    }

                }
            } while (!line.equals("FIN"));

            System.out.println("Finalizada comunicación con el cliente.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}