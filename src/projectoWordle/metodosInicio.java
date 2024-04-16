package projectoWordle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class metodosInicio {
	
	public static boolean existeArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		return archivo.exists();
	}

	public static void crearArchivo(String nombreArchivo,String nombre) throws IOException {
		File archivo = new File(nombreArchivo);
		archivo.createNewFile();
		try (FileWriter escritor = new FileWriter(archivo)) {
			//nombre
			escritor.write(nombre+ "\n");
			//numero de juegos jugados, numero de veces que ha ganado, numero de veces que ha perdido
			for (int i = 0; i < 3; i++) {
				escritor.append("0").append("\n");
	        }
		}
	}
	public static void buscarNombreUsuario(String nombreArchivo, String nombreUsuarioABuscar) throws IOException {
	    File archivo = new File(nombreArchivo);
	    boolean nombreUsuarioEncontrado = false;
	    // Leer el contenido actual del archivo
	    StringBuilder contenidoActual = new StringBuilder();
	    try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
	        String linea;
	        while ((linea = lector.readLine()) != null) {
	            contenidoActual.append(linea).append("\n");

	            if (linea.equals(nombreUsuarioABuscar)) {
	                nombreUsuarioEncontrado = true;
	            }
	        }
	    }
	    if (!nombreUsuarioEncontrado) {
	        // Añadir el nombre de usuario y las filas al final del contenido
	        contenidoActual.append(nombreUsuarioABuscar).append("\n");
	        for (int i = 0; i < 3; i++) {
	            contenidoActual.append("0").append("\n");
	        }
	        // Escribir el contenido actualizado al archivo
	        try (FileWriter escritor = new FileWriter(archivo)) {
	            escritor.write(contenidoActual.toString());
	        }
	    }
	}


}
