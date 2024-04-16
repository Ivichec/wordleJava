package projectoWordle;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class wordle extends JFrame {

	public static JPanel contentPane;
	public static JTextField palabra1letra1;
	public static JTextField palabra1letra2;
	public static JTextField palabra1letra3;
	public static JTextField palabra1letra4;
	public static JTextField palabra1letra5;
	public static JTextField palabra2letra5;
	public static JTextField palabra2letra1;
	public static JTextField palabra2letra2;
	public static JTextField palabra2letra3;
	public static JTextField palabra2letra4;
	public static JTextField palabra3letra5;
	public static JTextField palabra3letra1;
	public static JTextField palabra3letra2;
	public static JTextField palabra3letra3;
	public static JTextField palabra3letra4;
	public static JTextField palabra4letra5;
	public static JTextField palabra4letra1;
	public static JTextField palabra4letra2;
	public static JTextField palabra4letra3;
	public static JTextField palabra4letra4;
	public static JTextField palabra5letra5;
	public static JTextField palabra5letra1;
	public static JTextField palabra5letra2;
	public static JTextField palabra5letra3;
	public static JTextField palabra5letra4;
	private JTextArea titulo;
	public static String palabra;
	public static Boolean noborrar1 = false;
	public static Boolean noborrar2 = false;
	public static Boolean noborrar3 = false;
	public static Boolean noborrar4 = false;
	public static Boolean noborrar5 = false;
	public static Boolean noborrar6 = false;
	public static JLabel errores;
	public static JButton botonPerfil;

	/**
	 * Launch the application.
	 */
	/*Metodos que tengo que hacer:
		-comprobar que la palabra que ponen  existe.///////hecho en la primera palabra
		-elegir palabra al azar.///////hecho
		-una vez terminen los 5 intentos salga la palabra que era.
		-si la hacierta que le salgo un mensaje de enhorabuena.
		-metodo para que no deje poner numeros ni letras(bueno eso se contradice porque el de comprobar que este en el diccionario lo soluciona).
		-hay me hacer una variable statica publica que te diga si ya se ha comprobado una palabra y ya se ha asignado las letras con sus colores 
		que no te deje editarlo.
		**********Opcional***********
		-solo dejar que escriba una letra en cada casilla ///////hecho en la primera palabra
		-si pulsa la techa de borrar dejar que la vuelva a editar ///////hecho en la primera palabra
		*********Bugs*************
		-si una letra esta en verde y esta en la palabra en otro lugar no se cambie a naranja.
	*/
	//Metodos
	
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordleNombreUsu frame1 = null;
					frame1 = new wordleNombreUsu();
					frame1.setVisible(true);
					String rutaArchivo = "05.txt";
			        String palabraSeleccionada = metodos.seleccionarPalabraAlAzar(rutaArchivo);

			        if (palabraSeleccionada != null) {
			        	palabra = palabraSeleccionada;
			        }else {
			        	palabra = "perro";
			        }
					
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
	public wordle() throws IOException {
		String rutaArchivo = "05.txt";
        String palabraSeleccionada = metodos.seleccionarPalabraAlAzar(rutaArchivo);

        if (palabraSeleccionada != null) {
        	palabra = palabraSeleccionada;
        }else {
        	palabra = "perro";
        }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		palabra1letra1 = new JTextField();
		//cambiar el tamaño de texto de las letras
		Font newTextFieldFont=new Font(palabra1letra1.getFont().getName(),palabra1letra1.getFont().getStyle(),40);
		palabra1letra1.setFont(newTextFieldFont);
		palabra1letra1.addKeyListener(new KeyAdapter(){
		    @Override
		    public void keyTyped(KeyEvent e){
		    	metodos.configurarCampoDeTextoConEvento(palabra1letra1,palabra1letra1, palabra1letra2, noborrar1, e);
		    }
		});


		palabra1letra1.setBounds(60, 44, 45, 62);
		contentPane.add(palabra1letra1);
		palabra1letra1.setColumns(1);
		
		palabra1letra2 = new JTextField();
		//cambiar el tamaño de texto de las letras
		Font newTextFieldFont1=new Font(palabra1letra2.getFont().getName(),palabra1letra2.getFont().getStyle(),40);
		palabra1letra2.setFont(newTextFieldFont1);
		palabra1letra2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra1letra1,palabra1letra2, palabra1letra3, noborrar1, e);
			}
		});
		palabra1letra2.setColumns(10);
		palabra1letra2.setBounds(125, 44, 45, 62);
		contentPane.add(palabra1letra2);
		
		palabra1letra3 = new JTextField();
		//cambiar el tamaño de texto de las letras
		Font newTextFieldFont2=new Font(palabra1letra3.getFont().getName(),palabra1letra3.getFont().getStyle(),40);
		palabra1letra3.setFont(newTextFieldFont2);
		palabra1letra3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra1letra2,palabra1letra3, palabra1letra4, noborrar1, e);
			}
		});
		palabra1letra3.setColumns(10);
		palabra1letra3.setBounds(191, 44, 45, 62);
		contentPane.add(palabra1letra3);
		
		palabra1letra4 = new JTextField();
		//cambiar el tamaño de texto de las letras
		Font newTextFieldFont4=new Font(palabra1letra4.getFont().getName(),palabra1letra4.getFont().getStyle(),40);
		palabra1letra4.setFont(newTextFieldFont4);
		palabra1letra4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra1letra3,palabra1letra4, palabra1letra5, noborrar1, e);
			}
		});
		palabra1letra4.setColumns(10);
		palabra1letra4.setBounds(257, 44, 45, 62);
		contentPane.add(palabra1letra4);
		
		palabra1letra5 = new JTextField();
		//cambiar el tamaño de texto de las letras
		Font newTextFieldFont5=new Font(palabra1letra5.getFont().getName(),palabra1letra5.getFont().getStyle(),40);
		palabra1letra5.setFont(newTextFieldFont5);
		palabra1letra5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int keyCode = e.getKeyChar();
				//solo dejar que puedan escribir una letra en cada campo de texto
		        	if(palabra1letra5.getText().length()==1) {
			        	//solo dejar que puedan escribir una letra en cada campo de texto
					 	palabra1letra5.setEditable(false);
					}
			        if(keyCode == KeyEvent.VK_BACK_SPACE) {
			        	if(palabra1letra5.getText().length() == 0) {
			        		palabra1letra4.requestFocus();
			        	}
			        	if(!noborrar1) {
			        		palabra1letra5.setEditable(true);
				        	palabra1letra5.setText("");
			        	}
			        }
			        if(e.getKeyChar()=='\n') {
			        	try {
							metodos.ultimaLetraPalabra(0);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}

		
		});
		palabra1letra5.setColumns(10);
		palabra1letra5.setBounds(322, 44, 45, 62);
		contentPane.add(palabra1letra5);
		
		palabra2letra1 = new JTextField();
		Font newTextFieldFont21=new Font(palabra2letra1.getFont().getName(),palabra2letra1.getFont().getStyle(),40);
		palabra2letra1.setFont(newTextFieldFont21);
		palabra2letra1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra2letra1,palabra2letra1, palabra2letra2, noborrar2, e);
			}
		});
		palabra2letra1.setColumns(10);
		palabra2letra1.setBounds(60, 117, 45, 62);
		contentPane.add(palabra2letra1);
		
		palabra2letra2 = new JTextField();
		Font newTextFieldFont22=new Font(palabra2letra2.getFont().getName(),palabra2letra2.getFont().getStyle(),40);
		palabra2letra2.setFont(newTextFieldFont22);
		palabra2letra2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra2letra1,palabra2letra2, palabra2letra3, noborrar2, e);
			}
		});
		palabra2letra2.setColumns(10);
		palabra2letra2.setBounds(125, 117, 45, 62);
		contentPane.add(palabra2letra2);
		
		palabra2letra3 = new JTextField();
		Font newTextFieldFont23=new Font(palabra2letra3.getFont().getName(),palabra2letra3.getFont().getStyle(),40);
		palabra2letra3.setFont(newTextFieldFont23);
		palabra2letra3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra2letra2,palabra2letra3, palabra2letra4, noborrar2, e);
			}
		});
		palabra2letra3.setColumns(10);
		palabra2letra3.setBounds(191, 117, 45, 62);
		contentPane.add(palabra2letra3);
		
		palabra2letra4 = new JTextField();
		Font newTextFieldFont24=new Font(palabra2letra4.getFont().getName(),palabra2letra4.getFont().getStyle(),40);
		palabra2letra4.setFont(newTextFieldFont24);
		palabra2letra4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra2letra3,palabra2letra4, palabra2letra5, noborrar2, e);
			}
		});
		palabra2letra4.setColumns(10);
		palabra2letra4.setBounds(257, 117, 45, 62);
		contentPane.add(palabra2letra4);
		
		palabra2letra5 = new JTextField();
		Font newTextFieldFont25=new Font(palabra2letra5.getFont().getName(),palabra2letra5.getFont().getStyle(),40);
		palabra2letra5.setFont(newTextFieldFont25);
		palabra2letra5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int keyCode = e.getKeyChar();
					//solo dejar que puedan escribir una letra en cada campo de texto
			        	if(palabra2letra5.getText().length()==1) {
				        	//solo dejar que puedan escribir una letra en cada campo de texto
						 	palabra2letra5.setEditable(false);
						}
				        if(keyCode == KeyEvent.VK_BACK_SPACE) {
				        	if(palabra2letra5.getText().length() == 0) {
				        		palabra2letra4.requestFocus();
				        	}
				        	if(!noborrar1) {
				        		palabra2letra5.setEditable(true);
					        	palabra2letra5.setText("");
				        	}
				        }
				        if(e.getKeyChar()=='\n') {
				        	try {
								metodos.ultimaLetraPalabra(1);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
			}
		});
		palabra2letra5.setColumns(10);
		palabra2letra5.setBounds(322, 117, 45, 62);
		contentPane.add(palabra2letra5);
		
		palabra3letra1 = new JTextField();
		Font newTextFieldFont31=new Font(palabra3letra1.getFont().getName(),palabra3letra1.getFont().getStyle(),40);
		palabra3letra1.setFont(newTextFieldFont31);
		palabra3letra1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra3letra1,palabra3letra1, palabra3letra2, noborrar3, e);
			}
		});
		palabra3letra1.setColumns(10);
		palabra3letra1.setBounds(60, 190, 45, 62);
		contentPane.add(palabra3letra1);
		
		palabra3letra2 = new JTextField();
		Font newTextFieldFont32=new Font(palabra3letra2.getFont().getName(),palabra3letra2.getFont().getStyle(),40);
		palabra3letra2.setFont(newTextFieldFont32);
		palabra3letra2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra3letra1,palabra3letra2, palabra3letra3, noborrar3, e);
			}
		});
		palabra3letra2.setColumns(10);
		palabra3letra2.setBounds(125, 190, 45, 62);
		contentPane.add(palabra3letra2);
		
		palabra3letra3 = new JTextField();
		Font newTextFieldFont33=new Font(palabra3letra3.getFont().getName(),palabra3letra3.getFont().getStyle(),40);
		palabra3letra3.setFont(newTextFieldFont33);
		palabra3letra3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra3letra2,palabra3letra3, palabra3letra4, noborrar3, e);
			}
		});
		palabra3letra3.setColumns(10);
		palabra3letra3.setBounds(191, 190, 45, 62);
		contentPane.add(palabra3letra3);
		
		palabra3letra4 = new JTextField();
		Font newTextFieldFont34=new Font(palabra3letra4.getFont().getName(),palabra3letra4.getFont().getStyle(),40);
		palabra3letra4.setFont(newTextFieldFont34);
		palabra3letra4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra3letra3,palabra3letra4, palabra3letra5, noborrar3, e);
			}
		});
		palabra3letra4.setColumns(10);
		palabra3letra4.setBounds(257, 190, 45, 62);
		contentPane.add(palabra3letra4);
		
		palabra3letra5 = new JTextField();
		Font newTextFieldFont35=new Font(palabra3letra5.getFont().getName(),palabra3letra5.getFont().getStyle(),40);
		palabra3letra5.setFont(newTextFieldFont35);
		palabra3letra5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int keyCode = e.getKeyChar();
					//solo dejar que puedan escribir una letra en cada campo de texto
			        	if(palabra3letra5.getText().length()==1) {
				        	//solo dejar que puedan escribir una letra en cada campo de texto
						 	palabra3letra5.setEditable(false);
						}
				        if(keyCode == KeyEvent.VK_BACK_SPACE) {
				        	if(palabra3letra5.getText().length() == 0) {
				        		palabra3letra4.requestFocus();
				        	}
				        	if(!noborrar1) {
				        		palabra3letra5.setEditable(true);
					        	palabra3letra5.setText("");
				        	}
				        }
				        if(e.getKeyChar()=='\n') {
				        	try {
								metodos.ultimaLetraPalabra(2);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
			}
		});
		palabra3letra5.setColumns(10);
		palabra3letra5.setBounds(322, 190, 45, 62);
		contentPane.add(palabra3letra5);
				
		palabra4letra1 = new JTextField();
		Font newTextFieldFont41=new Font(palabra4letra1.getFont().getName(),palabra4letra1.getFont().getStyle(),40);
		palabra4letra1.setFont(newTextFieldFont41);
		palabra4letra1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra4letra1,palabra4letra1, palabra4letra2, noborrar4, e);
			}
		});
		palabra4letra1.setColumns(10);
		palabra4letra1.setBounds(60, 260, 45, 62);
		contentPane.add(palabra4letra1);
		
		palabra4letra2 = new JTextField();
		Font newTextFieldFont42=new Font(palabra4letra2.getFont().getName(),palabra4letra2.getFont().getStyle(),40);
		palabra4letra2.setFont(newTextFieldFont42);
		palabra4letra2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra4letra1,palabra4letra2, palabra4letra3, noborrar4, e);
			}
		});
		palabra4letra2.setColumns(10);
		palabra4letra2.setBounds(125, 260, 45, 62);
		contentPane.add(palabra4letra2);
		
		palabra4letra3 = new JTextField();
		Font newTextFieldFont43=new Font(palabra4letra3.getFont().getName(),palabra4letra3.getFont().getStyle(),40);
		palabra4letra3.setFont(newTextFieldFont43);
		palabra4letra3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra4letra2,palabra4letra3, palabra4letra4, noborrar4, e);
			}
		});
		palabra4letra3.setColumns(10);
		palabra4letra3.setBounds(191, 260, 45, 62);
		contentPane.add(palabra4letra3);
		
		palabra4letra4 = new JTextField();
		Font newTextFieldFont44=new Font(palabra4letra4.getFont().getName(),palabra4letra4.getFont().getStyle(),40);
		palabra4letra4.setFont(newTextFieldFont44);
		palabra4letra4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra4letra3,palabra4letra4, palabra4letra5, noborrar4, e);
			}
		});
		palabra4letra4.setColumns(10);
		palabra4letra4.setBounds(257, 260, 45, 62);
		contentPane.add(palabra4letra4);
		
		palabra4letra5 = new JTextField();
		Font newTextFieldFont45=new Font(palabra4letra5.getFont().getName(),palabra4letra5.getFont().getStyle(),40);
		palabra4letra5.setFont(newTextFieldFont45);
		palabra4letra5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int keyCode = e.getKeyChar();
					//solo dejar que puedan escribir una letra en cada campo de texto
			        	if(palabra4letra5.getText().length()==1) {
				        	//solo dejar que puedan escribir una letra en cada campo de texto
						 	palabra4letra5.setEditable(false);
						}
				        if(keyCode == KeyEvent.VK_BACK_SPACE) {
				        	if(palabra4letra5.getText().length() == 0) {
				        		palabra4letra4.requestFocus();
				        	}
				        	if(!noborrar1) {
				        		palabra4letra5.setEditable(true);
					        	palabra4letra5.setText("");
				        	}
				        }
				        if(e.getKeyChar()=='\n') {
				        	try {
								metodos.ultimaLetraPalabra(3);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
			}
		});
		palabra4letra5.setColumns(10);
		palabra4letra5.setBounds(322, 260, 45, 62);
		contentPane.add(palabra4letra5);
		
		palabra5letra1 = new JTextField();
		Font newTextFieldFont51=new Font(palabra5letra1.getFont().getName(),palabra5letra1.getFont().getStyle(),40);
		palabra5letra1.setFont(newTextFieldFont51);
		palabra5letra1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra5letra1,palabra5letra1, palabra5letra2, noborrar5, e);
			}
		});
		palabra5letra1.setColumns(10);
		palabra5letra1.setBounds(60, 333, 45, 62);
		contentPane.add(palabra5letra1);
		
		palabra5letra2 = new JTextField();
		Font newTextFieldFont52=new Font(palabra5letra2.getFont().getName(),palabra5letra2.getFont().getStyle(),40);
		palabra5letra2.setFont(newTextFieldFont52);
		palabra5letra2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra5letra1,palabra5letra2, palabra5letra3, noborrar5, e);
			}
		});
		palabra5letra2.setColumns(10);
		palabra5letra2.setBounds(125, 333, 45, 62);
		contentPane.add(palabra5letra2);
		
		palabra5letra3 = new JTextField();
		Font newTextFieldFont53=new Font(palabra5letra3.getFont().getName(),palabra5letra3.getFont().getStyle(),40);
		palabra5letra3.setFont(newTextFieldFont53);
		palabra5letra3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra5letra2,palabra5letra3, palabra5letra4, noborrar5, e);
			}
		});
		palabra5letra3.setColumns(10);
		palabra5letra3.setBounds(191, 333, 45, 62);
		contentPane.add(palabra5letra3);
		
		palabra5letra4 = new JTextField();
		Font newTextFieldFont54=new Font(palabra5letra4.getFont().getName(),palabra5letra4.getFont().getStyle(),40);
		palabra5letra4.setFont(newTextFieldFont54);
		palabra5letra4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				metodos.configurarCampoDeTextoConEvento(palabra5letra3,palabra5letra4, palabra5letra5, noborrar5, e);
			}
		});
		palabra5letra4.setColumns(10);
		palabra5letra4.setBounds(257, 333, 45, 62);
		contentPane.add(palabra5letra4);
		
		palabra5letra5 = new JTextField();
		Font newTextFieldFont55=new Font(palabra5letra5.getFont().getName(),palabra5letra5.getFont().getStyle(),40);
		palabra5letra5.setFont(newTextFieldFont55);
		palabra5letra5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 int keyCode = e.getKeyChar();
					//solo dejar que puedan escribir una letra en cada campo de texto
			        	if(palabra5letra5.getText().length()==1) {
				        	//solo dejar que puedan escribir una letra en cada campo de texto
						 	palabra5letra5.setEditable(false);
						}
				        if(keyCode == KeyEvent.VK_BACK_SPACE) {
				        	if(palabra5letra5.getText().length() == 0) {
				        		palabra5letra4.requestFocus();
				        	}
				        	if(!noborrar1) {
				        		palabra5letra5.setEditable(true);
					        	palabra5letra5.setText("");
				        	}
				        }
				        if(e.getKeyChar()=='\n') {
				        	try {
								metodos.ultimaLetraPalabra(4);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
			}
		});
		
		palabra5letra5.setColumns(10);
		palabra5letra5.setBounds(322, 333, 45, 62);
		contentPane.add(palabra5letra5);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(32, 0, 372, 453);
		contentPane.add(panel);
		panel.setLayout(null);
		
		titulo = new JTextArea();
		titulo.setBounds(131, 11, 98, 21);
		panel.add(titulo);
		titulo.setFont(new Font("DejaVu Serif Condensed", Font.PLAIN, 13));
		titulo.setText("WORDLE IV\u00C1N");
		titulo.setEditable(false);
		
		errores = new JLabel("");
		errores.setBounds(32, 406, 310, 36);
		panel.add(errores);
		JButton botonPerfil_1 = new JButton("Pulsa para ir al perfil");
		
		botonPerfil_1.setBounds(32, 443, 372, 62);
		contentPane.add(botonPerfil_1);
		botonPerfil_1.setVisible(false);
		botonPerfil_1.setBackground(Color.GRAY);
		
	}
}
