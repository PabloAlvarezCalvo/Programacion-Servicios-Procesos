package ud01.Examen.Ejercicio2;

import java.util.ArrayList;

public class EvaluarArgumentos {
    public static void main(String[] args) {
        //Si no se recibe un argumento devuelve -1
        if (args.length < 1) {
            System.exit(-1);
        }

        ArrayList<String> argumentos = new ArrayList<>();
        ArrayList<Integer> listaEnteros = new ArrayList<>();

        //Objeto arraylist intermedio para operar con él
        for (String s : args) {
            argumentos.add(s);
        }

        //Recorremos los strings, si alguno no es convertible a entero
        //ponemos todoEnteros a false y salimos del bucle
        boolean todoEnteros = true;
        for (String s : argumentos){
            try {
                listaEnteros.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                todoEnteros = false;
                break;
            }
        }

        //Si no son enteros, se muestran los argumentos como cadenas
        if (!todoEnteros) {
            for (int i = 0; i < argumentos.size(); i++) {
                System.out.println("Argumento " + (i+1) + ": " + argumentos.get(i));
            }
            System.exit(1);
        } else {
            //Si son enteros calculamos la media
            double media = 0.0d;
            for (int i : listaEnteros){
                media += i;
            }
            media /= listaEnteros.size();

            //La mostramos por pantalla
            System.out.println("La media es: " + media);

            int contador = 0;

            //Contamos la cantidad de elementos que superan la media
            for (int i : listaEnteros) {
                if (i > media) {
                    contador++;
                }
            }

            //Y si más del 50% superan la media salimos con valor 2
            if (contador > (listaEnteros.size()/2)) {
                System.exit(2);
            } else {
                System.exit(3); //En caso contrario salimos con valor 3
            }
        }
        //En cualquier otro caso, salimos con un 0
        System.exit(0);
    }
}
