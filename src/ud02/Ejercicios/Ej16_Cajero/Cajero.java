package ud02.Ejercicios.Ej16_Cajero;

public class Cajero {
    /* Clase Cajero → es el recurso compartido por los terminales (sección crítica)
     *  Un atributo localidades que contiene la cuenta de las localidades vendidas
     *  un método sumarLocalidades que irá contando las localidades vendidas
     *  un método mostrarLocalidades que nos dirá cuantas localidades se vendieron
     *  el constructor simplemente inicializa el cajero dándole un nombre.
     */

    private final String nombre;
    private int localidades;

    public Cajero(String nombre){
        this.nombre = nombre;
    }

    public void sumarLocalidades(){
        this.localidades++;
    }

    public int mostrarLocalidades(){
        return this.localidades;
    }

}
