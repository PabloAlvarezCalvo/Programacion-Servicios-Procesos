package ud01.Ejercicios.Ej5_Repetir5Veces;

public class HijoRepetir {
    public static void main(String[] args) {
        //Valor de salida 1, argumentos < 1
        if (args.length > 0) {
            for (int i = 0; i < 5; i++) {
                System.out.println(args[0]);
            }
            System.exit(0);
        } else {
            System.out.println("Ningun argumento recibido");
            System.exit(1);
        }
    }
}
