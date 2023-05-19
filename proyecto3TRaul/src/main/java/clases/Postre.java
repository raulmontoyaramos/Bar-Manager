package clases;

import java.util.ArrayList;

public class Postre extends Producto {

	private boolean tieneGluten;
	private boolean tieneLactosa;

	public Postre(String nombre, float precio, boolean esFrio, boolean tieneGluten, boolean tieneLactosa) {
		super(nombre, precio, esFrio);
		this.tieneGluten = tieneGluten;
		this.tieneLactosa = tieneLactosa;
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
		return super.toString() + "\n\t -¿Tiene gluten?: " + this.tieneGluten + "\n\t -¿Tiene lactosa?: "
				+ this.tieneLactosa;
	}

}
