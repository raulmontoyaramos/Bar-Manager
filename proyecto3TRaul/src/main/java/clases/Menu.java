package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu extends MenuDelDia {

	private ArrayList<Entrante> entrantes;

	// Crea a mano, hardcodeados, todos los entrantes, bebidas, platos, etc... de tu
	// bar.
	public Menu() {
		super();
		this.entrantes = new ArrayList<>();
		
//		Entrante surtidoEmbutidos = new Entrante("Surtido de embutidos", 3.5f, true, false, false, false, false);
//		Entrante gambasPilpil = new Entrante("Gambas al pilpil", 3f, false, false, false, false, false);
//		Entrante ensaladaMixta = new Entrante("Ensalada mixta", 3f, true, false, false, false, false);
//		Entrante ensaladaCesar = new Entrante("Ensalada cesar", 3.5f, true, false, false, true, true);
//		this.entrantes.add(surtidoEmbutidos);
//		this.entrantes.add(gambasPilpil);
//		this.entrantes.add(ensaladaMixta);
//		this.entrantes.add(ensaladaCesar);

	}

	public ArrayList<Entrante> getEntrantes() {
		return entrantes;
	}

	public void setEntrantes(ArrayList<Entrante> entrantes) {
		this.entrantes = entrantes;
	}


	public HashMap<String, Object> columnas() {
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("entrantes", entrantes);
		return columnas;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t- Entrantes: " + this.entrantes;
	}

}
