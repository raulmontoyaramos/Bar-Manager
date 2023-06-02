package proyecto3TRaul;

import java.sql.SQLException;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

import clases.Bebida;
import clases.Entrante;
import clases.Menu;
import clases.MenuDelDia;
import clases.Mesa;
import clases.Negocio;
import clases.Postre;
import clases.PrimerPlato;
import clases.Producto;
import clases.SegundoPlato;
import clases.Trabajador;
import enumeraciones.Comidas;
import interfaces.Ventana;
import utils.DAO;

public class Main {
					//NO CONSIGO APLICAR LA EXCEPCION SQLINTEGRITY PARA CUANDO SE INSERTAN VALORES DUPLICADOS
	public static void main(String[] args) {

		Ventana v= new Ventana();
		
		Scanner sc = new Scanner(System.in);
//		boolean salir = true;
//		byte opcion = -1;

		ArrayList<Bebida>bebidas = new ArrayList<>();
		ArrayList<Entrante>entrantes = new ArrayList<>();
		ArrayList<PrimerPlato>primeros = new ArrayList<>();
		ArrayList<SegundoPlato>segundos = new ArrayList<>();
		ArrayList<Postre>postres = new ArrayList<>();
		ArrayList<Producto>platosPedidos = new ArrayList<>();
		ArrayList<Comidas> tipoComida= new ArrayList<>();
		tipoComida.add(Comidas.ESPANIOLA);
				

		
		Trabajador trabajador = new Trabajador("CURRANTE@", "Trabajador", "1231232", 653812792);
		Trabajador trabajador2 = new Trabajador("CURRANTE@2", "Trabajador2", "1231232", 653813792);
		
		MenuDelDia menuDD= new MenuDelDia();
		Menu menu= new Menu();
//		System.out.println(trabajador.consultarMenu());
//		System.out.println(trabajador.consultarMenuDelDia());
		
		Negocio tablon= new Negocio("El tablon", "nsdjfdsnk2", "c/ Juan Latino, 2", "tablon@2", 65363762, tipoComida, menuDD, menu);
//		Mesa mesa1 = new Mesa((short)1, (byte)4, true);
//		Mesa mesa2 = new Mesa((short)2, (byte)4, false);
		
//		trabajador.consultarTipoComida(tablon);
		
//		System.out.println(trabajador.consultarBebidas());
//		System.out.println(trabajador.consultarEntrantes());
//		trabajador.añadirMesa(mesa1);
//		trabajador.añadirMesa(mesa2);
//		trabajador.consultarMesasOcupadas(mesa2);
//		trabajador.consultarMesasLibres(mesa2);
//		trabajador.eliminarMesa(mesa2);
//		
//		trabajador.añadirTrabajador(trabajador);
//		trabajador.añadirTrabajador(trabajador2);
//		trabajador.consultarTrabajadores(trabajador2, "telefono");
//		trabajador.eliminarTrabajador(trabajador2);
//		trabajador.editarTrabajador(trabajador, "telefono");
		
		
//		try {
//			LinkedHashSet<String> columnasSacar = new LinkedHashSet<String>();
//			columnasSacar.add("email");
//			columnasSacar.add("password");
//			columnasSacar.add("telefono");
//			columnasSacar.add("nombre");
//			HashMap<String, Object> restricciones = new HashMap<String, Object>();
//		ArrayList<Object> cliente = DAO.consultar("cliente", columnasSacar, restricciones);
//		ArrayList<String> columnas = new ArrayList<>(columnasSacar);
//		for (byte i = 0; i < cliente.size(); i++) {
//			System.out.println(cliente.get(i) + " : ");
//		}
//		System.out.println();
//	} catch (SQLException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}






//		try {
//			DAO.insert("Negocio", tablon.columnas());
//			ArrayList<Object> negocios = DAO.consultar("Negocio", new LinkedHashSet<String>(tablon.columnas().keySet()),
//					new HashMap<String, Object>());
//			for (byte i = 0; i < negocios.size(); i++) {
//				System.out.println(negocios.get(i) + " : ");
//			}
//			System.out.println("");
//
//			DAO.insert("Trabajador", trabajador.columnas());
//			DAO.insert("Trabajador", trabajador2.columnas());
//			System.out.println("Dime el nombre de el/los trabajador/es a consultar");
//			String nombre=sc.nextLine();
//			HashMap<String, Object> restriccionesMod = new HashMap<String, Object>();
//			restriccionesMod.put("nombre", nombre);
//			ArrayList<Object> trabajadores = DAO.consultar("Trabajador",
//					new LinkedHashSet<String>(trabajador.columnas().keySet()),restriccionesMod);
//			for (byte i = 0; i < trabajadores.size(); i++) {
//				System.out.println(trabajadores.get(i));
//			}
//			System.out.println("");
//
//			HashMap<String, Object> columnasTrabajadorNegocio = new HashMap<String, Object>();
//			columnasTrabajadorNegocio.put("email_trabajador", trabajador.getEmail());
//			columnasTrabajadorNegocio.put("CIF_negocio", tablon.getCif());
//			DAO.insert("Trabajador_Negocio", columnasTrabajadorNegocio);
//			ArrayList<Object> trabajadoresNegocios = DAO.consultar("Trabajador_Negocio",
//					new LinkedHashSet<String>(columnasTrabajadorNegocio.keySet()), new HashMap<String, Object>());
//			for (byte i = 0; i < trabajadoresNegocios.size(); i++) {
//				System.out.println(trabajadoresNegocios.get(i));
//			}
//			System.out.println("");
//			
//			DAO.insert("Mesa", mesa1.columnas());
//			DAO.insert("Mesa", mesa2.columnas());
			
//			ArrayList<Object> mesas = DAO.consultar("Mesa", new LinkedHashSet<String>(mesa1.columnas().keySet()),
//					new HashMap<String, Object>());
//			for (byte i = 0; i < mesas.size(); i++) {
//				System.out.println(mesas.get(i));
//			}
//			System.out.println("");
//			

//			mesa1.marcarMesaLibre(mesa1);
//			System.out.println(mesa1);
//			mesa1.marcarMesaOcupada(mesa1);
//			System.out.println(mesa1);
//			
//			HashMap<String, Object> columnasMesaNegocio = new HashMap<String, Object>();
//			columnasMesaNegocio.put("numero_mesa", mesa1.getNumero());
//			columnasMesaNegocio.put("CIF_negocio", tablon.getCif());
//			DAO.insert("Mesa_Negocio", columnasMesaNegocio);
//			ArrayList<Object> mesasNegocios = DAO.consultar("Mesa_Negocio",
//					new LinkedHashSet<String>(columnasMesaNegocio.keySet()), new HashMap<String, Object>());
//			for (byte i = 0; i < mesasNegocios.size(); i++) {
//				System.out.println(mesasNegocios.get(i));
//			}
//			System.out.println("");
//			
////			DAO.insert("Menu", menu.columnas());
////			ArrayList<Object> menus = DAO.consultar("Menu", new LinkedHashSet<String>(mesa1.columnas().keySet()),
////					new HashMap<String, Object>());
////			for (byte i = 0; i < menus.size(); i++) {
////				System.out.println(menus.get(i) + " : ");
////			}
////			System.out.println("");
//			
////			HashMap<String, Object> columnasMenuNegocio = new HashMap<String, Object>();
////			columnasMenuNegocio.put("id_menu", menu.getId());
////			columnasMenuNegocio.put("CIF_negocio", tablon.getCif());
////			DAO.insert("Menu_Negocio", columnasMenuNegocio);
////			ArrayList<Object> menuNegocios = DAO.consultar("Menu_Negocio",
////					new LinkedHashSet<String>(columnasMenuNegocio.keySet()), new HashMap<String, Object>());
////			for (byte i = 0; i < menuNegocios.size(); i++) {
////				System.out.println(menuNegocios.get(i));
////			}
////			System.out.println("");
//			
//			DAO.insert("MenuDelDia", menuDD.columnas());
//			ArrayList<Object> menusDD = DAO.consultar("MenuDelDia", new LinkedHashSet<String>(menuDD.columnas().keySet()),
//					new HashMap<String, Object>());
//			for (byte i = 0; i < menusDD.size(); i++) {
//				System.out.println(menusDD.get(i) + " : ");
//			}
//			System.out.println("");
//			
//			HashMap<String, Object> columnasMenuDDNegocio = new HashMap<String, Object>();
//			columnasMenuDDNegocio.put("id_menuDelDia", menuDD.getId());
//			columnasMenuDDNegocio.put("CIF_negocio", tablon.getCif());
//			DAO.insert("MenuDelDia_Negocio", columnasMenuDDNegocio);
//			ArrayList<Object> menusDDNegocios = DAO.consultar("MenuDelDia_Negocio",
//					new LinkedHashSet<String>(columnasMenuDDNegocio.keySet()), new HashMap<String, Object>());
//			for (byte i = 0; i < menusDDNegocios.size(); i++) {
//				System.out.println(menusDDNegocios.get(i));
//			}
//			System.out.println("");
//			

//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
				//CONSULTAR MESAS LIBRES
//		mesa2.consultarMesasLibres(mesa1);
		

			
			
			
			
			
			
			
			
			
			
			
		// DEBERÍA HACER QUE LA CLASE MENÚ NO EXTIENDA DEL MENÚ DEL DÍA? DE ESA FORMA
		// AMBOS TENDRÍAN DIFERENTES ARRAYLIST DE CADA PRODUCTO Y SE PODRÍA EDITAR UN
		// MENÚ SIN QUE ESO AFECTE A EL OTRO PUDIENDO IMPLEMENTAR UNA FUNCIÓN EDITAR
		// MENÚ
		// Y OTRA FUNCIÓN EDITARMENÚDELDÍA
//		do {
//			System.out.println("Hola " + trabajador.getNombre()
//					+ ".¿Que operacion deseas realizar?(Usa un numero para elegir una opcion de el siguiente menu):"
//					+ "\n\t0 -Salir \n\t1 -Añadir un tipo de comida al menu \n\t2 -Eliminar un tipo de comida de el menu"
//					+ "\n\t3 -Añadir platos al menu \n\t4 -Eliminar platos de el menu \n\t5 -Añadir trabajador a la plantilla"
//					+ "\n\t6 -Eliminar trabajador de la plantilla \n\t7 -Añadir mesa al local \n\t8 -Eliminar mesa de el local");
//			opcion = Byte.parseByte(sc.nextLine());
//			switch (opcion) {
//			case 0:
//				System.out.println("Saliendo...");
//				salir = false;
//				break;
//
//			case 1:
//
//				salir = true;
//				break;
//
//			case 2:
//
//				salir = true;
//				break;
//
//			case 3:
//
//				salir = true;
//				break;
//
//			case 4:
//
//				salir = true;
//				break;
//
//			case 5:
//
//				salir = true;
//				break;
//
//			case 6:
//
//				salir = true;
//				break;
//
//			case 7:
//
//				salir = true;
//				break;
//
//			case 8:
//
//				salir = true;
//				break;
//
//			default:
//				System.out.println("La opcion " + opcion
//						+ " no es valida, por favor elige una opcion de entre las enumeradas en el menu usando un numero.");
//				salir = true;
//			}
//		} while (salir == true);

//		do {
//			System.out.println("Hola " + trabajador.getNombre()
//					+ ".¿Que operacion deseas realizar?(Usa un numero para elegir una opcion de el siguiente menu):"
//					+ "\n\t0 -Salir \n\t1 -Marcar una mesa como ocupada \n\t2 -Marcar una mesa como libre");
//			opcion = Byte.parseByte(sc.nextLine());
//			switch (opcion) {
//			case 0:
//				System.out.println("Saliendo...");
//				salir = true;
//				break;
//
//			case 1:
//
//				salir = false;
//				break;
//
//			case 2:
//
//				salir = false;
//				break;
//
//			default:
//				System.out.println("La opcion " + opcion
//						+ " no es valida, por favor elige una opcion de entre las enumeradas en el menu usando un numero.");
//				salir = false;
//			}
//		} while (salir == false);

	}

}
