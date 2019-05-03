package pe.uni.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/semana01", "root", "admin");
			
		} catch (Exception e) {
			System.out.print(e.getMessage());			
		}
		return conexion;
	}
	
}
