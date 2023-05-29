package UD03.Boletines.Boletin2.Ej01_Profesor;

import Boletines.Boletin2.Ej01_Profesor.model.Profesor;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        String host = "localhost";
        int port = 6000;

        try (
                Socket clientSocket = new Socket(host, port)
        ) {
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

            int id;

            do {
                System.out.println("Introduzca el ID del profesor a consultar. -1 para salir.");
                id = Integer.parseInt(sc.nextLine());

                dos.writeUTF(Integer.toString(id));

                if (id != -1) {
                    Profesor profesor = (Profesor) ois.readObject();
                    if (profesor.getIdProfesor() > 0) {
                        System.out.println("Recibido:");
                        System.out.println(profesor);
                    } else {
                        System.out.println("No se han encontrador profesores con el id: " + id);
                    }
                }

            } while (id != -1);

            dos.close();
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
