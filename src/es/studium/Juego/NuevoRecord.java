package es.studium.Juego;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class NuevoRecord extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public NuevoRecord() {
		setTitle("NUEVO R\u00C9CORD!");
		setIconImage(Vista.imgIcono);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(540, 320, 352, 226);
		setResizable(false);

		//Panel de la pantalla Nuevo Récord
		contentPane = new JPanel(){  
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {  		
				g.drawImage(Vista.imgFondo, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);	
		setContentPane(contentPane);
		
		
		
		//Botón Ok
		Vista.btnOkRecord = new JButton("OK");
		Vista.btnOkRecord.setFont(new Font("Showcard Gothic", Font.BOLD, 16));
		Vista.btnOkRecord.setBackground(Color.YELLOW);
		Vista.btnOkRecord.setBounds(246, 134, 92, 45);
		contentPane.add(Vista.btnOkRecord);
		Vista.btnOkRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//Label "Nuevo Récord"
		Vista.lblNuevoRecord = new JLabel("NUEVO R\u00C9CORD");
		Vista.lblNuevoRecord.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblNuevoRecord.setForeground(Color.YELLOW);
		Vista.lblNuevoRecord.setFont(new Font("Showcard Gothic", Font.BOLD, 37));
		Vista.lblNuevoRecord.setBounds(10, 71, 323, 97);
		contentPane.add(Vista.lblNuevoRecord);
		
		//Label con la puntuación del nuevo récord y el método para acceder a dicha puntuación
		Vista.lblPuntosRecord = new JLabel(String.valueOf(Vista.numeroPuntos));
		Vista.lblPuntosRecord.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblPuntosRecord.setForeground(Color.YELLOW);
		Vista.lblPuntosRecord.setFont(new Font("Showcard Gothic", Font.BOLD, 77));
		Vista.lblPuntosRecord.setBounds(-27, 11, 184, 103);
		contentPane.add(Vista.lblPuntosRecord);
		
		//Label con el nombre del que ha establecido el nuevo récord
		Vista.lblNombreRecord = new JLabel(Vista.nombreJugador);
		Vista.lblNombreRecord.setHorizontalAlignment(SwingConstants.CENTER);
		Vista.lblNombreRecord.setForeground(Color.YELLOW);
		Vista.lblNombreRecord.setFont(new Font("Showcard Gothic", Font.BOLD, 19));
		Vista.lblNombreRecord.setBounds(99, 25, 209, 45);
		contentPane.add(Vista.lblNombreRecord);
		
		//Método del sónido de nuevo récord
		Controlador.ReproducirSonido("src/victoria.wav");
	}
}