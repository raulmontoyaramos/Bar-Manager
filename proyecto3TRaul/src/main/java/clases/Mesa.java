package clases;

import java.util.HashMap;

public class Mesa {

	private short numero;
	private byte capacidad;
	private boolean estaOcupada;

	public Mesa(short numero, byte capacidad, boolean estaOcupada) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
		this.estaOcupada = estaOcupada;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public byte getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(byte capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isEstaOcupada() {
		return estaOcupada;
	}

	public void setEstaOcupada(boolean estaOcupada) {
		this.estaOcupada = estaOcupada;
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
				+ this.estaOcupada;
	}

}
