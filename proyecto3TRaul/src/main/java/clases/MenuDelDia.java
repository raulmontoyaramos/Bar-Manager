package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuDelDia {

	private ArrayList<PrimerPlato> primeros;
	private ArrayList<SegundoPlato> segundos;
	private ArrayList<Postre> postres;
	private ArrayList<Bebida> bebidas;

	public MenuDelDia() {
		this.primeros = new ArrayList<>();
        this.segundos = new ArrayList<>();
        this.postres = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        
//		PrimerPlato estofado = new PrimerPlato("Estofado", 4.5f, false, false, false, true, false);
//		PrimerPlato sopaPuchero = new PrimerPlato("Sopa de puchero", 4f, false, false, false, false, false);
//		PrimerPlato paella = new PrimerPlato("Paella", 5f, false, false, false, true, false);
//		this.primeros.add(estofado);
//		this.primeros.add(sopaPuchero);
//		this.primeros.add(paella);
//
//		SegundoPlato bacalaoRiojana = new SegundoPlato("Bacalao a la riojana", 5f, false, false, false, false, false);
//		SegundoPlato solomilloRoquefort = new SegundoPlato("Solomillo al roquefort", 5.5f, false, false, false, true,
//				true);
//		SegundoPlato rosadaFrita = new SegundoPlato("Rosada frita", 5f, false, false, false, true, false);
//		this.segundos.add(bacalaoRiojana);
//		this.segundos.add(solomilloRoquefort);
//		this.segundos.add(rosadaFrita);
//
//		Postre flanNata = new Postre("Flan con nata", 3f, true, true, true);
//		Postre arrozLeche = new Postre("Arroz con leche", 4f, true, false, true);
//		Postre frutaTemporada = new Postre("Fruta de temporada", 2.5f, true, false, false);
//		this.postres.add(flanNata);
//		this.postres.add(arrozLeche);
//		this.postres.add(frutaTemporada);
//
//		Bebida agua = new Bebida("Agua mineral", 1.5f, true, true, false, false, false);
//		Bebida cocaCola = new Bebida("Coca-cola", 2f, true, true, true, true, false);
//		Bebida cerveza = new Bebida("Cerveza", 2.5f, true, true, false, false, true);
//		this.bebidas.add(agua);
//		this.bebidas.add(cocaCola);
//		this.bebidas.add(cerveza);
	}


	public ArrayList<PrimerPlato> getPrimeros() {
		return primeros;
	}

	public void setPrimeros(ArrayList<PrimerPlato> primeros) {
		this.primeros = primeros;
	}

	public ArrayList<SegundoPlato> getSegundos() {
		return segundos;
	}

	public void setSegundos(ArrayList<SegundoPlato> segundos) {
		this.segundos = segundos;
	}

	public ArrayList<Postre> getPostres() {
		return postres;
	}

	public void setPostres(ArrayList<Postre> postres) {
		this.postres = postres;
	}

	public ArrayList<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public HashMap<String, Object> columnas() {
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("primeros", primeros);
		columnas.put("segundos", segundos);
		columnas.put("postres", postres);
		columnas.put("bebidas", bebidas);
		return columnas;
	}

	@Override
	public String toString() {
		return "\n\t- Bebidas: " + this.bebidas + "\n\t- Primeros: " + this.primeros + "\n\t- Segundos: "
				+ this.segundos + "\n\t- Postre: " + this.postres;
	}

}
