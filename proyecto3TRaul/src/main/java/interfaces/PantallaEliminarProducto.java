package interfaces;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import clases.Producto;
import clases.ProductoConId;
import enumeraciones.TipoProducto;
import utils.DAO;

public class PantallaEliminarProducto extends JPanel {

	private Ventana ventana;
	private DefaultListModel<ProductoConId> model = new DefaultListModel<ProductoConId>();
	private ArrayList<ProductoConId> productos = new ArrayList<ProductoConId>();

	public PantallaEliminarProducto(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel etiquetaMenu = new JLabel("MENU :");
		etiquetaMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiquetaMenu.setBounds(32, 11, 75, 14);
		add(etiquetaMenu);

		final JList<ProductoConId> listaProductos = new JList<ProductoConId>();
		listaProductos.setBounds(116, 36, 183, 245);
		add(listaProductos);
		listaProductos.setModel(model);

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("id");
		columnasSelect.add("nombre");
		columnasSelect.add("precio");
		columnasSelect.add("foto");
		columnasSelect.add("tipoProducto");
		try {
			ArrayList<Object> productosConsultar = DAO.consultar("Producto", columnasSelect,
					new HashMap<String, Object>());
			for (byte i = 0; i < productosConsultar.size(); i += 5) {
				Integer id = (Integer) productosConsultar.get(i);
				String nombre = (String) productosConsultar.get(i + 1);
				float precio = (int) productosConsultar.get(i + 2);
				String foto = (String) productosConsultar.get(i + 3);
				TipoProducto tipoProducto = Producto.aTipoProducto((String) productosConsultar.get(i + 4));
				ProductoConId p = new ProductoConId(id, nombre, precio, foto, tipoProducto);
				productos.add(p);
				model.addElement(p);
			}
			System.out.println(productos);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(404, 320, 89, 23);
		add(salirButton);

		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});

		JLabel lblNewLabel = new JLabel("Productos :");
		lblNewLabel.setBounds(32, 37, 56, 14);
		add(lblNewLabel);

		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(404, 258, 89, 23);
		add(botonEliminar);

		botonEliminar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ProductoConId p = listaProductos.getSelectedValue();
				HashMap<String, Object> camposEliminar = new HashMap<String, Object>();
				camposEliminar.put("id", p.getId());

				try {
					DAO.delete("Producto", camposEliminar);
					model.removeElement(p);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}
