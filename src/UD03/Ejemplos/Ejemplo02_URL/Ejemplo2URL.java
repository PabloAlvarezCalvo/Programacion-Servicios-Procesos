package UD03.Ejemplos.Ejemplo02_URL;

import java.io.*;
import java.net.*;

public class Ejemplo2URL {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://google.es");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main
}// Ejemplo2URL
