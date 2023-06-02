package clases;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

import enumeraciones.Comidas;
import enumeraciones.TipoProducto;
import excepciones.CampoVacioException;
import excepciones.UsuarioNoExisteException;
import utils.DAO;

public class Trabajador {

	private String nombre;
	private String email;
	private String contrasenia;
	private int telefono;

	public Trabajador(String email, String nombre, String contraseña, int telefono) {
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

	public static void eliminarTrabajador(Trabajador t) {
		try {
			DAO.delete("Trabajador", t.columnas());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Trabajador actualizarTrabajador(String nombre, String email, String contrasenia, String telefono)
			throws SQLException, CampoVacioException, NumberFormatException {
		if (email.isEmpty() || nombre.isEmpty() || contrasenia.isEmpty() || telefono.isEmpty()) {
			throw new CampoVacioException();
		}
		try {
			HashMap<String, Object> datosAActualizar = new HashMap<String, Object>();
			datosAActualizar.put("email", email);
			datosAActualizar.put("nombre", nombre);
			datosAActualizar.put("contrasenia", contrasenia);
			datosAActualizar.put("telefono", Integer.parseInt(telefono));
			HashMap<String, Object> restricciones = new HashMap<String, Object>();
			restricciones.put("email", email);
			DAO.actualizar("Trabajador", datosAActualizar, restricciones);
			return new Trabajador(email, nombre, contrasenia, Integer.parseInt(telefono));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Trabajador añadirTrabajador(String email, String nombre, String contrasenia, String telefono)
			throws SQLException, CampoVacioException, NumberFormatException {
		if (email.isEmpty() || nombre.isEmpty() || contrasenia.isEmpty() || telefono.isEmpty()) {
			throw new CampoVacioException();
		}
		HashMap<String, Object> columnas = new HashMap<String, Object>();
		columnas.put("email", email);
		columnas.put("nombre", nombre);
		columnas.put("contrasenia", contrasenia);
		columnas.put("telefono", Integer.parseInt(telefono));
		DAO.insert("Trabajador", columnas);
		return new Trabajador(email, nombre, contrasenia, Integer.parseInt(telefono));
	}

	public static Trabajador consultarTrabajador(String email, String contrasenia)
			throws SQLException, UsuarioNoExisteException, CampoVacioException {
		if (email.isEmpty() || contrasenia.isEmpty()) {
			throw new CampoVacioException();
		}
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<>();
		columnasSelect.add("email");
		columnasSelect.add("nombre");
		columnasSelect.add("contrasenia");
		columnasSelect.add("telefono");
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("email", email);
		restricciones.put("contrasenia", contrasenia);

		ArrayList<Object> resultado = DAO.consultar("Trabajador", columnasSelect, restricciones);
		if (resultado.isEmpty()) {
			throw new UsuarioNoExisteException("El trabajador no existe");
		} else {
			String emailResultado = String.valueOf(resultado.get(0));
			String nombre = String.valueOf(resultado.get(1));
			String contraseniaResultado = String.valueOf(resultado.get(2));
			int telefono = (int) resultado.get(3);
			Trabajador tResult = new Trabajador(emailResultado, nombre, contraseniaResultado, telefono);
			return tResult;
		}
	}

	public static void añadirProducto(String nombre, String precio, String tipoProducto)
			throws SQLException, CampoVacioException, NumberFormatException {
		if (nombre.isEmpty() || precio.isEmpty()) {
			throw new CampoVacioException();
		}
		float precioF = Float.parseFloat(precio);

		HashMap<String, Object> campos = new HashMap<>();
		campos.put("nombre", nombre);
		campos.put("precio", precioF);
		campos.put("tipoProducto", tipoProducto);

		DAO.insert("Producto", campos);
	}

	public static void añadirMesa(String numero, String capacidad)
			throws SQLException, CampoVacioException, NumberFormatException {
		if (numero.isEmpty() || capacidad.isEmpty()) {
			throw new CampoVacioException();
		}
		int numeroInt = Integer.parseInt(numero);
		int capacidadInt = Integer.parseInt(capacidad);

		LinkedHashMap<String, Object> campos = new LinkedHashMap<>();
		campos.put("numero", numeroInt);
		campos.put("capacidad", capacidadInt);
		campos.put("estaOcupada", 0);
		DAO.insert("Mesa", campos);
	}





}
