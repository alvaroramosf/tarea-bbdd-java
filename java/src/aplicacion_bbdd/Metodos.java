package aplicacion_bbdd;

import java.sql.*;

public class Metodos {
	static String bbdd = "equipo_colegio";
	static String user = "root";
	static String pwd = "";
	static String server = "jdbc:mysql://localhost:3306/";
	static Connection conexion = null;
	
	// CONSULTAS

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
	
	//INSERTAR (ALTA) DATOS
	
	static void insertarAlumno(String nif, String apenom, String direc, String pobla, String telef) {
		String consulta = "INSERT INTO alumnos (nif, apenom, direc, pobla, telef) VALUES ('" 
			+ nif + "', '" + apenom + "', '" + direc + "', '" + pobla + "', '" + telef + "')";
		modificarDatos(consulta);
	}

	static void insertarProfesor(String nif, String apenom, String direc, String pobla, String telef) {
		String consulta = "INSERT INTO profesores (nif, apenom, direc, pobla, telef) VALUES ('" 
			+ nif + "', '" + apenom + "', '" + direc + "', '" + pobla + "', '" + telef + "')";
		modificarDatos(consulta);
	}

	static void insertarAsignatura(int cod, String nombre, String nif_profesor) {
		String consulta = "INSERT INTO asignaturas (cod, nombre, nif_profesor) VALUES (" 
			+ cod + ", '" + nombre + "', '" + nif_profesor + "')";
		modificarDatos(consulta);
	}

	static void insertarNota(String nif, int cod_asignatura, float nota) {
		String consulta = "INSERT INTO notas (nif, cod_asignatura, nota) VALUES ('" 
			+ nif + "', " + cod_asignatura + ", " + nota + ")";
		modificarDatos(consulta);
	}
	
	//MODIFICAR DATOS
	
	static void modificarAlumno(String nif, String nuevoNombre, String nuevaDirec, String nuevaPobla, String nuevoTelef) {
		String consulta = "UPDATE alumnos SET apenom = '" + nuevoNombre + "', direc = '" 
				+ nuevaDirec + "', pobla = '" + nuevaPobla + "', telef = '" + nuevoTelef + "' WHERE nif = '" + nif + "'";
		modificarDatos(consulta);
	}

	static void modificarProfesor(String nif, String nuevoNombre, String nuevaDirec, String nuevaPobla, String nuevoTelef) {
		String consulta = "UPDATE profesores SET apenom = '" + nuevoNombre + "', direc = '" + nuevaDirec + 
						  "', pobla = '" + nuevaPobla + "', telef = '" + nuevoTelef + "' WHERE nif = '" + nif + "'";
		modificarDatos(consulta);
	}

	static void modificarAsignatura(int cod, String nuevoNombre, String nuevoNifProfesor) {
		String consulta = "UPDATE asignaturas SET nombre = '" + nuevoNombre + "', nif_profesor = '" + nuevoNifProfesor + 
						  "' WHERE cod = " + cod;
		modificarDatos(consulta);
	}


	static void modificarNota(String nif, int codAsignatura, float nuevaNota) {
		String consulta = "UPDATE notas SET nota = " + nuevaNota + " WHERE nif = '" + nif + "' AND cod_asignatura = " + codAsignatura;
		modificarDatos(consulta);
	}


	//ELIMINAR DATOS
	
	static void eliminarAlumno(String nif) {
		String consulta = "DELETE FROM alumnos WHERE nif = '" + nif + "'";
		modificarDatos(consulta);
	}

	static void eliminarProfesor(String nif) {
		String consulta = "DELETE FROM profesores WHERE nif = '" + nif + "'";
		modificarDatos(consulta);
	}

	static void eliminarAsignatura(int cod) {
		String consulta = "DELETE FROM asignaturas WHERE cod = " + cod;
		modificarDatos(consulta);
	}

	static void eliminarNota(String nif, int codAsignatura) {
		String consulta = "DELETE FROM notas WHERE nif = '" + nif + "' AND cod_asignatura = " + codAsignatura;
		modificarDatos(consulta);
	}

	static void modificarDatos(String consulta) {
		try {
			conexion = DriverManager.getConnection(server + bbdd, user, pwd);
			PreparedStatement ps = conexion.prepareStatement(consulta);
			int filasAfectadas = ps.executeUpdate();
			
			System.out.println(filasAfectadas + "filas modificadas.");

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	

			
	

}
