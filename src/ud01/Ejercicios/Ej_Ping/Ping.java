package ud01.Ejercicios.Ej_Ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ping {
    public static void main(String[] args) throws IOException {
        Scanner sc1 = new Scanner(System.in);

        try {

            List<String> listaIP = new ArrayList<>();
            String in;

            System.out.println("Escriba una IP o fin para terminar:");
            while (!(in = sc1.nextLine()).equals("fin")){
                listaIP.add(in);
                System.out.println("Escriba una IP o fin para terminar:");
            }

            ProcessBuilder builder = new ProcessBuilder();

            Process p;
            for (String s : listaIP) {
                builder.command("cmd.exe", "/c", "ping", s);
                p = builder.start();
                builder.redirectErrorStream(true);
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line;
                while ((line = r.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (Exception e) {

        }
    }
}
