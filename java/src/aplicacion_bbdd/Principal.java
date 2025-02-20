package aplicacion_bbdd;

import java.sql.*;
import java.util.*;

public class Principal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		String bbdd = "equipo_colegio";
		String user = "root";
		String pwd = "";
		String server = "jdbc:mysql://localhost:3306/";
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection(server + bbdd, user, pwd);

			String consulta = "SELECT * FROM alumnos";
			PreparedStatement ps = conexion.prepareStatement(consulta);
			ResultSet res = ps.executeQuery();
			ResultSetMetaData rmd = res.getMetaData();

			System.out.printf("%8s%25s%25s%25s%25s%n", rmd.getColumnName(1), rmd.getColumnName(2), rmd.getColumnName(3), rmd.getColumnName(4),rmd.getColumnName(5));

			for (int i = 0; i < 4 + 25 + 25 + 25 + 30; i++)
				System.out.printf("=");
			System.out.println();
			
			while (res.next()) {
                System.out.printf("%8s%25s%25s%25s%25s%n", res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5));			}
			conexion.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		}

	}

}
