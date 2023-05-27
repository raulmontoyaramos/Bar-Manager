package interfaces;

import javax.swing.JPanel;

import clases.Producto;
import utils.DAO;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.JList;
import javax.swing.JButton;

public class PantallaMenuBar extends JPanel {

	private Ventana ventana;
	private DefaultListModel<String> model = new DefaultListModel<String>();

	public PantallaMenuBar(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel etiquetaMenu = new JLabel("MENU :");
		etiquetaMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiquetaMenu.setBounds(32, 11, 75, 14);
		add(etiquetaMenu);

		JLabel etiquetaBebidas = new JLabel("Bebidas :");
		etiquetaBebidas.setBounds(32, 58, 46, 14);
		add(etiquetaBebidas);

		JList<String> listaBebidas = new JList<String>();
		listaBebidas.setBounds(121, 49, 136, 114);
		add(listaBebidas);

		listaBebidas.setModel(model);

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
//		columnasSelect.add("id");
		columnasSelect.add("nombre");
//		columnasSelect.add("precio");
//		columnasSelect.add("foto");
//		columnasSelect.add("tipoProducto");
		try {
			ArrayList<Object> productos = DAO.consultar("Producto", columnasSelect, new HashMap<String, Object>());
			System.out.println(productos);
			for (Object object : productos) {
//				Producto producto = (Producto) object;
				model.addElement(object.toString());
//				model.addElement(producto.getNombre() + ", " + producto.getPrecio());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
