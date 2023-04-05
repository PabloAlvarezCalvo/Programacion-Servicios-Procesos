package ud02.Ejercicios.Ej08_Saldo;

public class MainSaldo {
    public static void main(String[] args) {
        /**
         * Crea una clase Saldo, con un atributo que indique el saldo, y el constructor en el que se dará un valor inicial
         * al saldo. Contendrá también varios métodos:
         * * Uno para obtener el saldo (incluir sleep)
         * * Otro para modificarlo (incluir sleep)
         * * Otro que realice un ingreso. Recibe una cantidad y se la añade, informando por pantalla de quién ha realizado
         * ese ingreso y la cantidad resultante después del ingreso.
         *
         * Crear otra clase Thread, que realice ingresos de saldo desde el run.
         *
         * En el main, crear un objeto compartido Saldo por todos los hilos. Crear 3 hilos, cada uno con un nombre. Esperar
         * a la finalización de todos los hilos para mostrar el valor final del saldo.
         *
         * */
        Saldo saldo = new Saldo(1000);

        Thread hilo1 = new ThreadIngreso("Hilo1", saldo);
        Thread hilo2 = new ThreadIngreso("Hilo2", saldo);
        Thread hilo3 = new ThreadIngreso("Hilo3", saldo);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("El saldo final es: " + saldo.getSaldo());

    }
}
