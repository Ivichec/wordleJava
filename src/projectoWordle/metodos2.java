package projectoWordle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class metodos2 {
	  public static int[] buscarDatosUsuario(String nombreUsuario) throws IOException {
	        try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"))) {
	            String linea;
	            while ((linea = lector.readLine()) != null) {
	                if (linea.equals(nombreUsuario)) {
	                    // Se encontr� el nombre de usuario, leer las siguientes 3 l�neas
	                    int[] valores = new int[3];
	                    for (int i = 0; i < 3; i++) {
	                        linea = lector.readLine();
	                        valores[i] = Integer.parseInt(linea);
	                    }
	                    return valores;
	                }
	            }
	        }
	        return null; // Usuario no encontrado
	    }
}
