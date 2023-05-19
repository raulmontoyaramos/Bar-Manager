package clases;

import java.util.ArrayList;

public class MenuDelDia {

	private ArrayList<Primero> primeros;
	private ArrayList<Segundo> segundos;
	private ArrayList<Postre> postres;
	private ArrayList<Bebida> bebidas;

	public MenuDelDia(ArrayList<Primero> primeros, ArrayList<Segundo> segundos, ArrayList<Postre> postres,
			ArrayList<Bebida> bebidas) {
		super();
		this.primeros = primeros;
		this.segundos = segundos;
		this.postres = postres;
		this.bebidas = bebidas;
	}

	public ArrayList<Primero> getPrimeros() {
		return primeros;
	}

	public void setPrimeros(ArrayList<Primero> primeros) {
		this.primeros = primeros;
	}

	public ArrayList<Segundo> getSegundos() {
		return segundos;
	}

	public void setSegundos(ArrayList<Segundo> segundos) {
		this.segundos = segundos;
	}

	public ArrayList<Postre> getPostres() {
		return postres;
	}

	public void setPostres(ArrayList<Postre> postres) {
		this.postres = postres;
	}

	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	@Override
	public String toString() {
		return "\n\t -Primeros: " + this.primeros + "\n\t -Segundos: " + this.segundos + "\n\t -Postres: "
				+ this.postres + "\n\t -Bebidas: " + this.bebidas;
	}

}
