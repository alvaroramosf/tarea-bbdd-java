package aplicacion_bbdd;

import java.sql.*;
import java.util.*;

public class Principal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner (System.in);
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
			ResultSetMetaData  rmd = res.getMetaData();
			System.out.println(rmd.getColumnName(1) + " " + rmd.getColumnName(2));
				
			while (res.next()) {
				System.out.println(res.getInt(1) + " " + res.getString(2));
				}
					conexion.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();

				}finally {
					entrada.close();
				}

			}

		}




