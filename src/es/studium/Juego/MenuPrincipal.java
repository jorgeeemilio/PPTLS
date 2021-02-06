package es.studium.Juego;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("PPTLS!");
		setIconImage(Vista.imgIcono);
		setBounds(500, 300, 465, 309);
		setResizable(false);
		//Creamos el panel
		contentPane = new JPanel() {  
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {  
				g.drawImage(Vista.imgFondo, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		//Nombramos el diálogo y los componentes del diálogo
		Vista.lbldSalirJuego = new JLabel ("¿Salir del juego?");
		Vista.dSalirJuego = new JDialog(this, "Salir", true);
		Vista.bSidSalirJuego = new JButton("Sí");
		Vista.bNodSalirJuego = new JButton("No");
		Vista.dSalirJuego.setLayout(new FlowLayout());
		Vista.dSalirJuego.add(Vista.lbldSalirJuego);
		Vista.dSalirJuego.setSize(270,90);
		Vista.dSalirJuego.setResizable(false);
		Vista.dSalirJuego.setLocationRelativeTo(null);
		Vista.dSalirJuego.add(Vista.bSidSalirJuego);
		Vista.dSalirJuego.add(Vista.bNodSalirJuego);

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
				Vista.dSalirJuego.setVisible(true);
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

		//Botón Partida Nueva
		Vista.btnMenuPartidaNueva = new JButton("PARTIDA NUEVA");
		Vista.btnMenuPartidaNueva.setBackground(new Color(255, 255, 0));
		Vista.btnMenuPartidaNueva.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
		Vista.btnMenuPartidaNueva.setBounds(89, 45, 258, 52);
		contentPane.add(Vista.btnMenuPartidaNueva);
		Vista.btnMenuPartidaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SeleccionarNombre frame = new SeleccionarNombre();
				frame.setVisible(true);
			}
		});

		//Botón  Ranking
		Vista.btnMenuRanking = new JButton("RANKING");
		Vista.btnMenuRanking.setBackground(new Color(255, 255, 0));
		Vista.btnMenuRanking.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
		Vista.btnMenuRanking.setBounds(89, 107, 258, 52);
		contentPane.add(Vista.btnMenuRanking);
		Vista.btnMenuRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ranking frame = new Ranking();
				frame.setVisible(true);	
			}
		});

		//Botón Ayuda
		Vista.btnMenuAyuda = new JButton("AYUDA");
		Vista.btnMenuAyuda.setBackground(new Color(255, 255, 0));
		Vista.btnMenuAyuda.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
		Vista.btnMenuAyuda.setBounds(89, 169, 258, 52);
		contentPane.add(Vista.btnMenuAyuda);
		Vista.btnMenuAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Ayuda();

			}
		});

	}


}