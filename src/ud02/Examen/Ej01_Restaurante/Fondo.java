package ud02.Examen.Ej01_Restaurante;

public class Fondo {
    private double recaudacion = 0;

    public Fondo(){

    }

    public synchronized void sumarRecaudacion(double recaudacion){
        this.recaudacion += recaudacion;
    }

    public synchronized double getRecaudacion(){
        return this.recaudacion;
    }
}
