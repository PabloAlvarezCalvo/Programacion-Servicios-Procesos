package ud02.Ejercicios.Ej09_Factorial;

public class MainFactorial {
    public static void main(String[] args) {
        /**
         * Hacer un programa que calcule el factorial. Cada uno de los cálculos tiene que ser realizado por un hilo
         * independiente. Implementar los procesos de 2 maneras diferentes:
         *        a) Heredando de la clase Thread
         *        b) Implementando la interface Runnable
         * */

        Thread hiloFactorial = new ThreadFactorial("Hilo factorial", 3);
        Thread runnableFactorial = new Thread(new RunnableFactorial(4));

        hiloFactorial.start();
        runnableFactorial.start();
    }
}
