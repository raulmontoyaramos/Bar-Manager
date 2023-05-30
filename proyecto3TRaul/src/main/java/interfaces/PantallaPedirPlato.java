package interfaces;

import javax.swing.JPanel;

import clases.Mesa;
import clases.Producto;
import clases.ProductoConId;
import enumeraciones.TipoProducto;
import utils.DAO;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PantallaPedirPlato extends JPanel {

	private Ventana ventana;
	private DefaultListModel<ProductoConId> model = new DefaultListModel<ProductoConId>();
	private ArrayList<ProductoConId> productos = new ArrayList<ProductoConId>();

	public PantallaPedirPlato(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("PEDIR PLATO");
		lblNewLabel.setBounds(10, 31, 90, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Seleccionar mesa :");
		lblNewLabel_1.setBounds(10, 61, 111, 14);
		add(lblNewLabel_1);

		final JComboBox<Mesa> comboBox = new JComboBox<Mesa>();
		comboBox.setBounds(20, 86, 202, 22);
		add(comboBox);
		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("numero");
		columnasSelect.add("capacidad");
		columnasSelect.add("estaOcupada");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("estaOcupada", 1);
		try {
			ArrayList<Object> mesasConsultar = DAO.consultar("Mesa", columnasSelect, restricciones);
			ArrayList<Mesa> mesas = new ArrayList<Mesa>();
			for (byte i = 0; i < mesasConsultar.size(); i += 3) {
				int numero = (int) mesasConsultar.get(i); // numero era short, capacidad era byte y estaOcupada boolean
				int capacidad = (int) mesasConsultar.get(i + 1);// pero no me funcionaban los casteos de otra forma, he
				int estaOcupada = (int) mesasConsultar.get(i + 2);// tenido que cambiar los tipos en la clase Mesa

				Mesa m = new Mesa(numero, capacidad, estaOcupada);
				mesas.add(m);
			}
			System.out.println(mesas);
			for (Mesa mesa : mesas) {
				comboBox.addItem(mesa);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblNewLabel_2 = new JLabel("Seleccionar plato :");
		lblNewLabel_2.setBounds(260, 61, 111, 14);
		add(lblNewLabel_2);

		final JList<ProductoConId> listaPlatos = new JList<ProductoConId>();
		listaPlatos.setBounds(270, 89, 246, 266);
		add(listaPlatos);
		listaPlatos.setModel(model);

		LinkedHashSet<String> columnasSelectProducto = new LinkedHashSet<String>();
		columnasSelectProducto.add("id");
		columnasSelectProducto.add("nombre");
		columnasSelectProducto.add("precio");
		columnasSelectProducto.add("foto");
		columnasSelectProducto.add("tipoProducto");
		try {
			ArrayList<Object> productosConsultar = DAO.consultar("Producto", columnasSelectProducto,
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

		JButton aniadirButton = new JButton("Aniadir plato");
		aniadirButton.setBounds(446, 413, 111, 23);
		add(aniadirButton);

		aniadirButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HashMap<String, Object> campos = new HashMap<String, Object>();
				campos.put("numero_mesa", ((Mesa) comboBox.getSelectedItem()).getNumero());
				campos.put("id_producto", ((ProductoConId) listaPlatos.getSelectedValue()).getId());
				try {
					DAO.insert("Mesa_Producto", campos);
					JOptionPane.showMessageDialog(ventana, "Plato pedido", "Pedir plato",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(314, 413, 89, 23);
		add(salirButton);

		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});

	}
}
