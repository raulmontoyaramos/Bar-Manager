package interfaces;

import javax.swing.JPanel;

import clases.Producto;
import enumeraciones.TipoProducto;
import utils.DAO;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.JList;
import javax.swing.JButton;

public class PantallaMenuBar extends JPanel {

	private Ventana ventana;
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private DefaultListModel<String> modelPlatos = new DefaultListModel<String>();

	public PantallaMenuBar(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel etiquetaMenu = new JLabel("MENU :");
		etiquetaMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiquetaMenu.setBounds(32, 11, 75, 14);
		add(etiquetaMenu);

		JLabel etiquetaBebidas = new JLabel("Bebidas :");
		etiquetaBebidas.setBounds(10, 50, 46, 14);
		add(etiquetaBebidas);

		JList<String> listaBebidas = new JList<String>();
		listaBebidas.setBounds(83, 36, 136, 114);
		add(listaBebidas);
		listaBebidas.setModel(model);

		JList<String> listaPlatos = new JList<String>();
		listaPlatos.setBounds(354, 36, 183, 245);
		add(listaPlatos);
		listaPlatos.setModel(modelPlatos);
		
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("nombre");
		columnasSelect.add("precio");
		columnasSelect.add("foto");
		columnasSelect.add("tipoProducto");
		try {
			ArrayList<Object> productosConsultar = DAO.consultar("Producto", columnasSelect,
					new HashMap<String, Object>());
			ArrayList<Producto> productos = new ArrayList<Producto>();
			for (byte i = 0; i < productosConsultar.size(); i += 4) {
				String nombre = (String) productosConsultar.get(i);
				float precio = (int) productosConsultar.get(i + 1);
				String foto = (String) productosConsultar.get(i + 2);
				TipoProducto tipoProducto = Producto.aTipoProducto((String) productosConsultar.get(i + 3));
				Producto p = new Producto(nombre, precio, foto, tipoProducto);
				productos.add(p);
			}
			System.out.println(productos);
			for (Producto producto : productos) {
				if (producto.getTipoProducto() == TipoProducto.BEBIDA) {

					model.addElement(producto.getNombre() + ", " + producto.getPrecio());
				} else {
					modelPlatos.addElement(producto.getNombre() + ", " + producto.getPrecio());

				}
			}
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

		JLabel lblNewLabel = new JLabel("Platos :");
		lblNewLabel.setBounds(276, 50, 46, 14);
		add(lblNewLabel);

		

	}
}
