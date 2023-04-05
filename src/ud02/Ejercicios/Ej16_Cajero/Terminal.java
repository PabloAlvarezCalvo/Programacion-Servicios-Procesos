package ud02.Ejercicios.Ej16_Cajero;

public class Terminal extends Thread {
    /* Clase Terminal → (que es un hilo), en su constructor se le pasará un objeto Cajero, que será al que
     * accederá y su nombre. El número máximo de localidades que puede vender cada terminal es de 20000.
        * En su método run(): mientras tenga localidades las irá vendiendo y anotando la venta general de
     * localidades y la suya propia.
     * Cuando acabe mostrará cuantas localidades vendió.
     */
    private Cajero cajero;
    private int ventasLocales = 0;
    private final int MAX_VENTAS = 20;

    public Terminal(String nombre, Cajero cajero){
        super(nombre);
        this.cajero = cajero;
    }

    public void run(){
        while (ventasLocales < MAX_VENTAS){
            synchronized (cajero) {
                cajero.sumarLocalidades();
                ventasLocales++;
                System.out.printf("%s ha vendido una entrada. Total %d entradas vendidas. Cha-ching!\n", super.getName(), ventasLocales);
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}
