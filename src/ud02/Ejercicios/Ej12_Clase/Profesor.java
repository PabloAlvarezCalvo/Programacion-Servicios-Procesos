package ud02.Ejercicios.Ej12_Clase;

public class Profesor extends Thread {
    private Bienvenida bienvenida;

    public Profesor(String name, Bienvenida bienvenida){
        super(name);
        this.bienvenida = bienvenida;
    }

    public void run (){
        bienvenida.saludar(this);
    }
}
