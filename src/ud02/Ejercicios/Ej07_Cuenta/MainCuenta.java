package ud02.Ejercicios.Ej07_Cuenta;

public class MainCuenta {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1000);

        Thread hiloPepe = new RetiradaDeCajero("Hilo Pepe", cuenta);
        Thread hiloMaria = new RetiradaDeCajero("Hilo Maria", cuenta);

        hiloPepe.start();
        hiloMaria.start();

    }
}
