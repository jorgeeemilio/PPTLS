package es.studium.Juego;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Controlador {
	public static  void rondaPPTLS(int numero){	

		/*Generaremos un random que genere un número entre el 1 y el 5.
	Dependiendo de el valor tendremos nuestro resultado, siendo los valores los siguientes:
	-Piedra=1
	-Papel =2
	-Tijeras=3
	-Lagarto=4
	-Spock=5*/

		Vista.valorRandom =  (int) (Math.random()*5+1);
		//Recorreremos las diferentes posibilidades.
		if(numero==1&&Vista.valorRandom==1) {
			try {
				ReproducirSonido("src/empata.wav");
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
				Vista.resultado.setText("EMPATE");
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {			
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		if(numero==1&&Vista.valorRandom==2) {
			try {

				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.resultado.setText("GANA EL CPU!");
			Vista.numeroVidas--;
		}
		if(numero==1&&Vista.valorRandom==3) {
			try {	
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {			
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.numeroPuntos++;
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");		
		}
		if(numero==1&&Vista.valorRandom==4) {
			try {
				Vista.numeroPuntos++;
				Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
				ReproducirSonido("src/gana.wav");
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
				Vista.resultado.setText("GANA EL JUGADOR!");
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {			
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		if(numero==1&&Vista.valorRandom==5) {
			try {

				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.resultado.setText("GANA EL CPU!");
			Vista.numeroVidas--;
		}
		if(numero==2&&Vista.valorRandom==1) {
			try {	
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.numeroPuntos++;
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");			
		}
		if(numero==2&&Vista.valorRandom==2) {
			try {
				ReproducirSonido("src/empata.wav");
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPapel));
				Vista.resultado.setText("EMPATE");
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		if(numero==2&&Vista.valorRandom==3) {		
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {			
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.numeroVidas--;
			Vista.resultado.setText("GANA EL CPU!");
		}
		if(numero==2&&Vista.valorRandom==4) {		
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {			
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.numeroVidas--;
			Vista.resultado.setText("GANA EL CPU!");
		}
		if(numero==2&&Vista.valorRandom==5) {
			try {	
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.numeroPuntos++;
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");			
		}
		if(numero==3&&Vista.valorRandom==1) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.numeroVidas--;
			Vista.resultado.setText("GANA EL CPU!");
		}
		if(numero==3&&Vista.valorRandom==2) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}Vista.numeroPuntos++;
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");		
		}
		if(numero==3&&Vista.valorRandom==3) {
			try {
				ReproducirSonido("src/empata.wav");
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
				Vista.resultado.setText("EMPATE");
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		if(numero==3&&Vista.valorRandom==4) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}Vista.numeroPuntos++;
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");		
		}
		if(numero==3&&Vista.valorRandom==5) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.numeroVidas--;
			Vista.resultado.setText("GANA EL CPU!");
		}
		if(numero==4&&Vista.valorRandom==1) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.numeroVidas--;
			Vista.resultado.setText("GANA EL CPU!");
		}
		if(numero==4&&Vista.valorRandom==2) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
			} catch (Exception ex) {
				System.out.println(ex);
			}Vista.numeroPuntos++;
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");		
		}
		if(numero==4&&Vista.valorRandom==3) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.numeroVidas--;
			Vista.resultado.setText("GANA EL CPU!");
		}
		if(numero==4&&Vista.valorRandom==4) {
			try {
				ReproducirSonido("src/empata.wav");
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
				Vista.resultado.setText("EMPATE");
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		if(numero==4&&Vista.valorRandom==5) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
			} catch (Exception ex) {
				System.out.println(ex);
			}Vista.numeroPuntos++;
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");		
		}
		if(numero==5&&Vista.valorRandom==1) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPiedra));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}Vista.numeroPuntos++;
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");		
		}
		if(numero==5&&Vista.valorRandom==2) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgPapel));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.numeroVidas--;
			Vista.resultado.setText("GANA EL CPU!");
		}
		if(numero==5&&Vista.valorRandom==3) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgTijeras));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {		
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}Vista.numeroPuntos++;
			Vista.resultado.setText("GANA EL JUGADOR!");
			Vista.marcador.setText((String.valueOf(Vista.numeroPuntos)));
			ReproducirSonido("src/gana.wav");		
		}
		if(numero==5&&Vista.valorRandom==4) {
			try {			
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgLagarto));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			ReproducirSonido("src/pierde.wav");
			Vista.numeroVidas--;
			Vista.resultado.setText("GANA EL CPU!");
		}
		if(numero==5&&Vista.valorRandom==5) {
			try {
				ReproducirSonido("src/empata.wav");
				Vista.lblCPUOpcion.setIcon(new ImageIcon(Vista.imgSpock));
				Vista.resultado.setText("EMPATE");
			} catch (Exception ex) {
				System.out.println(ex);
			}
			try {				
				Vista.lblJugadorOpcion.setIcon(new ImageIcon(Vista.imgSpock));
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		/*Ahora vamos a ver el funcionamiento de las vidas, como cambian los corazones
		  a crucetas cada vez que se pierde una vida,  y la actualización en la
		base de datos cuando se acabe la partida ( nVidas = 0)*/
		int vidas= Vista.numeroVidas;
		switch(vidas)
		{  
		case 0 :
			//Si las vidas llegan a 0 se acaba la partida y se desactivan los botones

			Vista.lblVida1.setIcon(new ImageIcon(Vista.imgX));

			Vista.btnPapel.setEnabled(false);
			Vista.btnPiedra.setEnabled(false);
			Vista.btnTijera.setEnabled(false);
			Vista.btnSpock.setEnabled(false);
			Vista.btnLagarto.setEnabled(false);

			//Abrimos el frame de Fin De La Partida
			FinDeLaPartida frame2 = new FinDeLaPartida();
			frame2.setVisible(true);			

			//Ahora en caso de que hayamos llegado al record se nos abrirá otra ventana
			Modelo.ConectarABaseDatos();
			try 
			{
				Statement statement2 =Vista.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet	rs=statement2.executeQuery("SELECT* FROM  jugadores ORDER BY puntosJugador DESC LIMIT 1" );
				if(rs.next())
				{
					Vista.record=Integer.parseInt(rs.getString("puntosJugador"));}

				//Si la puntuación es superior al récord actual, habremos batido el récord
				if(Vista.numeroPuntos>Vista.record) {
					NuevoRecord	 frame1 = new NuevoRecord();
					frame1.setVisible(true);}
			} catch (SQLException e) {
				e.printStackTrace();
			}try 
			{
				String nombre= Vista.nombreJugador.toString();
				Vista.statement =Vista.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				Vista.statement.executeUpdate("INSERT INTO jugadores VALUES (null,'"+nombre+"','"+String.valueOf(Vista.numeroPuntos)+"')");
			} catch (SQLException e) {
				e.printStackTrace();
			}											
			break;    
		case 1 :
			try {					
				Vista.lblVida2.setIcon(new ImageIcon(Vista.imgX));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			break; 
		case 2 :
			try {								
				Vista.lblVida3.setIcon(new ImageIcon(Vista.imgX));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			break;			
		case 3 :
			try {					
				Vista.lblVida4.setIcon(new ImageIcon(Vista.imgX));
			} catch (Exception ex) {
				System.out.println(ex);
			}		      
		}  	 
	}	      	
	//Método para obtener el nombre de los 10 jugadores con la mejor puntuación en orden descendente e imprimirlos en un TextArea
	public static  void consultaRankingNombre(JTextArea textArea){

		try
		{
			Vista.statement =Vista.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			Vista.rs=Vista.statement.executeQuery("SELECT* FROM  jugadores ORDER BY puntosJugador DESC  LIMIT 10" );
			int n= 1;
			while(Vista.rs.next())
			{
				textArea.append("\n    "+n+"."+Vista.rs.getString("nombreJugador")+"\n");
				n ++;
			}
		}
		catch(SQLException e)
		{
			System.out.println("Se produjo un error al conectar a la Base de Datos");
		}
	}

	//Método para obtener la puntuación de los 10 mejores jugadores en orden descendente e imprimirlos en un TextArea

	public static  void consultaRankingPuntos(JTextArea textArea){

		try
		{
			Vista.statement =Vista.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			Vista.rs=Vista.statement.executeQuery("SELECT* FROM  jugadores ORDER BY puntosJugador DESC LIMIT 10" );
			while(Vista.rs.next())
			{
				textArea.append("\n    "+Vista.rs.getString("puntosJugador")+"\n");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Se produjo un error al conectar a la Base de Datos");
		}
	}

	//Método para reproducir sonido
	public static void ReproducirSonido(String nombreSonido){
		try {
			Vista.audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
			Vista.clip = AudioSystem.getClip();
			Vista.clip.open(Vista.audioInputStream);
			Vista.clip.start();
		} catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error al reproducir el sonido.");
		}}
}
