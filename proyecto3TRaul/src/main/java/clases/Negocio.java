package clases;

import java.util.ArrayList;

import enumeraciones.Comidas;

public class Negocio {

	private String nombre;
	private String cif;
	private String direccion;
	private String email;
	private int telefono;
	private ArrayList<Comidas> tipoComida;
	private MenuDelDia menuDelDia;
	private Menu menu;

	public Negocio(String nombre, String cif, String direccion, String email, int telefono,
			ArrayList<Comidas> tipoComida, MenuDelDia menuDelDia, Menu menu) {
		super();
		this.nombre = nombre;
		this.cif = cif;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.tipoComida = tipoComida;
		this.menuDelDia = menuDelDia;
		this.menu = menu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Comidas> getTipoComida() {
		return tipoComida;
	}

	public void setTipoComida(ArrayList<Comidas> tipoComida) {
		this.tipoComida = tipoComida;
	}

	public MenuDelDia getMenuDelDia() {
		return menuDelDia;
	}

	public void setMenuDelDia(MenuDelDia menuDelDia) {
		this.menuDelDia = menuDelDia;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "\n\t -Nombre: " + this.nombre + "\n\t -CIF: " + this.cif + "\n\t -Dirección: " + this.direccion
				+ "\n\t -Telefono: " + this.telefono + "\n\t -Email: " + this.email + "\n\t -Tipo/s de comida/s: "
				+ this.tipoComida + "\n\t -Menu del dia: " + this.menuDelDia + "\n\t -Manu: " + this.menu;
	}

}
