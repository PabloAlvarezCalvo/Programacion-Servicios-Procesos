package ud02.Ejercicios.Ej12_Clase;

public class Alumno extends Thread {
    private Bienvenida bienvenida;

    public Alumno(String name, Bienvenida bienvenida){
        super(name);
        this.bienvenida = bienvenida;
    }

    public void run (){
        bienvenida.saludar(this);
    }
}
