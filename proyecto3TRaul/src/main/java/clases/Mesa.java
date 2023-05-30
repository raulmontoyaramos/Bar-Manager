package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import utils.DAO;

public class Mesa {

	private int numero;
	private int capacidad;
	private boolean estaOcupada;
	private ArrayList<Producto> platosPedidos;

	public Mesa(int numero, int capacidad, boolean estaOcupada) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
		this.estaOcupada = estaOcupada;
		this.platosPedidos = platosPedidos;

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

	public boolean isEstaOcupada() {
		return estaOcupada;
	}

	public void setEstaOcupada(boolean estaOcupada) {
		this.estaOcupada = estaOcupada;
	}

	public ArrayList<Producto> getPlatosPedidos() {
		return platosPedidos;
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
		return "\n\t -Id: " + this.numero + "\n\t -Capacidad: " + this.capacidad + "\n\t -¿Está ocupada?: "
				+ this.estaOcupada + "\n\t- Platos Pedidos: " + this.platosPedidos;
	}

}
