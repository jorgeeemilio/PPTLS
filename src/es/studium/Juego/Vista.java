package es.studium.Juego;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Vista extends JFrame {
	public Vista() {
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//JDialogSalirDelJuego
	static JDialog dSalirJuego;
	static JLabel lbldSalirJuego;
	static JButton bSidSalirJuego;
	static JButton bNodSalirJuego;
	

	//JDialogVolverMP
	static JDialog dSalirMP;
	static JLabel lbldSalirMP;
	static JButton bSidSalirMP;
	static JButton bNodSalirMP;
	
	//MenuPrincipal
	
	static JButton btnMenuPartidaNueva;
	static JButton btnMenuRanking;
	static JButton btnMenuAyuda;
	
	//Ranking
	
	static JDialog dSalirR;
	static JLabel lblSalirR;
	static JButton bSiSalirR;
	static JButton bNoSalirR;
	
	static JLabel lblRanking;

	static JTextArea txtAreaRanking1;
	static  JTextArea txtAreaRanking2;
	static JButton btnAtrasRanking;
	
	//PantallaConfirmaciónAbandonarPartida
	
	
	//PantallaFinPartida
	
	static JButton btnMenuPrincipalFinJuego;
	static JButton btnNuevaPartidaFinJuego;
	static JLabel lblGameOver;
	static JLabel lblSuPuntuacionEs;
	static JLabel marcadorFinJuego;
	//Seleccionar Nombre
	
	static JLabel lblIntroduzcaSuNombre;
	static String nombreJugador;
	static JTextField textFieldNombre;
	static JButton btnContinuarNombre;
	static JButton btnAtrasNombre;
	static JLabel lblMaxCaracteres;
	//Pantalla Nuevo Récord
	static JButton btnOkRecord;
	static JLabel lblNuevoRecord;
	static JLabel lblPuntosRecord;
	static JLabel lblNombreRecord;
	//Pantalla del juego
	static JFrame frameJuego;
	static JLabel lblVidas;
	static JLabel marcador;
	static int numeroVidas=4;
	static int numeroPuntos=0;
	static JLabel lblJugadorOpcion;
	static JLabel resultado;
	static JLabel lblCPUOpcion;
	static int record=0;
	static JLabel lblEligeOpcionJuego;
	static JLabel lblPuntuacionJuego;
	static JLabel lblCPUJuego;
	static JButton btnSalirJuego;

	
	static JLabel lblConfirmacionSalir;
	static JButton btnConfirmacionVolver;
	static JButton btnConfirmacionSalir;
	static JLabel lblAvisoConfirmacion;
	static JLabel lblVida1;
	static JLabel lblVida2;
	static JLabel lblVida3;
	static JLabel lblVida4;
	static JLabel lblEleccionJugador;
	static JButton btnTijera; 
	static JButton btnPapel;
	static JButton btnPiedra;
	static JButton btnLagarto;
	static JButton btnSpock;
	//Metodos
	static int valorRandom;
	//Imagenes

	static Image imgIcono=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("icono.png"));  
	static Image imgPiedra=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("piedra.png"));  
	static Image imgLagarto=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("lagarto.png"));  
	static Image imgPapel=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("papel.png"));  
	static Image imgTijeras=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("tijeras.png"));  
	static Image imgSpock=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("spock.png"));  
	static Image imgC=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("corazon.png"));  
	static Image imgX=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("cruceta.png"));  
	static Image imgFondo=Toolkit.getDefaultToolkit().getImage(  
			PantallaJuego.class.getResource("fondoPantalla.jpg"));  

	//Conexion MySQL
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/Juego?useSSL=false";
	static String login = "root";
	static String password = "Studium2019;";
	static String sentencia = "SELECT * FROM jugadores";
	static	Connection connection = null;
	static Statement statement = null;
	static ResultSet rs = null;
	//Sonido 
	static AudioInputStream audioInputStream;
	static Clip clip;
	// Help
	static String ayudaNombre="\n-En esta ventana vamos a seleccionar el nombre del jugador con el que te encontrarán si entras en el Ranking!\n"
			+ "-Recuerda que el campo no puede estar vacío ni superar los 8 caracteres.";
	static String ayudaJuego="\n-PPTLS consiste en conseguir la máxima punutuación posible. Tienes cinco opciones: piedra,papel,tijeras,lagarto o Spock."
			+ "\nEl CPU responderá con una de esas opciones aleatoriamente. Y dependiento del resultado puedes ganar un punto o perder una vida. El orden es el siguiente:\n"
			+ "-Tijera corta a papel, papel tapa a piedra, piedra aplasta a lagarto, lagarto envenena a Spock, Spock rompe a tijera, tijera decapita a lagarto, lagarto devora a papel, papel desautoriza a Spock, Spock vaporiza a piedra, y como siempre, piedra aplasta a tijera."
			+ "\nSi hay empate, no se perderá vida ni se ganará punto. Tienes 4 vidas al comienzo de la partida. Si llegas a 0 vidas se acabará el juego."
			+ "Si pulsas en el botón 'Salir' volverás al menú principal y perderás el avance de la partida."
			+ "";
	static String ayudaRanking= new String("\n-El ranking está formado por los 10 jugadores con las puntuaciones más altas. Si hay empate a puntos el jugador que haya logrado primero esa puntuación irá por delante del segundo.");

}
