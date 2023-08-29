package ud03.Ejercicios.Ej_Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServidorChat {
    private static final int MAX_CONNECTIONS = 10;
    public static ServerSocket server;
    private static final int PORT = 12345;
    public static int connections = 0;
    public static int currentConnections = 0;
    public static Socket[] sockets = new Socket[MAX_CONNECTIONS];
    public static void main(String[] args) throws IOException {
        server = new ServerSocket(PORT);


        while (connections < MAX_CONNECTIONS){
            Socket s = new Socket();

            try{
                s = server.accept();
                sockets[connections] = s;
                connections++;
                currentConnections++;

                ServerThread thread = new ServerThread(s);
                thread.start();


            } catch (SocketException e) {
                break;
            }
        }
    }
}
