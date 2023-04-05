package ud02.Ejercicios.Ej10_Factorial2;

public class MainFactorial2 {
    public static void main(String[] args) {
        /*
         * Hacer un programa que calcule los factoriales del 5 al 14 modificando la clase Factorial del ejercicio anterior,
         * para que se visualicen los mensajes:
         * empieza el proceso … cálculo del factorial de: XX
         * acabó el proceso ….. el factorial de: XX es XXXX
         * en el método main declarar un vector o array de 10 hilos y lanzarlos a ejecución.
         * */

        System.out.println("Con Thread.");
        Thread[] hilosFactorial = new Thread[9];
        for (int i = 0; i < hilosFactorial.length; i++){
            hilosFactorial[i] = new ThreadFactorial("Hilo " + i, i + 9);
        }

        for (Thread t : hilosFactorial){
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Con Runnable.");
        Thread[] runnablesFactorial = new Thread[9];
        for (int i = 0; i < runnablesFactorial.length; i++){
            runnablesFactorial[i] = new Thread(new RunnableFactorial(i + 9));
        }

        for (Thread t : runnablesFactorial){
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
