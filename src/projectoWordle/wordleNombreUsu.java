package projectoWordle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class wordleNombreUsu extends JFrame {

	private JPanel contentPane;
	private JTextField datos;
	public static JLabel errores;
	public static String cookie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordleNombreUsu frame = new wordleNombreUsu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public wordleNombreUsu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel errores = new JLabel("");
		errores.setBounds(89, 211, 252, 43);
		contentPane.add(errores);
		JLabel nombreUsu = new JLabel("Nombre de usuario: ");
		nombreUsu.setHorizontalAlignment(SwingConstants.CENTER);
		nombreUsu.setBounds(61, 62, 128, 35);
		contentPane.add(nombreUsu);
		
		datos = new JTextField();
		Font newTextFieldFont=new Font(datos.getFont().getName(),datos.getFont().getStyle(),20);
		datos.setFont(newTextFieldFont);
		datos.setColumns(1);
		datos.setBounds(199, 62, 142, 35);
		contentPane.add(datos);
		
		JButton entrar = new JButton("Empezar a jugar!");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// funcion para comprobar si esta en el fichero y si no esta añadirlo
				String nombreArchivo = "datos.txt";
				if(datos.getText().length() == 0) {
					errores.setText("Error, pon tu nombre");
				}else {
					if (!metodosInicio.existeArchivo(nombreArchivo)) {
						// El archivo no existe, lo creamos
						try {
							metodosInicio.crearArchivo(nombreArchivo, datos.getText());
						} catch (IOException e1) {
							System.err.println("Error al crear el archivo: " + e1.getMessage());
						}
					}else {
						try {
							metodosInicio.buscarNombreUsuario(nombreArchivo, datos.getText());
						} catch (IOException e1) {
							System.err.println("Error al buscar en el archivo: " + e1.getMessage());
						}
					}
					cookie = datos.getText();
					wordle frame1 = null;
					try {
						frame1 = new wordle();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame1.setVisible(true);
					dispose();
				}
			}
		});
		entrar.setBackground(Color.YELLOW);
		entrar.setBounds(126, 128, 137, 54);
		contentPane.add(entrar);
		
		JLabel lblWordleIvn = new JLabel("WORDLE IVAN");
		lblWordleIvn.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordleIvn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWordleIvn.setBackground(Color.GRAY);
		lblWordleIvn.setBounds(126, 11, 152, 28);
		contentPane.add(lblWordleIvn);
		

	}

}
