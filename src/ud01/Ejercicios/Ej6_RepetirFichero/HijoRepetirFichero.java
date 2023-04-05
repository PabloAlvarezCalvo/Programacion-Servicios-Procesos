package ud01.Ejercicios.Ej6_RepetirFichero;

public class HijoRepetirFichero {
    public static void main(String[] args) {
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
