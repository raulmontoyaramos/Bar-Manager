package clases;

public class Mesa {

	private short id;
	private byte capacidad;
	private boolean estaOcupada;

	public Mesa(short id, byte capacidad, boolean estaOcupada) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.estaOcupada = estaOcupada;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "\n\t -Id: " + this.id + "\n\t -Capacidad: " + this.capacidad + "\n\t -¿Está ocupada?: "
				+ this.estaOcupada;
	}

}
