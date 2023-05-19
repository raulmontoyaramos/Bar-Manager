package proyecto3TRaul;

import java.util.Scanner;

import clases.Gerente;
import clases.Trabajador;
import interfaces.AñadirOEliminarTrabajadorOMesa;

public class Main {

	public static void main(String[] args) {
		AñadirOEliminarTrabajadorOMesa añadirEliminar= new AñadirOEliminarTrabajadorOMesa();
		
		Scanner sc = new Scanner(System.in);
		boolean salir = true;
		byte opcion = -1;

		Trabajador trabajador = new Trabajador("Trabajador", null, null, opcion);
		Gerente jefe = new Gerente("Jefe", null, null, 0);

		// DEBERÍA HACER QUE LA CLASE MENÚ NO EXTIENDA DEL MENÚ DEL DÍA? DE ESA FORMA
		// AMBOS TENDRÍAN DIFERENTES ARRAYLIST DE CADA PRODUCTO Y SE PODRÍA EDITAR UN
		// MENÚ SIN QUE ESO AFECTE A EL OTRO PUDIENDO IMPLEMENTAR UNA FUNCIÓN EDITAR MENÚ
		// Y OTRA FUNCIÓN EDITARMENÚDELDÍA
		do {
			System.out.println("Hola " + jefe.getNombre()
					+ ".¿Que operacion deseas realizar?(Usa un numero para elegir una opcion de el siguiente menu):"
					+ "\n\t0 -Salir \n\t1 -Añadir un tipo de comida al menu \n\t2 -Eliminar un tipo de comida de el menu"
					+ "\n\t3 -Añadir platos al menu \n\t4 -Eliminar platos de el menu \n\t5 -Añadir trabajador a la plantilla"
					+ "\n\t6 -Eliminar trabajador de la plantilla \n\t7 -Añadir mesa al local \n\t8 -Eliminar mesa de el local");
			opcion = Byte.parseByte(sc.nextLine());
			switch (opcion) {
			case 0:
				System.out.println("Saliendo...");
				salir = false;
				break;

			case 1:

				salir = true;
				break;

			case 2:

				salir = true;
				break;

			case 3:

				salir = true;
				break;

			case 4:

				salir = true;
				break;

			case 5:

				salir = true;
				break;

			case 6:

				salir = true;
				break;

			case 7:

				salir = true;
				break;

			case 8:

				salir = true;
				break;

			default:
				System.out.println("La opcion " + opcion
						+ " no es valida, por favor elige una opcion de entre las enumeradas en el menu usando un numero.");
				salir = true;
			}
		} while (salir == true);

		do {
			System.out.println("Hola " + trabajador.getNombre()
					+ ".¿Que operacion deseas realizar?(Usa un numero para elegir una opcion de el siguiente menu):"
					+ "\n\t0 -Salir \n\t1 -Marcar una mesa como ocupada \n\t2 -Marcar una mesa como libre");
			opcion = Byte.parseByte(sc.nextLine());
			switch (opcion) {
			case 0:
				System.out.println("Saliendo...");
				salir = true;
				break;

			case 1:

				salir = false;
				break;

			case 2:

				salir = false;
				break;

			default:
				System.out.println("La opcion " + opcion
						+ " no es valida, por favor elige una opcion de entre las enumeradas en el menu usando un numero.");
				salir = false;
			}
		} while (salir == false);

	}

}
