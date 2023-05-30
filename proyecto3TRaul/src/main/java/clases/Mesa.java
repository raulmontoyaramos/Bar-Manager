package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import utils.DAO;

public class Mesa {

	private int numero;
	private int capacidad;
	private int estaOcupada;
	private ArrayList<Producto> platosPedidos;

	public Mesa(int numero, int capacidad, int estaOcupada) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
		this.estaOcupada = estaOcupada;
		this.platosPedidos = new ArrayList<Producto>();

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

//	public boolean isEstaOcupada() {
//		return estaOcupada;
//	}
//
//	public void setEstaOcupada(boolean estaOcupada) {
//		this.estaOcupada = estaOcupada;
//	}

	public ArrayList<Producto> getPlatosPedidos() {
		return platosPedidos;
	}

	public int getEstaOcupada() {
		return estaOcupada;
	}

	public void setEstaOcupada(int estaOcupada) {
		this.estaOcupada = estaOcupada;
	}

	public void setPlatosPedidos(ArrayList<Producto> platosPedidos) {
		this.platosPedidos = platosPedidos;
	}

	public HashMap<String, Object> columnas() {
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("numero", numero);
		columnas.put("capacidad", capacidad);
		columnas.put("estaOcupada", estaOcupada);
		return columnas;
	}

	@Override
	public String toString() {
		return "Mesa :" + numero + "(" + capacidad + ")";
	}

}
