package ud01.Ejemplos.A1_4_LeerNombre;

public class HijoLeerNombre {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("El nombre es: " + args[0]);
            System.exit(1);
        } else {
            System.out.println("Ningún nombre recibido");
            System.exit(-1);
        }
    }
}
