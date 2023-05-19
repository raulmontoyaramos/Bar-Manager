package clases;

import java.util.ArrayList;

public class Producto {

//	-BufferedImage: En Java, una foto puede representarse utilizando un objeto del tipo "BufferedImage".
//	BufferedImage es una clase que hereda de la clase abstracta Image y proporciona una 
//	representación en memoria de una imagen. Puede almacenar diferentes tipos de datos de píxeles, 
//	como píxeles en escala de grises, RGB o ARGB.
//	En un objeto BufferedImage, se puede acceder y manipular los píxeles individualmente utilizando 
//	métodos como "getRGB()" y "setRGB()". Además, también se pueden realizar diversas operaciones de 
//	procesamiento de imágenes utilizando las funcionalidades proporcionadas por la clase BufferedImage 
//	y otras clases relacionadas en la biblioteca Java 2D.

//	-File: Puede utilizar el tipo de dato File para representar una foto como un archivo en el sistema de archivos. 
//	Esto permite leer y escribir la foto desde y hacia el disco.

//  -InputStream/OutputStream: Puede utilizar flujos de entrada (InputStream) y flujos de salida (OutputStream) 
//	para manejar la lectura y escritura de la foto desde o hacia diferentes fuentes, como archivos, bases de datos 
//	o conexiones de red.

//	-byte[]: Puede representar una foto como una matriz de bytes (byte[]) que contiene los datos de la imagen. 
//	Esto puede ser útil para transmitir o almacenar la foto en forma de datos binarios.

//	-ImageIO: La clase ImageIO en Java proporciona métodos para leer y escribir imágenes en diferentes formatos, 
//	como JPEG, PNG o GIF. Puede utilizar los métodos de ImageIO para cargar una imagen en memoria y trabajar con ella.

	private String nombre;
	private float precio;
	private String foto;
	private boolean esFrio;

	public Producto(String nombre, float precio, boolean esFrio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.esFrio = esFrio;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isEsFrio() {
		return esFrio;
	}

	public void setEsFrio(boolean esFrio) {
		this.esFrio = esFrio;
	}

	@Override
	public String toString() {
		return "\n\t -Nombre: " + this.nombre + "\n\t -Precio: " + this.precio + "\n\t -¿Es frío?: " + this.esFrio
				+ "\n\t -Entrantes: ";
	}

}
