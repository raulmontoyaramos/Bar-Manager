package clases;

import java.util.ArrayList;

public class Entrante extends Producto {

	private boolean esVegetariano;
	private boolean esVegano;
	private boolean tieneGluten;
	private boolean tieneLactosa;

	public Entrante(String nombre, float precio, boolean esFrio, boolean esVegetariano, boolean esVegano,
			boolean tieneGluten, boolean tieneLactosa) {
		super(nombre, precio, esFrio);
		this.esVegetariano = esVegetariano;
		this.esVegano = esVegano;
		this.tieneGluten = tieneGluten;
		this.tieneLactosa = tieneLactosa;
	}

	public boolean isEsVegetariano() {
		return esVegetariano;
	}

	public void setEsVegetariano(boolean esVegetariano) {
		this.esVegetariano = esVegetariano;
	}

	public boolean isEsVegano() {
		return esVegano;
	}

	public void setEsVegano(boolean esVegano) {
		this.esVegano = esVegano;
	}

	public boolean isTieneGluten() {
		return tieneGluten;
	}

	public void setTieneGluten(boolean tieneGluten) {
		this.tieneGluten = tieneGluten;
	}

	public boolean isTieneLactosa() {
		return tieneLactosa;
	}

	public void setTieneLactosa(boolean tieneLactosa) {
		this.tieneLactosa = tieneLactosa;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t -Es vegetarinao?: " + this.esVegetariano + "\n\t -Es vegano?: "
				+ this.esVegano + "\n\t -Tienen gluten?: " + this.tieneGluten + "\n\t -Tiene lactosa?: "
				+ this.tieneLactosa;
	}

}
