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
		int opcion = 0;
		int opcionTabla = 0;
		do {
			System.out.println("_______________________________________________\r\n" + "Menú de opciones\r\n"
					+ "_______________________________________________\r\n" + "1- Mostrar datos\r\n"
					+ "2- Alta de datos\r\n" + "3- Modificar datos\r\n" + "4- Eliminar datos\r\n" + "5- Salir\r\n"
					+ "_______________________________________________");
			opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				do {
					System.out.println("Introduce la tabla que quieres visualizar: \r\n" + "1. Tabla de alumnos\r\n"
							+ "2. Tabla de asignaturas\r\n" + "3. Tabla de notas \r\n" + "4. Tabla de profesores\r\n"
							+ "5. Menú principal");
					opcionTabla = entrada.nextInt();

					switch (opcionTabla) {
					case 1:
						System.out.println("Visualización de la tabla1");
						break;

					case 2:
						System.out.println("Visualización de la tabla2");
						break;

					case 3:
						System.out.println("Visualización de la tabla3");
						break;

					case 4:
						System.out.println("Visualización de la tabla4");
						break;

					case 5:
						break;

					default:
						System.out.println("Opción inválida");
					}
				} while (opcionTabla != 5);
				break;

			case 2:
				do {
					System.out.println("Introduce la tabla en la que quieres insertar datos: \r\n"
							+ "1. Tabla de alumnos\r\n" + "2. Tabla de asignaturas\r\n" + "3. Tabla de notas \r\n"
							+ "4. Tabla de profesores\r\n" + "5. Menú principal");
					opcionTabla = entrada.nextInt();

					switch (opcionTabla) {
					case 1:
						System.out.println("Visualización de la tabla1");
						break;

					case 2:
						System.out.println("Visualización de la tabla2");
						break;

					case 3:
						System.out.println("Visualización de la tabla3");
						break;

					case 4:
						System.out.println("Visualización de la tabla4");
						break;

					case 5:
						break;

					default:
						System.out.println("Opción inválida");
					}
				} while (opcionTabla != 5);

				break;

			case 3:
				do {
					System.out.println("Introduce la tabla que quieres modificar: \r\n" + "1. Tabla de alumnos\r\n"
							+ "2. Tabla de asignaturas\r\n" + "3. Tabla de notas \r\n" + "4. Tabla de profesores\r\n"
							+ "5. Menú principal");
					opcionTabla = entrada.nextInt();

					switch (opcionTabla) {
					case 1:
						System.out.println("Visualización de la tabla1");
						break;

					case 2:
						System.out.println("Visualización de la tabla2");
						break;

					case 3:
						System.out.println("Visualización de la tabla3");
						break;

					case 4:
						System.out.println("Visualización de la tabla4");
						break;

					case 5:
						break;

					default:
						System.out.println("Opción inválida");
					}
				} while (opcionTabla != 5);
				break;

			case 4:
				do {
					System.out.println("Introduce la tabla en la que quieres eliminar datos: \r\n"
							+ "1. Tabla de alumnos\r\n" + "2. Tabla de asignaturas\r\n" + "3. Tabla de notas \r\n"
							+ "4. Tabla de profesores\r\n" + "5. Menú principal");
					opcionTabla = entrada.nextInt();

					switch (opcionTabla) {
					case 1:
						System.out.println("Visualización de la tabla1");
						break;

					case 2:
						System.out.println("Visualización de la tabla2");
						break;

					case 3:
						System.out.println("Visualización de la tabla3");
						break;

					case 4:
						System.out.println("Visualización de la tabla4");
						break;

					case 5:
						break;

					default:
						System.out.println("Opción inválida");
					}
				} while (opcionTabla != 5);
				break;

			case 5:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opción inválida");

			}
		} while (opcion != 5);
		try {
			conexion = DriverManager.getConnection(server + bbdd, user, pwd);
			String consulta = "SELECT * FROM alumnos";
			PreparedStatement ps = conexion.prepareStatement(consulta);
			ResultSet res = ps.executeQuery();
			ResultSetMetaData rmd = res.getMetaData();
			System.out.println(rmd.getColumnName(1) + " " + rmd.getColumnName(2));

			while (res.next()) {
				System.out.println(res.getInt(1) + " " + res.getString(2));
			}
			conexion.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} finally {
			entrada.close();
		}

	}

}
