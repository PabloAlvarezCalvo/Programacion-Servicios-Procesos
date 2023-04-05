package ud02.Ejercicios.Ej11_ContarApp;

public class ContarApp {
    public static void main(String[] args) {
        /**
         * Escribe un programa que conste de las dos clases que se describen a continuación:
         * Una de las clases, de nombre ContarThread, que se va a ejecutar en paralelo, tiene :
         *     • un atributo entero de carácter privado de nombre maxContar
         *     • un constructor que recibe un entero y lo asigna al atributo maxContar
         *
         * Esta clase repite un número de veces igual a maxContar lo siguiente:
         *     • muestra en que repetición va  “Repeticion: xx”
         *     • muestra el nombre del Thread
         *     • ejecuta el método sleep durante 2000 milisegundos
         * La clase ContarApp tiene el método main, que hará lo siguiente:
         *     • crea un objeto de la clase ContarThread y ordénale que se ejecute
         *     • Detén el método 3000 milisegundos.
         *     • Crea otro objeto de la clase ContarThread y ordénale que se ejecute
         *     • mientras no hayan terminado los dos hilos anteriores muestra por  pantalla “Sigo contando…”
         *     y ejecuta sleep pasándole 1000 como parámetro sucesivamente hasta que deje de cumplirse la
         *     condición.
         * */
        Thread contarThread1 = new ContarThread("Hilo 1", 5);
        contarThread1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread contarThread2 = new ContarThread("Hilo 2", 5);
        contarThread2.start();

        while (contarThread1.isAlive() || contarThread2.isAlive()){
            System.out.println("Sigo contando...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
