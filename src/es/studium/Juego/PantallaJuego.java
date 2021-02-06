package es.studium.Juego;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaJuego extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public PantallaJuego() {
		setIconImage(Vista.imgIcono);
		setTitle("PARTIDA");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(220, 60, 1079, 751);
		setResizable(false);
		
		//Panel de la pantalla del Juego
		contentPane =new JPanel() {  
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {  
				g.drawImage(Vista.imgFondo, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		setContentPane(contentPane);
		//Creamos el diálogo que nos lleva al Menú Principal MP  y los componentes del diálogo
		
		Vista.lbldSalirMP = new JLabel ("¿Volver al menú principal? Perderás todo el progreso.");
		Vista.dSalirMP = new JDialog(this, "Salir", true);
		Vista.bSidSalirMP = new JButton("Sí");
		Vista.bNodSalirMP = new JButton("No");
		Vista.dSalirMP.setLayout(new FlowLayout());
		Vista.dSalirMP.add(Vista.lbldSalirMP);
		Vista.dSalirMP.setSize(320,90);
		Vista.dSalirMP.setResizable(false);
		Vista.dSalirMP.setLocationRelativeTo(null);
		Vista.dSalirMP.add(Vista.bSidSalirMP);
		Vista.dSalirMP.add(Vista.bNodSalirMP);

		//Le damos funcionalidad a la cruceta de la JFrame
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Vista.dSalirJuego.setVisible(true);
			}
		});
		//Le damos funcionalidad a los botones y a la cruceta del diálogo
		Vista.dSalirMP.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Vista.dSalirMP.setVisible(false);
			}
		});
		Vista.bSidSalirMP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				IniciarJuego.main(null);
			}
		});
		Vista.bNodSalirMP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vista.dSalirMP.setVisible(false);
			}
		});

		
		//Creamos el diálogo y los componentes del diálogo
				Vista.lbldSalirJuego = new JLabel ("¿Salir del juego?");
				Vista.dSalirJuego = new JDialog(this, "Salir", true);
				Vista.bSidSalirJuego = new JButton("Sí");
				Vista.bNodSalirJuego = new JButton("No");
				Vista.dSalirJuego.setLayout(new FlowLayout());
				Vista.dSalirJuego.add(Vista.lbldSalirJuego);
				Vista.dSalirJuego.setSize(270,90);
				Vista.dSalirJuego.setLocationRelativeTo(null);
				Vista.dSalirJuego.add(Vista.bSidSalirJuego);
				Vista.dSalirJuego.add(Vista.bNodSalirJuego);

				
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
		
		//Label "Elige tu opción"
		Vista.lblEligeOpcionJuego = new JLabel("ELIGE TU OPCI\u00D3N:");
		Vista.lblEligeOpcionJuego.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblEligeOpcionJuego.setFont(new Font("Showcard Gothic", Font.BOLD, 37));
		Vista.lblEligeOpcionJuego.setForeground(new Color(255, 255, 0));
		Vista.lblEligeOpcionJuego.setBounds(46, 266, 348, 97);
		contentPane.add(Vista.lblEligeOpcionJuego);

		//Label "Marcador"
		Vista.marcador = new JLabel("0");
		Vista.marcador.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.marcador.setForeground(Color.YELLOW);
		Vista. marcador.setFont(new Font("Showcard Gothic", Font.BOLD, 75));
		Vista.marcador.setBounds(391, 46, 101, 97);
		contentPane.add(Vista.marcador);

		//Label "Puntuación"
		Vista.lblPuntuacionJuego = new JLabel("PUNTUACI\u00D3N:");
		Vista.lblPuntuacionJuego.setHorizontalAlignment(SwingConstants.LEFT);
		Vista.lblPuntuacionJuego.setForeground(Color.YELLOW);
		Vista.lblPuntuacionJuego.setFont(new Font("Showcard Gothic", Font.BOLD, 37));
		Vista.lblPuntuacionJuego.setBounds(59, 46, 362, 97);
		contentPane.add(Vista.lblPuntuacionJuego);

		//Label "Vidas"
		Vista.lblVidas = new JLabel("VIDAS:");
		Vista.lblVidas.setHorizontalAlignment(SwingConstants.LEFT);
		Vista.lblVidas.setForeground(Color.YELLOW);
		Vista.lblVidas.setFont(new Font("Showcard Gothic", Font.BOLD, 37));
		Vista.lblVidas.setBounds(59, 149, 160, 97);
		contentPane.add(Vista.lblVidas);

		//Labels para cada una de las vidas
		Vista.lblVida1 = new JLabel("");
		Vista.lblVida1.setIcon(new ImageIcon(Vista.imgC));
		Vista.lblVida1.setBounds(230, 153, 80, 70);
		contentPane.add(Vista.lblVida1);
		Vista.lblVida2 = new JLabel("");
		Vista.lblVida2.setIcon(new ImageIcon(Vista.imgC));
		Vista.lblVida2.setBounds(320, 153, 80, 70);
		contentPane.add(Vista.lblVida2);
		Vista.lblVida3 = new JLabel("");
		Vista.lblVida3.setBounds(410, 153, 80, 70);
		Vista.lblVida3.setIcon(new ImageIcon(Vista.imgC));
		contentPane.add(Vista.lblVida3);
		Vista.lblVida4 = new JLabel("");
		Vista.lblVida4.setIcon(new ImageIcon(Vista.imgC));
		Vista.lblVida4.setBounds(500, 153, 80, 70);
		contentPane.add(Vista.lblVida4);	

		//Label con la opción que ha seleccionado el jugador
		Vista.lblJugadorOpcion = new JLabel("");
		Vista.lblJugadorOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblJugadorOpcion.setBounds(576, 397, 175, 174);
		contentPane.add(Vista.lblJugadorOpcion);

		//Label con la opción que ha generado el CPU aleatoriamente
		Vista.lblCPUOpcion = new JLabel("");
		Vista.lblCPUOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblCPUOpcion.setBounds(793, 397, 175, 174);
		contentPane.add(Vista.lblCPUOpcion);

		//Label con el nombre que ha seleccionado el jugador previamente
		Vista.lblEleccionJugador = new JLabel(Vista.nombreJugador);
		Vista.lblEleccionJugador.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblEleccionJugador.setForeground(Color.YELLOW);
		Vista.lblEleccionJugador.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
		Vista.lblEleccionJugador.setBounds(557, 328, 222, 97);
		contentPane.add(Vista.lblEleccionJugador);

		//Label del nombre del cpu "CPU"
		Vista.lblCPUJuego = new JLabel("CPU");
		Vista.lblCPUJuego.setHorizontalAlignment(SwingConstants.LEFT);
		Vista.lblCPUJuego.setForeground(Color.YELLOW);
		Vista.lblCPUJuego.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
		Vista.lblCPUJuego.setBounds(847, 328, 160, 97);
		contentPane.add(Vista.lblCPUJuego);

		//Botón Papel
		Vista.btnPapel = new JButton("");
		Vista.btnPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.rondaPPTLS(2);
				if(Vista.numeroVidas==0) {dispose();}
			}});
		Vista.btnPapel.setBackground(new Color(255, 255, 0));
		Vista.btnPapel.setBounds(182, 539, 110, 110);
		Vista.btnPapel.setIcon(new ImageIcon(Vista.imgPapel));
		contentPane.add(Vista.btnPapel);

		//Botón Spock
		Vista.btnSpock = new JButton("");
		Vista.btnSpock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.rondaPPTLS(5);
				if(Vista.numeroVidas==0) {dispose();}
			}});
		Vista.btnSpock.setBackground(Color.magenta);
		Vista.btnSpock.setBounds(50, 539, 110, 110);
		Vista.btnSpock.setIcon(new ImageIcon(Vista.imgSpock));
		contentPane.add(Vista.btnSpock);

		//Botón Lagarto
		Vista.btnLagarto = new JButton("");
		Vista.btnLagarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.rondaPPTLS(4);
				if(Vista.numeroVidas==0) {dispose();}
			}});
		Vista.btnLagarto.setBackground(Color.RED);
		Vista.btnLagarto.setBounds(314, 539, 110, 110);
		Vista.btnLagarto.setIcon(new ImageIcon(Vista.imgLagarto));
		contentPane.add(Vista.btnLagarto);

		//Botón Piedra
		Vista.btnPiedra = new JButton("");
		Vista.btnPiedra.setBackground(new Color(220, 220, 220));
		Vista.btnPiedra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Controlador.rondaPPTLS(1);		
				if(Vista.numeroVidas==0) {dispose();}
			}
		});
		Vista.btnPiedra.setIcon(new ImageIcon(Vista.imgPiedra));
		Vista.btnPiedra.setBounds(114, 410, 110, 110);
		contentPane.add(Vista.btnPiedra);

		//Botón Tijeras
		Vista.btnTijera = new JButton("");
		Vista.btnTijera.setBackground(Color.WHITE);
		Vista.btnTijera.setIcon(new ImageIcon(Vista.imgTijeras));
		Vista.btnTijera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.rondaPPTLS(3);
				if(Vista.numeroVidas==0) {dispose();}
			}
		});
		Vista.btnTijera.setBounds(246, 410, 110, 110);
		contentPane.add(Vista.btnTijera);

		//Label con el resultado de cada ronda(empate,victora para el jugador o victoria para el CPU);
		Vista.resultado = new JLabel("");
		Vista.resultado.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.resultado.setForeground(Color.YELLOW);
		Vista.resultado.setFont(new Font("Showcard Gothic", Font.BOLD, 37));
		Vista.resultado.setBounds(530, 112, 525, 115);
		contentPane.add(Vista.resultado);

		//Botón Salir
		Vista.btnSalirJuego = new JButton("SALIR");
		Vista.btnSalirJuego.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		Vista.btnSalirJuego.setBackground(Color.YELLOW);
		Vista.btnSalirJuego.setBounds(810, 46, 150, 56);
		contentPane.add(Vista.btnSalirJuego);
		Vista.btnSalirJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Vista.dSalirMP.setVisible(true);
				Vista.numeroVidas=4;
				Vista.numeroPuntos=0;
				Vista.nombreJugador="";	
			}
		});

	}
}