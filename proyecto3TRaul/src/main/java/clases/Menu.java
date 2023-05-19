package clases;

import java.util.ArrayList;

public class Menu extends MenuDelDia {

	private ArrayList<Entrante> entrantes;

	public Menu(ArrayList<Primero> primeros, ArrayList<Segundo> segundos, ArrayList<Postre> postres,
			ArrayList<Bebida> bebidas, ArrayList<Entrante> entrantes) {
		super(primeros, segundos, postres, bebidas);
		this.entrantes = entrantes;
	}

	public ArrayList<Entrante> getEntrantes() {
		return entrantes;
	}

	public void setEntrantes(ArrayList<Entrante> entrantes) {
		this.entrantes = entrantes;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t -Entrantes: " + this.entrantes;
	}

}
