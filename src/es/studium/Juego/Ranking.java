package es.studium.Juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Ranking extends JFrame {
	private JPanel contentPane;
	private JPanel contentPane2;
	private static final long serialVersionUID = 1L;
	public Ranking() {
		setIconImage(Vista.imgIcono);
		setTitle("RANKING");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 200, 450, 500);
		setResizable(false);
		//JPanel del JFrame
		contentPane = new JPanel() {  
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {  	
				g.drawImage(Vista.imgFondo, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		//Label "RANKING"
		Vista.lblRanking = new JLabel("RANKING");
		Vista.lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblRanking.setForeground(Color.YELLOW);
		Vista.lblRanking.setFont(new Font("Showcard Gothic", Font.BOLD, 24));
		Vista.lblRanking.setBounds(145, -27, 131, 97);
		contentPane.add(Vista.lblRanking);
		
		//JPanel donde vamos a poner una foto para poner detras de los textAreas de las puntuaciones y hacerlo más estético creando un efecto de borde
		contentPane2 = new JPanel() {  
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						PantallaJuego.class.getResource("oro.png"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		contentPane2.setBackground(new Color(238, 130, 238));
		contentPane2.setBounds(10, 33, 220, 420);
		contentPane.add(contentPane2);
		contentPane2.setLayout(null);
		
		//TextArea con los nombres del top 10 y sus métodos para la conexión a la BD
		Vista.txtAreaRanking1 = new JTextArea();
		Vista.txtAreaRanking1.setBackground(new Color(255, 255, 0));
		Vista.txtAreaRanking1.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		Vista.txtAreaRanking1.setBounds(5, 5, 126, 410);
		Modelo.ConectarABaseDatos();
		Controlador.consultaRankingNombre(Vista.txtAreaRanking1);
		contentPane2.add(Vista.txtAreaRanking1);
		
		//TextArea con las puntuaciones de los top 10 y sus métodos para la conexión a la BD
		Vista.txtAreaRanking2 = new JTextArea();
		Vista.txtAreaRanking2.setBackground(new Color(255, 255, 0));
		Vista.txtAreaRanking2.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		Vista.txtAreaRanking2.setBounds(131, 5, 84, 410);
		Controlador.consultaRankingPuntos(Vista.txtAreaRanking2);
		Vista.txtAreaRanking2.setEditable(false);
		Vista.txtAreaRanking1.setEditable(false);
		contentPane2.add(Vista.txtAreaRanking2);
		
		//Botón Atrás
		Vista.btnAtrasRanking = new JButton("ATR\u00C1S");
		Vista.btnAtrasRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
			}
		});
		Vista.btnAtrasRanking.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
		Vista.btnAtrasRanking.setBackground(Color.YELLOW);
		Vista.btnAtrasRanking.setBounds(256, 220, 149, 45);
		contentPane.add(Vista.btnAtrasRanking);
	}
}