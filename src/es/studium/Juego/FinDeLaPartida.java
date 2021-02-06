package es.studium.Juego;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FinDeLaPartida extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public FinDeLaPartida() {
		setResizable(false);
		setTitle("FIN DEL JUEGO");
		setIconImage(Vista.imgIcono);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		setResizable(false);
		contentPane = new JPanel(){  
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {  
				g.drawImage(Vista.imgFondo, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos el windowClosing de la JFrame
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Vista.dSalirJuego.setVisible(true);
			}
		});
		//Creamos el diálogo y los componentes del diálogo
		Vista.lbldSalirJuego = new JLabel ("¿Salir del juego?");
		Vista.dSalirJuego = new JDialog(this, "Salir", true);
		Vista.bSidSalirJuego = new JButton("Sí");
		Vista.bNodSalirJuego = new JButton("No");
		Vista.dSalirJuego.getContentPane().setLayout(new FlowLayout());
		Vista.dSalirJuego.getContentPane().add(Vista.lbldSalirJuego);
		Vista.dSalirJuego.setSize(270,90);
		Vista.dSalirJuego.setLocationRelativeTo(null);
		Vista.dSalirJuego.getContentPane().add(Vista.bSidSalirJuego);
		Vista.dSalirJuego.getContentPane().add(Vista.bNodSalirJuego);

		
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
		 Vista.btnMenuPrincipalFinJuego = new JButton("VOLVER AL MENU PRINCIPAL");
		Vista.btnMenuPrincipalFinJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				MenuPrincipal	 frame = new MenuPrincipal();
				frame.setVisible(true);
				Vista.numeroVidas=4;
				Vista.numeroPuntos=0;
				Vista.nombreJugador="";	
			}
		});
		Vista.btnMenuPrincipalFinJuego.setFont(new Font("Showcard Gothic", Font.BOLD, 10));
		Vista.btnMenuPrincipalFinJuego.setBackground(Color.YELLOW);
		Vista.btnMenuPrincipalFinJuego.setBounds(10, 161, 211, 45);
		contentPane.add(Vista.btnMenuPrincipalFinJuego);
		 Vista.btnNuevaPartidaFinJuego = new JButton("NUEVA PARTIDA");
		Vista.btnNuevaPartidaFinJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SeleccionarNombre	 frame = new SeleccionarNombre();
				frame.setVisible(true);
				Vista.numeroVidas=4;
				Vista.numeroPuntos=0;
				Vista.nombreJugador="";
			}
		});
		Vista.btnNuevaPartidaFinJuego.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
		Vista.btnNuevaPartidaFinJuego.setBackground(Color.YELLOW);
		Vista.btnNuevaPartidaFinJuego.setBounds(231, 160, 182, 45);
		contentPane.add(Vista.btnNuevaPartidaFinJuego);
		 Vista.lblGameOver = new JLabel("GAME OVER");
		Vista.lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblGameOver.setForeground(Color.YELLOW);
		Vista.lblGameOver.setFont(new Font("Showcard Gothic", Font.BOLD, 37));
		Vista.lblGameOver.setBounds(70, 0, 269, 97);
		contentPane.add(Vista.lblGameOver);
		 Vista.lblSuPuntuacionEs = new JLabel("SU PUNTUACI\u00D3N HA SIDO:");
		Vista.lblSuPuntuacionEs.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblSuPuntuacionEs.setForeground(Color.YELLOW);
		Vista.lblSuPuntuacionEs.setFont(new Font("Showcard Gothic", Font.BOLD, 15));
		Vista.lblSuPuntuacionEs.setBounds(-14, 78, 303, 73);
		contentPane.add(Vista.lblSuPuntuacionEs);
		JLabel marcador = new JLabel(String.valueOf(Vista.numeroPuntos));
		marcador.setHorizontalAlignment(SwingConstants.CENTER);
		marcador.setForeground(Color.YELLOW);
		marcador.setFont(new Font("Showcard Gothic", Font.BOLD, 75));
		marcador.setBounds(262, 67, 101, 97);
		contentPane.add(marcador);
	}
}