package es.studium.Juego;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Modelo {

 

    public static void ConectarABaseDatos() {
    	try
		{
			Class.forName(Vista.driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Se ha producido un error al cargar el Driver");
		}
		try
		{
			Vista.connection = DriverManager.getConnection(Vista.url, Vista.login, Vista.password);
		}
		catch(SQLException e)
		{
			System.out.println("Se produjo un error al conectar a la Base de Datos");
		}

}}
