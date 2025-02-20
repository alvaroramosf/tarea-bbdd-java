package aplicacion_bbdd;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

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
						Metodos.mostrarDatosAlumnos();
						System.out.println();
						break;

					case 2:
						Metodos.mostrarDatosAsignaturas();
						System.out.println();

						break;

					case 3:
						Metodos.mostrarDatosNotas();
						System.out.println();

						break;

					case 4:
						Metodos.mostrarDatosProfesores();
						System.out.println();

						break;

					case 5:
						break;

					default:
						System.out.println("Opción inválida");
						System.out.println();

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

		System.out.println("Programa finalizado");
		entrada.close();

	}

}
