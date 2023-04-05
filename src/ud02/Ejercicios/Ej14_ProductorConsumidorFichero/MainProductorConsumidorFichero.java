package ud02.Ejercicios.Ej14_ProductorConsumidorFichero;

import java.io.File;

public class MainProductorConsumidorFichero {
    public static void main(String[] args) {
        /**
         * Usando el modelo productor-consumidor, crea un productor que lea caracteres de un fichero de texto cuyo nombre
         * recibirá a través de su constructor.
         * El consumidor obtendrá los datos que produzca el productor y los mostrará por pantalla.
         * Muestra al final del proceso del productor y del consumidor un mensaje indicando que el proceso ha finalizado.
         * */

        Cola cola = new Cola();

        File file = new File(".\\src\\ud02\\Ejercicios\\Ej14_ProductorConsumidorFichero\\entrada.txt");

        Thread productor = new Productor("Productor", cola, file);
        Thread consumidor = new Consumidor("Consumidor 1", cola);

        productor.start();
        consumidor.start();
    }
}
