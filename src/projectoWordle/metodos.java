package projectoWordle;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class metodos {
	public static JTextField[][] palabrasLetras = new JTextField[5][5];
	public static boolean[] noborrar = new boolean[5];

	// Método para asignar JTextField existentes al array bidimensional
	public static void asignarCamposExistente() {
	    palabrasLetras[0][0] = wordle.palabra1letra1;
	    palabrasLetras[0][1] = wordle.palabra1letra2;
	    palabrasLetras[0][2] = wordle.palabra1letra3;
	    palabrasLetras[0][3] = wordle.palabra1letra4;
	    palabrasLetras[0][4] = wordle.palabra1letra5;
	    palabrasLetras[1][0] = wordle.palabra2letra1;
	    palabrasLetras[1][1] = wordle.palabra2letra2;
	    palabrasLetras[1][2] = wordle.palabra2letra3;
	    palabrasLetras[1][3] = wordle.palabra2letra4;
	    palabrasLetras[1][4] = wordle.palabra2letra5;
	    palabrasLetras[2][0] = wordle.palabra3letra1;
	    palabrasLetras[2][1] = wordle.palabra3letra2;
	    palabrasLetras[2][2] = wordle.palabra3letra3;
	    palabrasLetras[2][3] = wordle.palabra3letra4;
	    palabrasLetras[2][4] = wordle.palabra3letra5;
	    palabrasLetras[3][0] = wordle.palabra4letra1;
	    palabrasLetras[3][1] = wordle.palabra4letra2;
	    palabrasLetras[3][2] = wordle.palabra4letra3;
	    palabrasLetras[3][3] = wordle.palabra4letra4;
	    palabrasLetras[3][4] = wordle.palabra4letra5;
	    palabrasLetras[4][0] = wordle.palabra5letra1;
	    palabrasLetras[4][1] = wordle.palabra5letra2;
	    palabrasLetras[4][2] = wordle.palabra5letra3;
	    palabrasLetras[4][3] = wordle.palabra5letra4;
	    palabrasLetras[4][4] = wordle.palabra5letra5;
	    noborrar[0] = wordle.noborrar1;
	    noborrar[1] = wordle.noborrar2;
	    noborrar[2] = wordle.noborrar3;
	    noborrar[3] = wordle.noborrar4;
	    noborrar[4] = wordle.noborrar5;
	}
	//metodo para elejir la palabra que se va a tener que adivinar al azar
	public static String seleccionarPalabraAlAzar(String rutaArchivo)throws IOException  {
        List<String> palabras = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while((linea = br.readLine())!=null){
                palabras.add(linea.trim());
            }
        }catch(IOException e){
        	throw new IOException("Error al leer el archivo: " + e.getMessage(), e);
        }

        if(!palabras.isEmpty()){
            Random random = new Random();
            int indicePalabraSeleccionada = random.nextInt(palabras.size());
            return palabras.get(indicePalabraSeleccionada);
        }else{
            return null; // Devuelve null si la lista de palabras está vacía
        }
    }
	public static Map<Character, List<Integer>> obtenerIndicesPorLetra(String texto) {
        Map<Character, List<Integer>> indicesPorLetra = new HashMap<>();

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            // Ignorar caracteres que no son letras
            if (Character.isLetter(letra)) {
                letra = Character.toLowerCase(letra); // Convertir a minúscula para hacer la comparación insensible a mayúsculas
                indicesPorLetra.computeIfAbsent(letra, k -> new ArrayList<>()).add(i);
            }
        }

        return indicesPorLetra;
    }
	//Metodo para comprobar letras y asignar colores
	public static void comprobarLetras(int i) throws IOException {
		asignarCamposExistente();
		int contador = 0;
		JLabel errores = wordle.errores;
	    for (int y = 0; y < 5; y++) {
	        JTextField letraAbuscar = palabrasLetras[i][y];
	            String textoCampo = letraAbuscar.getText();
	         // Bloqueo las celdas para que no puedan escribir en ellas de nuevo
	            letraAbuscar.setEditable(false);
	            if (textoCampo.charAt(0) == wordle.palabra.charAt(y)) {
	                letraAbuscar.setBackground(Color.GREEN);
	                contador++;
	            } else {
	            	// Si la letra esta en la palabra pero en otra posicion, se pone en naranja
		            for (int p = 0; p < wordle.palabra.length(); p++) {
		                if (letraAbuscar.getText().charAt(0) == wordle.palabra.charAt(p)) {
		                	letraAbuscar.setBackground(Color.ORANGE);	
		                }
		                // Si la letra no esta se queda como estaba
		            }
	            }
	            
	    }
	    if(contador == 5) {
	    	errores.setText("¡¡¡Palabra acertada!!!");
	    	aumentarNumeroUsuario(wordleNombreUsu.cookie, true);
	    	 SwingUtilities.invokeLater(() -> {
	    	        JButton botonPerfil = new JButton("Pulsa para ir al perfil");
	    	        botonPerfil.setBackground(Color.GRAY);
	    	        botonPerfil.setBounds(32, 443, 372, 62);
	    	        
	    	        // Asegúrate de que el botón esté en la capa superior
	    	        wordle.contentPane.add(botonPerfil);
	    	        wordle.contentPane.setComponentZOrder(botonPerfil, 0);
	    	        wordle.contentPane.revalidate(); // Actualiza el contenedor
	    	        wordle.contentPane.repaint();
	    	        botonPerfil.addMouseListener(new MouseAdapter() {
	    				@Override
	    				public void mouseClicked(MouseEvent e) {
	    					wordle2 frame2 = null;
							try {
								frame2 = new wordle2();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	    					frame2.setVisible(true);
	    					final Component source = e.getComponent();
	    				    final JFrame frame = (JFrame) SwingUtilities.getRoot(source);
	    				    frame.dispose();
	    				}
	    			});
	    	    });
	    }
	    if(i == 4 && contador !=5) {
	    	errores.setText("Has perdido :(, la palabra correcta era: "+ wordle.palabra);
	    	aumentarNumeroUsuario(wordleNombreUsu.cookie, false);
	    	 SwingUtilities.invokeLater(() -> {
	    	        JButton botonPerfil = new JButton("Pulsa para ir al perfil");
	    	        botonPerfil.setBackground(Color.GRAY);
	    	        botonPerfil.setBounds(32, 443, 372, 62);
	    	        
	    	        // Asegúrate de que el botón esté en la capa superior
	    	        wordle.contentPane.add(botonPerfil);
	    	        wordle.contentPane.setComponentZOrder(botonPerfil, 0);
	    	        wordle.contentPane.revalidate(); // Actualiza el contenedor
	    	        wordle.contentPane.repaint();
	    	        botonPerfil.addMouseListener(new MouseAdapter() {
	    				@Override
	    				public void mouseClicked(MouseEvent e) {
	    					wordle2 frame2 = null;
							try {
								frame2 = new wordle2();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	    					frame2.setVisible(true);
	    					final Component source = e.getComponent();
	    				    final JFrame frame = (JFrame) SwingUtilities.getRoot(source);
	    				    frame.dispose();
	    				}
	    			});
	    	    });
	    }
	}
	 public static void aumentarNumeroUsuario(String nombreUsuario, boolean usuarioGana) throws IOException {
	        Path archivoOriginal = Paths.get("datos.txt");
	        Path archivoTemporal = Paths.get("datos1.txt");

	        try (BufferedReader lector = Files.newBufferedReader(archivoOriginal);
	             BufferedWriter escritor = Files.newBufferedWriter(archivoTemporal, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

	            String linea;
	            boolean usuarioEncontrado = false;

	            while ((linea = lector.readLine()) != null) {
	                if (linea.equals(nombreUsuario)) {
	                    usuarioEncontrado = true;

	                    // Si se encuentra el nombre de usuario, aumentar el número en la segunda y tercera línea según si gana o pierde
	                    int numeroSegundaLinea = Integer.parseInt(lector.readLine()); // Segunda línea
	                    int numeroTerceraLinea = Integer.parseInt(lector.readLine()); // Tercera línea
	                    int numeroCuartaLinea = Integer.parseInt(lector.readLine()); // Cuarta línea
	                    
	                    if (usuarioGana) {
	                        numeroSegundaLinea++;
	                        numeroTerceraLinea++;
	                    }else {
	                    	 numeroSegundaLinea++;
		                     numeroCuartaLinea++;
	                    }

	                    escritor.write(nombreUsuario);
	                    escritor.newLine();
	                    escritor.write(Integer.toString(numeroSegundaLinea));
	                    escritor.newLine();
	                    escritor.write(Integer.toString(numeroTerceraLinea));
	                    escritor.newLine();
	                    escritor.write(Integer.toString(numeroCuartaLinea));
	                    escritor.newLine();
	                } else {
	                    // Copiar las líneas que no están relacionadas con el nombre de usuario
	                    escritor.write(linea);
	                    escritor.newLine();
	                }
	            }

	            // Si el usuario no se encontró, agregarlo al final del archivo con los valores iniciales
	            if (!usuarioEncontrado) {
	                escritor.write(nombreUsuario);
	                escritor.newLine();
	                escritor.write("0"); // Número de juegos ganados
	                escritor.newLine();
	                escritor.write("0"); // Número de juegos perdidos
	                escritor.newLine();
	            }
	        }

	        try {
	            Files.move(archivoTemporal, archivoOriginal, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException e) {
	            System.out.println("Error al mover el archivo: " + e.getMessage());
	        }
	    }

	//metodo para comprobar que la palabra existe
    public static boolean comprobarPalabraEnArchivo(String rutaArchivo, String palabraAComprobar) {
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // Lee cada línea del archivo
            while((linea = br.readLine()) != null){
                // Comprueba si la palabra actual es igual a la palabra que deseas comprobar
                if(linea.equals(palabraAComprobar)){
                    return true;  // La palabra es igual a la que se busca
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;  // La palabra no se encuentra en el archivo o hay un problema de lectura
    }
    public static void configurarCampoDeTextoConEvento(JTextField anteriorCampo, JTextField campoActual,JTextField siguienteCampo, boolean noborrar, KeyEvent e){
        int keyCode = e.getKeyChar();

        if(campoActual.getText().length() == 1){
            // Solo dejar que puedan escribir una letra en cada campo de texto
            campoActual.setEditable(false);
        }

        if(keyCode == KeyEvent.VK_BACK_SPACE) {
        	if(campoActual.getText().length() == 0) {
        		anteriorCampo.requestFocus();
        	}
            if (!noborrar) {
                campoActual.setEditable(true);
                campoActual.setText("");
            }
        } else {
            siguienteCampo.requestFocus();  // Mover el enfoque solo si se ha ingresado una letra
        }
    }
	public static void validarPalabra(int i) {
		asignarCamposExistente();
	    for (int y = 0; y < 5; y++) {
	        JTextField letraAbuscar = palabrasLetras[i][y];
	            String textoCampo = letraAbuscar.getText();
	            boolean yaEsta = false; 
	         // Bloqueo las celdas para que no puedan escribir en ellas de nuevo
	            letraAbuscar.setEditable(false);
	            if (textoCampo.charAt(0) == wordle.palabra.charAt(y)) {
	                letraAbuscar.setBackground(Color.GREEN);
	                yaEsta = true;
	            } else {
	            	// Si la letra esta en la palabra pero en otra posicion, se pone en naranja
		            for (int p = 0; p < wordle.palabra.length(); p++) {
		                if (letraAbuscar.getText().charAt(0) == wordle.palabra.charAt(p)) {
		                	if(!yaEsta) {
		                		letraAbuscar.setBackground(Color.ORANGE);
		                	}
		                }
		                // Si la letra no esta se queda como estaba
		            }
	            }
	            
	    }
	}
	public static void ultimaLetraPalabra(int i) throws IOException {
		asignarCamposExistente();
		JLabel errores = wordle.errores;
		if(palabrasLetras[i][0].getText().length()==1 || palabrasLetras[i][1].getText().length()==1 || palabrasLetras[i][2].getText().length()==1 || palabrasLetras[i][3].getText().length()==1 || palabrasLetras[i][4].getText().length()==1) {
			String palabraAComprobar = palabrasLetras[i][0].getText()+palabrasLetras[i][1].getText()+palabrasLetras[i][2].getText()+palabrasLetras[i][3].getText()+palabrasLetras[i][4].getText();
    		String rutaArchivo = "05.txt";
    	    if(metodos.comprobarPalabraEnArchivo(rutaArchivo, palabraAComprobar)){
    		    //Si la palabra existe comprueba la posicion de las letras y les da color dependiendo de su posicion.
        		metodos.comprobarLetras(i);  
        		if(i != 4) {
        			palabrasLetras[i+1][0].requestFocus();  // Mover el enfoque solo si se ha ingresado una letra.
            		noborrar[i] = true; //no dejar que lo pueda editar una vez comprobado.
        		}else {
        			palabrasLetras[i][0].requestFocus();  // Mover el enfoque solo si se ha ingresado una letra.
            		noborrar[i] = true; //no dejar que lo pueda editar una vez comprobado.
        		}
        		
    	    }else{
    	    	 //Si la palabra no existe borra todo y te deja volver a editar.
    	    	palabrasLetras[i][0].setEditable(true);
    	    	palabrasLetras[i][0].setText("");
    	    	palabrasLetras[i][1].setEditable(true);
    	    	palabrasLetras[i][1].setText("");
    	    	palabrasLetras[i][2].setEditable(true);
    	    	palabrasLetras[i][2].setText("");
    	    	palabrasLetras[i][3].setEditable(true);
    	    	palabrasLetras[i][3].setText("");
    	    	palabrasLetras[i][4].setEditable(true);
    	    	palabrasLetras[i][4].setText("");
	        	noborrar[i] = false;// dejar que lo pueda editar porque la palabra no existe.
	        	errores.setText("Palabra no existe");
    	    }	
    	}
	}



}
