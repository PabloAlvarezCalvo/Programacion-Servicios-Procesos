package ud03.Ej04_MayusculasUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) throws IOException  {
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345; //puerto remoto al que envío
        byte[] mensaje;
        DatagramPacket envio;
        DatagramPacket recibo;
        DatagramSocket socket = new DatagramSocket();

        socket.setSoTimeout(5000);

        try {

            String cadena;
            do {
                System.out.println("Introduzca una cadena para enviar mediante UDP:");
                cadena = new Scanner(System.in).nextLine();
                mensaje = cadena.getBytes();

                //Construyo el datagrama a enviar
                envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
                DatagramSocket socketSend = new DatagramSocket(34567); //Local port
                socketSend.send(envio);

                // recibo cadena del servidor
                byte[] buffer = new byte[1024];
                recibo = new DatagramPacket(buffer, buffer.length);

                socket.receive(recibo);

                String cadenaRecibida = new String(recibo.getData());

                System.out.println("Recibido: " + cadenaRecibida);

            } while (!cadena.equals("*"));

            //Cerrar recursos
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
