package clases;

public class Trabajador {

	private String nombre;
	private String email;
	private String contraseña;
	private int telefono;
	
	public Trabajador(String nombre, String email, String contraseña, int telefono) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
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
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() { //NO HE PUESTO LA CONTRASEÑA AQUÍ A PROPÓSITO
		return "\n\t -Nombre: "+this.nombre+"\n\t -Email: "+this.email+"\n\t -Telefono: "+this.telefono;
	}
	
	
}
