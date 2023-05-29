package UD03.Ejemplos.Ejemplo01_InetAddress;

import java.net.*;

public class TestInetAddress {
	public static void main(String[] args) {
		InetAddress dir = null;
		System.out.println("========================================================");
		System.out.println("Salida para localhost: ");
		try {
			//LOCALHOST
			dir = InetAddress.getByName("localhost");
			pruebaMetodos(dir);//

			//URL	www.google.es
			System.out.println("========================================================");
			System.out.println("Salida para url:");
			dir = InetAddress.getByName("www.google.es");
			pruebaMetodos(dir);

			 // Array de tipo InetAddress con todas las direcciones IP
			 //asignadas a google.es
			 System.out.println("\tDirecciones IP para: " + dir.getHostName());
			 InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
			 for (int i = 0; i < direcciones.length; i++) {
				 System.out.println("\t\t" + direcciones[i].toString());
			 }

			System.out.println("========================================================");

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	}// main

	private static void pruebaMetodos(InetAddress dir) {
		System.out.println("\tMétodo getByName(): " + dir);
		InetAddress dir2;
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMétodo getLocalHost(): " + dir2);
		} catch (UnknownHostException e) {e.printStackTrace();}

		// USAMOS METODOS DE LA CLASE
		System.out.println("\tMétodo getHostName(): "+ dir.getHostName());
		System.out.println("\tMétodo getHostAddress(): "+ dir.getHostAddress());
		System.out.println("\tMétodo toString(): " + dir);
		System.out.println("\tMétodo getCanonicalHostName(): " + dir.getCanonicalHostName());
	}//pruebaMetodos
		
}//fin



