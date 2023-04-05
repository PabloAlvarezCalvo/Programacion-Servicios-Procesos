package ud02.Ejercicios.Ej04_ContadorHilos;

class Hilo extends Thread {
    private static int contador = 0;
    private String cadena;

    public Hilo(){

    }

    public Hilo(String cadena){
        super();
        this.cadena = cadena;
    }

    public void run(){
        for (int i = 0; i < 10; i++){
            System.out.println(contador++ + ": " + cadena);
        }
    }
}

public class Ej04_ContadorHilos {
    public static void main(String[] args) {
        /** Crea una subclase Thread la cual tendrá un atributo de clase 1que es una variable entera
         (contador) que se inicializa a 0 y un atributo de objeto2 que es una cadena; como métodos: se
         redefine su constructor pasándole un string como argumento, se llama al constructor de la
         superclase, se le asigna al atributo de objeto como valor el del string pasado como
         argumento.
         El método run() mostrará hasta un máximo de 10 veces el valor de contador incrementado y
         luego el valor del atributo de objeto (el string).
         En el programa principal (main)  creas 2 objetos de tu subclase Thread (2 hilos) cada uno
         con un valor, por ejemplo, el hilo1 con SI y el hilo2 con NO.
         Los hilos deberán pertenecer a un grupo denominado "Grupo PSP".
         Ejecutas ambos hilos y comprueba que el contador no funcionó lo bien que debía ya
         que no se ha incrementado secuencialmente (como sí tenía que hacerlo)
         */
        ThreadGroup grupoHilos = new ThreadGroup("Grupo PSP");
        Thread hiloYes = new Hilo("Yes");
        Thread hiloNo = new Hilo("No");


        Thread h1 = new Thread(grupoHilos, hiloYes, "Hilo 1");
        Thread h2 = new Thread(grupoHilos, hiloNo, "Hilo 2");

        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();

            System.out.println("Hay " + grupoHilos.activeCount() + " hilos activos.");

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }
}
