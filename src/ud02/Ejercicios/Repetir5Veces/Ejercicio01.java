package ud02.Ejercicios.Repetir5Veces;

class HiloRepetir5Veces extends Thread{
    public HiloRepetir5Veces(String nombre){
        super(nombre);
    }

    public void run(){
        for (int i = 0; i < 5; i++){
            System.out.println(getName() + ": iteracion " + i);
        }
    }
}

public class Ejercicio01   {
    public static void main(String[] args) {
        HiloRepetir5Veces hilo1 = new HiloRepetir5Veces("Hilo 1");
        hilo1.start();

        HiloRepetir5Veces hilo2 = new HiloRepetir5Veces("Hilo 2");
        hilo2.start();

        HiloRepetir5Veces hilo3 = new HiloRepetir5Veces("Hilo 3");
        hilo3.start();
    }
}
