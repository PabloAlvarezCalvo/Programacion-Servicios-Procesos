package ud02.Ejercicios.Ej13_ProductorConsumidor;

public class MainProductorConsumidor {
    public static void main(String[] args) {
        /**
         * Implementar una aplicación compuesta por 3 clases:
         * Una Cola, que será el objeto compartido.
         * Un productor y un consumidor.
         * El productor generará 10 números, y los insertará en el objeto Cola, tras hacer un pequeño sleep.
         * El consumidor los leerá, y los mostrará por pantalla.
         *
         * */
        Cola cola = new Cola();
        Thread productor = new Productor("Productor", cola);
        Thread consumidor = new Consumidor("Consumidor", cola);

        productor.start();
        consumidor.start();
    }
}
