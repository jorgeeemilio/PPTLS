package es.studium.Juego;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
public class SeleccionarNombre extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public SeleccionarNombre() {
		setIconImage(Vista.imgIcono);		
		setTitle("INTRODUCIR NOMBRE");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		setResizable(false);
		//JPanel del JFrame
		contentPane = new JPanel() {  
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {  
				g.drawImage(Vista.imgFondo, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		//Creamos el diálogo y los componentes del diálogo
		Vista.lbldSalirJuego = new JLabel ("¿Salir del juego?");
		Vista.dSalirJuego = new JDialog(this, "Salir", true);
		Vista.bSidSalirJuego = new JButton("Sí");
		Vista.bNodSalirJuego = new JButton("No");
		Vista.dSalirJuego.getContentPane().setLayout(new FlowLayout());
		Vista.dSalirJuego.getContentPane().add(Vista.lbldSalirJuego);
		Vista.dSalirJuego.setSize(270,90);
		Vista.dSalirJuego.setResizable(false);

		Vista.dSalirJuego.setLocationRelativeTo(null);
		Vista.dSalirJuego.getContentPane().add(Vista.bSidSalirJuego);
		Vista.dSalirJuego.getContentPane().add(Vista.bNodSalirJuego);

		//Le damos funcionalidad a la cruceta de la JFrame
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Vista.dSalirJuego.setVisible(true);
			}
		});
		Vista.dSalirJuego.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Vista.dSalirJuego.setVisible(false);
			}
		});
		Vista.bSidSalirJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Vista.bNodSalirJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vista.dSalirJuego.setVisible(false);
			}
		});


		//Label "INTRODUZCA SU NOMBRE:"
		Vista.lblIntroduzcaSuNombre = new JLabel("INTRODUZCA SU NOMBRE:");
		Vista.lblIntroduzcaSuNombre.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblIntroduzcaSuNombre.setForeground(Color.YELLOW);
		Vista.lblIntroduzcaSuNombre.setFont(new Font("Showcard Gothic", Font.BOLD, 14));
		Vista.lblIntroduzcaSuNombre.setBounds(-39, 30, 303, 73);
		contentPane.add(Vista.lblIntroduzcaSuNombre);

		//TextField donde se introduce el nombre
		Vista.textFieldNombre = new JTextField();
		Vista.textFieldNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		Vista.textFieldNombre.setBounds(256, 53, 150, 27);
		contentPane.add(Vista.textFieldNombre);
		Vista.textFieldNombre.setColumns(10);

		//Label con texto rojo de aviso
		Vista.lblMaxCaracteres = new JLabel("");
		Vista.lblMaxCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Vista.lblMaxCaracteres.setForeground(new Color(255, 0, 0));
		Vista.lblMaxCaracteres.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblMaxCaracteres.setBounds(256, 90, 150, 13);
		contentPane.add(Vista.lblMaxCaracteres);

		//Botón Continuar
		Vista.btnContinuarNombre = new JButton("CONTINUAR");
		Vista.btnContinuarNombre.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		Vista.btnContinuarNombre.setBackground(Color.YELLOW);
		Vista.btnContinuarNombre.setBounds(37, 147, 150, 56);
		contentPane.add(Vista.btnContinuarNombre);
		Vista.btnContinuarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Vista.textFieldNombre.getText().length()<9&&!Vista.textFieldNombre.getText().equals("")) {			
					Vista.nombreJugador= Vista.textFieldNombre.getText();
					dispose();
					PantallaJuego frame = new PantallaJuego();
					frame.setVisible(true);
				}
				if(Vista.textFieldNombre.getText().equals("")) {			
					Vista.lblMaxCaracteres.setText("El campo no puede estar vacío.");
				}
				else {Vista.lblMaxCaracteres.setText("Introduzca máximo 8 caracteres.");
				Vista.textFieldNombre.setText("");}
			}
		});

		//Botón Atrás
		Vista.btnAtrasNombre = new JButton("ATR\u00C1S");
		Vista.btnAtrasNombre.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		Vista.btnAtrasNombre.setBackground(Color.YELLOW);
		Vista.btnAtrasNombre.setBounds(245, 147, 150, 56);
		contentPane.add(Vista.btnAtrasNombre);
		Vista.btnAtrasNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuPrincipal	 frame = new MenuPrincipal();
				frame.setVisible(true);
			}
		});

	}
}