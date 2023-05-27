package clases;

import enumeraciones.TipoProducto;

public class ProductoConId extends Producto {

	private Integer id;

	public ProductoConId(Integer id, String nombre, float precio, String foto, TipoProducto tipoProducto) {
		super(nombre, precio, foto, tipoProducto);

		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getNombre() + ", " + getTipoProducto().name();
	}

}
