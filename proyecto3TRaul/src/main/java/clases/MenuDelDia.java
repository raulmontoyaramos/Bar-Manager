package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuDelDia {

	private int id;

	public MenuDelDia(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<String, Object> columnas() {
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("id", id);
		return columnas;
	}

	@Override
	public String toString() {
		return "\n\t- Id: " + this.id;
	}

//	private ArrayList<PrimerPlato> primeros;
//	private ArrayList<SegundoPlato> segundos;
//	private ArrayList<Postre> postres;
//	private ArrayList<Bebida> bebidas;
//
//	public MenuDelDia(ArrayList<PrimerPlato> primeros, ArrayList<SegundoPlato> segundos, ArrayList<Postre> postres,
//			ArrayList<Bebida> bebidas) {
//		super();
//		this.primeros = primeros;
//		this.segundos = segundos;
//		this.postres = postres;
//		this.bebidas = bebidas;
//	}
//
//	public ArrayList<PrimerPlato> getPrimeros() {
//		return primeros;
//	}
//
//	public void setPrimeros(ArrayList<PrimerPlato> primeros) {
//		this.primeros = primeros;
//	}
//
//	public ArrayList<SegundoPlato> getSegundos() {
//		return segundos;
//	}
//
//	public void setSegundos(ArrayList<SegundoPlato> segundos) {
//		this.segundos = segundos;
//	}
//
//	public ArrayList<Postre> getPostres() {
//		return postres;
//	}
//
//	public void setPostres(ArrayList<Postre> postres) {
//		this.postres = postres;
//	}
//
//	public ArrayList<Bebida> getBebidas() {
//		return bebidas;
//	}
//
//	public void setBebidas(ArrayList<Bebida> bebidas) {
//		this.bebidas = bebidas;
//	}
//
//	@Override
//	public String toString() {
//		return "\n\t -Primeros: " + this.primeros + "\n\t -Segundos: " + this.segundos + "\n\t -Postres: "
//				+ this.postres + "\n\t -Bebidas: " + this.bebidas;
//	}

}
