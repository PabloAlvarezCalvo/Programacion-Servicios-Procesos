package UD03.Boletines.Boletin2.Ej03_NumerosUDP;

import Boletines.Boletin2.Ej03_NumerosUDP.model.Numero;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
    /*
     * Crea un programa cliente que introduzca por teclado un número e inicialice un objeto Numeros,
     * el atributo numero debe contener el número introducido por teclado.
     * Debe enviar ese objeto al programa servidor.
     * El proceso se repetirá mientras el número introducido por teclado sea mayor que 0.
     *
     * Crea un programa servidor que reciba un objeto Numeros.
     * Debe calcular el cuadrado y el cubo del atributo numero y debe enviar el objeto
     * al cliente con los cálculos realizados, el cuadrado y el cubo en sus atributos respectivos.
     * El cliente recibirá el objeto y visualizará el cuadrado y el cubo del número introducido por teclado.
     * El programa servidor finalizará cuando el número recibido en el objeto Numeros sea menor o igual que 0.
     * Controlar posibles errores, por ejemplo si ejecutamos el cliente y el servidor no está iniciado,
     * o si estando el servidor ejecutándose ocurre algún error en el cliente, o este finaliza inesperadamente, etc
     */
    public static void main(String[] args) {
        int port = 6000;

        try (
                DatagramSocket serverSocket = new DatagramSocket(port)
        ){
            Numero number;
            do {
                byte[] incomingBuffer = new byte[1024];
                DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
                serverSocket.receive(incomingPacket);

                ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
                ObjectInputStream ois = new ObjectInputStream(bis);

                number = (Numero) ois.readObject();

                if (number.getNumero() > 0) {
                    int baseNumber = number.getNumero();
                    long square = (long) Math.pow(baseNumber, 2);
                    long cube = (long) Math.pow(baseNumber, 3);
                    number = new Numero(baseNumber, square, cube);

                    System.out.println("Recibido: " + baseNumber);

                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(number);

                    byte[] outgoingBuffer = bos.toByteArray();

                    DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, incomingPacket.getAddress(), incomingPacket.getPort());

                    serverSocket.send(outgoingPacket);

                    oos.close();
                    bos.close();
                }

            }  while (number.getNumero() > 0);






        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
