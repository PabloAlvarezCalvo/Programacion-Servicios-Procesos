package ud02.Ejercicios.Ej05_RangosHilos;

class Hilo extends Thread {
    private final int inicio, fin;
    public Hilo (String name, int inicio, int fin){
        super(name);
        this.inicio = Integer.min(inicio, fin);
        this.fin = Integer.max(inicio, fin);
    }

    public void run(){
        for (int i = inicio; i <= fin; i++){
            System.out.println(getName() + ": " + i);
        }
        System.out.println("Ejecución hilo " + getName() + " finalizada.");
    }
}
public class MainRangosHilos {
    public static void main(String[] args) {
        /*Diseña un programa que escriba dos sucesiones ascendentes de números de forma
            simultánea. Es decir, un programa con dos hilos en ejecución concurrente.
            El hilo tendrá:
            • 2 atributos de tipo entero que marcarán el comienzo y fin de la secuencia que queremos
            que se muestre (por ejemplo, desde el 18 hasta el 45), una cadena para el nombre del
            hilo.
            • El constructor, al que se le pasarán el comienzo y fin de la secuencia y el nombre del
            hilo. Es decir, cuando se instancia un objeto hilo se le pasarán el intervalo de valores a
            mostrar y como se llamará.
            • El método run(), mostrará el nombre del hilo indicando que comienza, luego la
            secuencia de valores y cuando haya finalizado indicará que terminó.
            En el main:
            • crear dos objetos de tu hilo, pasándoles el inicio, fin y nombre del hilo. Por ejemplo:
            ◦ Un ThreadA que comenzará en 1 y terminará en 10
            ◦ Un ThreadB que empezará en 20 y terminará en 30
            • Un mensaje indicando que “Vamos a iniciar los dos threads”
            • Un mensaje indicando que los hilos se han inicializado
            • Lanzas los dos hilos
            • Y un mensaje de que el programa principal ha terminado.
            Ejecuta varias veces tu aplicación para ver que obtienes diferentes salidas dependiendo de los
            tiempos que asigne la CPU a cada hilo.
         */
        Thread threadA = new Hilo("ThreadA", 1, 10);
        Thread threadB = new Hilo("ThreadB", 20, 30);

        System.out.println("Hilos creados.");

        threadA.start();
        threadB.start();

        System.out.printf("Hilos lanzados.");

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Programa principal terminado.");
    }
}
