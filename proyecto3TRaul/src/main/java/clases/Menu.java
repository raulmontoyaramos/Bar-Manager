package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu /* extends MenuDelDia */ {

	private int id;

//	public Menu(int id, int id2) {
//		super(id);
//		id = id2;
//	}

	public Menu(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashMap<String, Object> columnas() {
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("id", id);
		return columnas;
	}

//	private ArrayList<Entrante> entrantes;
//
//	public Menu(ArrayList<PrimerPlato> primeros, ArrayList<SegundoPlato> segundos, ArrayList<Postre> postres,
//			ArrayList<Bebida> bebidas, ArrayList<Entrante> entrantes) {
//		super(primeros, segundos, postres, bebidas);
//		this.entrantes = entrantes;
//	}
//
//	public ArrayList<Entrante> getEntrantes() {
//		return entrantes;
//	}
//
//	public void setEntrantes(ArrayList<Entrante> entrantes) {
//		this.entrantes = entrantes;
//	}
//	
//	@Override
//	public String toString() {
//		return super.toString() + "\n\t -Entrantes: " + this.entrantes;
//	}

}
