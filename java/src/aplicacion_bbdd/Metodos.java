package aplicacion_bbdd;

import java.sql.*;

public class Metodos {
	static String bbdd = "equipo_colegio";
	static String user = "root";
	static String pwd = "";
	static String server = "jdbc:mysql://localhost:3306/";
	static Connection conexion = null;

	public static void mostrarDatosAlumnos() {
		String consulta = "SELECT nif AS 'NIF Alumno', apenom AS Nombre, direc AS Dirección, pobla AS Población, telef AS Teléfono FROM alumnos";
		mostrarDatos(consulta);
	}

	public static void mostrarDatosAsignaturas() {
		String consulta = "SELECT cod AS Código, nombre AS Nombre, nif_profesor as 'NIF Profesor' FROM asignaturas";
		mostrarDatos(consulta);
	}

	public static void mostrarDatosNotas() {
		String consulta = "SELECT nif AS 'NIF Alumno', cod_asignatura AS 'Código Asignatura', nota AS Notas FROM notas";
		mostrarDatos(consulta);
	}

	public static void mostrarDatosProfesores() {
		String consulta = "SELECT nif AS 'NIF Profesor', apenom AS Nombre, direc AS Dirección, pobla AS Población, telef AS Teléfono FROM profesores";
		mostrarDatos(consulta);
	}

	static void mostrarDatos(String consulta) {
		try {
			conexion = DriverManager.getConnection(server + bbdd, user, pwd);
			PreparedStatement ps = conexion.prepareStatement(consulta);
			ResultSet res = ps.executeQuery();
			ResultSetMetaData rmd = res.getMetaData();

			for (int i = 1; i <= rmd.getColumnCount(); i++) {
				System.out.printf("%25s", rmd.getColumnLabel(i));
			}
			System.out.println();

			for (int i = 0; i < 25 * rmd.getColumnCount(); i++) {
				System.out.printf("=");
			}
			System.out.println();

			while (res.next()) {
				for (int i = 1; i <= rmd.getColumnCount(); i++) {
					System.out.printf("%25s", res.getString(i));
				}
				System.out.println();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
