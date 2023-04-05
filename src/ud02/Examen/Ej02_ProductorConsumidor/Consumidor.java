package ud02.Examen.Ej02_ProductorConsumidor;

public class Consumidor extends Thread {
    private Recipiente recipiente;

    public Consumidor(String name, Recipiente recipiente){
        super(name);
        this.recipiente = recipiente;
    }

    public void run(){
        String cadena = "";
        int contador = 0;
        do {
            cadena = recipiente.get();
            System.out.println("Recibida cadena: " + cadena);
            System.out.println("Conversión a mayúsculas: " + cadena.toUpperCase() + ".");
            System.out.printf("Cantidad de caracteres: %d.\n", cadena.length());
            if (!cadena.equals("*")) {
                System.out.println("Introduzca otra cadena, o * para finalizar.");
            }
            contador++;
        } while(contador < 10 && !cadena.equals("*"));

        System.out.println("Fin de hilo consumidor.");
    }
}
