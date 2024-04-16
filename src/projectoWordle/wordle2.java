package projectoWordle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class wordle2 extends JFrame {

	private JPanel contentPane;
	public static JLabel nombre;
	public static JLabel juegosJugados;
	public static JLabel ganados;
	public static JLabel perdidos;
	public static JLabel nombre_respuesta;
	public static JLabel juegosJugados_respuesta;
	public static JLabel ganados_respuesta;
	public static JLabel perdidos_respuesta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordleNombreUsu frame1 = null;
					frame1 = new wordleNombreUsu();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public wordle2() throws IOException {
		int[] datosUsuario = metodos2.buscarDatosUsuario(wordleNombreUsu.cookie);
		wordle2.nombre_respuesta = new JLabel(wordleNombreUsu.cookie);
	    wordle2.juegosJugados_respuesta = new JLabel(String.valueOf(datosUsuario[0]));
	    wordle2.ganados_respuesta = new JLabel(String.valueOf(datosUsuario[1]));
	    wordle2.perdidos_respuesta = new JLabel(String.valueOf(datosUsuario[2]));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombre = new JLabel("Nombre: ");
		nombre.setBounds(109, 68, 90, 14);
		contentPane.add(nombre);
		
		JLabel juegosJugados = new JLabel("N\u00BA de juegos: ");
		juegosJugados.setBounds(109, 93, 90, 14);
		contentPane.add(juegosJugados);
		
		JButton Jugar = new JButton("Volver a Jugar");
		Jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		Jugar.setBounds(134, 185, 137, 54);
		Jugar.setBackground(Color.YELLOW);
		contentPane.add(Jugar);
		
		JLabel ganados = new JLabel("Ganados: ");
		ganados.setBounds(109, 118, 90, 17);
		contentPane.add(ganados);
		
		JLabel perdidos = new JLabel("Perdidos: ");
		perdidos.setBounds(109, 146, 90, 14);
		contentPane.add(perdidos);
		
		nombre_respuesta.setBounds(226, 68, 47, 14);
		contentPane.add(nombre_respuesta);
		
		juegosJugados_respuesta.setBounds(226, 93, 73, 14);
		contentPane.add(juegosJugados_respuesta);
		
		ganados_respuesta.setBounds(226, 118, 73, 17);
		contentPane.add(ganados_respuesta);
		
		perdidos_respuesta.setBounds(226, 146, 73, 14);
		contentPane.add(perdidos_respuesta);
		
		JLabel titulo = new JLabel("Estadisticas WORDLE");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titulo.setBackground(Color.GRAY);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(134, 11, 152, 28);
		contentPane.add(titulo);
	}
}
