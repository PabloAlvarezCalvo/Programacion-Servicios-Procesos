package ud02.Ejercicios.Ej06_ContadorSincro;

class HiloInc extends Thread {
    private Contador contador;
    public HiloInc(String name, Contador contador){
        super(name);
        this.contador = contador;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            contador.incrementar();
            System.out.println(getName() + ": " + contador.getContador());
        }
    }
}

class HiloDec extends Thread {
    private Contador contador;
    public HiloDec(String name, Contador contador){
        super(name);
        this.contador = contador;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            contador.decrementar();
            System.out.println(getName() + ": " + contador.getContador());
        }
    }
}

public class MainContadorSincro {
    public static void main(String[] args) {
        /*
         *
         * Implementa una clase contador, con un atributo entero y 3 métodos
         * (incrementa, decrementa, y getValor)
         *
         * Definir 2 tipos de hilo (hiloInc, hiloDec), uno para decrementar
         * y otro para incrementar dicho contador (ejecutarán un bucle de X
         * iteraciones, en las que se modifique el valor del contador según
         * corresponda, y a continuación un Thread.sleep), que cuenten con un
         * atributo interno de tipo Contador.
         *
         * En el main, crear 2 hilos, uno de cada clase, que trabajen sobre un
         * mismo objeto Contador.
         *
         */

        Contador contador = new Contador(0);

        Thread hiloInc = new HiloInc("Hilo inc", contador);
        Thread hiloDec = new HiloDec("Hilo dec", contador);

        hiloInc.start();
        hiloDec.start();

    }
}
