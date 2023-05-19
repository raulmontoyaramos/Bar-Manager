package clases;

import java.util.ArrayList;

public class Bebida extends Producto {

	private boolean tieneCafeina;
	private boolean tieneAzucar;
	private boolean esAlcoholica;

	public Bebida(String nombre, float precio, boolean esFrio, boolean esFria, boolean tieneCafeina,
			boolean tieneAzucar, boolean esAlcoholica) {
		super(nombre, precio, esFrio);
		this.tieneCafeina = tieneCafeina;
		this.tieneAzucar = tieneAzucar;
		this.esAlcoholica = esAlcoholica;
	}

	public boolean isTieneCafeina() {
		return tieneCafeina;
	}

	public void setTieneCafeina(boolean tieneCafeina) {
		this.tieneCafeina = tieneCafeina;
	}

	public boolean isTieneAzucar() {
		return tieneAzucar;
	}

	public void setTieneAzucar(boolean tieneAzucar) {
		this.tieneAzucar = tieneAzucar;
	}

	public boolean isEsAlcoholica() {
		return esAlcoholica;
	}

	public void setEsAlcoholica(boolean esAlcoholica) {
		this.esAlcoholica = esAlcoholica;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t -¿Tiene cafeína?: " + this.tieneCafeina + "\n\t -¿Tiene azúcar?: "
				+ this.tieneAzucar + "\n\t -¿Es alcohólica?: " + this.esAlcoholica;
	}

}
