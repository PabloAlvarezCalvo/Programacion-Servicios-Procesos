package ud02.Ejercicios.Ej03_YesNo;

class HiloYesNo extends Thread {
    public HiloYesNo(String nombre){
        super(nombre);
    }

    public void run(){
        for (int i = 0; i < 30; i++){
            System.out.println(getName());
        }
    }
}

public class Ej03_YesNo {
    public static void main(String[] args) {
        /* Crear un programa con dos hilos que muestren varias veces un mensaje.
         * Ver que no siguen ningún tipo de orden.
         */
        Thread hiloA = new HiloYesNo("NO");

        Thread hiloB = new HiloYesNo("YES");

        System.out.println("Ejecucion en HiloA");
        hiloA.start();

        System.out.println("Ejecucion en HiloB");
        hiloB.start();

        System.out.println("Ejecucion en Main");
    }
}