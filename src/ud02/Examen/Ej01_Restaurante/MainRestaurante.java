package ud02.Examen.Ej01_Restaurante;

public class MainRestaurante {
    public static void main(String[] args) {
        //5 sedes
        //Fondo bancario común, almacena el total global de cobros
        //Al final del programa se mostrará el importe total facturado

        Fondo fondo = new Fondo();

        Thread[] sedes = new Thread[5];
        for (int i = 0; i < sedes.length; i++){
            sedes[i] = new Sede("Sede " + (i+1), fondo);
        }

        for (Thread t : sedes){
            t.start();
        }

        for (Thread t : sedes){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("La recaudación total ha sido de %.2f€.\n", fondo.getRecaudacion());
    }
}
