package ud02.Ejercicios.Ej16_Cajero;

public class MainCajero {
    public static void main(String[] args) {
        /*
         * CAJERO AUTOMATICO
         * Diseña un programa que simule la gestión de un punto de venta con tres terminales que acceden a un
         * objeto Cajero que mantiene la cuenta de las localidades vendidas.
         * Clase Cajero → es el recurso compartido por los terminales (sección crítica)
         *  Un atributo localidades que contiene la cuenta de las localidades vendidas
         *  un método sumarLocalidades que irá contando las localidades vendidas
         *  un método mostrarLocalidades que nos dirá cuantas localidades se vendieron
         *  el constructor simplemente inicializa el cajero dándole un nombre.
         * Clase Terminal → (que es un hilo), en su constructor se le pasará un objeto Cajero, que será al que
         * accederá y su nombre. El número máximo de localidades que puede vender cada terminal es de 20000.
         * En su método run(): mientras tenga localidades las irá vendiendo y anotando la venta general de
         * localidades y la suya propia.
         * Cuando acabe mostrará cuantas localidades vendió.
         * MainCajero → es el programa principal desde el que creamos un cajero, 3 terminales que trabajen con
         * ese cajero, ponemos en funcionamiento los 3 terminales y cuando terminen mostramos un mensaje que
         * nos indique cuántas localidades han vendido (debería mostrar 60000, en ejecución sincronizada).
         */

        Cajero cajero = new Cajero("Cajero 1");
        Terminal[] terminales = new Terminal[3];
        for (int i = 0; i < terminales.length; i++){
            terminales[i] = new Terminal("Terminal " + (i+1), cajero);
        }

        System.out.println("Iniciando hilos...");
        for (Terminal t : terminales){
            t.start();
        }

        for(Terminal t : terminales){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("En total se han vendido %d localidades.\n", cajero.mostrarLocalidades());
    }
}
