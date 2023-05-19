package clases;

import java.util.HashMap;

public class Trabajador {

	private String nombre;
	private String email;
	private String contrasenia;
	private int telefono;

	public Trabajador(String email, String nombre, String contraseña, int telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contrasenia = contraseña;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contrasenia;
	}

	public void setContraseña(String contraseña) {
		this.contrasenia = contraseña;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public HashMap<String, Object> columnas() {
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("email", email);
		columnas.put("nombre", nombre);
		columnas.put("contrasenia", contrasenia);
		columnas.put("telefono", telefono);

		return columnas;
	}

	@Override
	public String toString() { // NO HE PUESTO LA CONTRASEÑA AQUÍ A PROPÓSITO
		return "\n\t -Nombre: " + this.nombre + "\n\t -Email: " + this.email + "\n\t -Telefono: " + this.telefono;
	}

}
