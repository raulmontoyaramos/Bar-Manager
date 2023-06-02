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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PantallaPlatosPedidos extends JPanel {

	private Ventana ventana;
	private DefaultListModel<ProductoConId> model = new DefaultListModel<ProductoConId>();
	private ArrayList<ProductoConId> productos = new ArrayList<ProductoConId>();

	public PantallaPlatosPedidos(Ventana v) {
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

		final JList<ProductoConId> listaPlatos = new JList<ProductoConId>();
		listaPlatos.setBounds(270, 89, 246, 266);
		add(listaPlatos);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarPlatos(comboBox, listaPlatos);
			}

		});

		JLabel lblNewLabel_2 = new JLabel("Platos pedidos :");
		lblNewLabel_2.setBounds(260, 61, 111, 14);
		add(lblNewLabel_2);

		
		listaPlatos.setModel(model);

		actualizarPlatos(comboBox, listaPlatos);

		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(444, 413, 89, 23);
		add(salirButton);

		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});

		JButton pedirCuentaButton = new JButton("Pedir cuenta");
		pedirCuentaButton.setBounds(300, 413, 122, 23);
		add(pedirCuentaButton);

		pedirCuentaButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				try {
					LinkedHashSet<String> columnasSelectJoin = new LinkedHashSet<String>();
					columnasSelectJoin.add("p.id");
					columnasSelectJoin.add("p.nombre");
					columnasSelectJoin.add("p.precio");
					columnasSelectJoin.add("p.tipoProducto");
					ArrayList<Object> consultaJoin = DAO.consultar(
							"Mesa_Producto mp INNER JOIN Producto p on mp.numero_mesa = "
									+ ((Mesa) comboBox.getSelectedItem()).getNumero()+" GROUP BY mp.id",
							columnasSelectJoin, new HashMap<String, Object>());
					ArrayList<ProductoConId> platosPedidos = new ArrayList<ProductoConId>();
					float precioTotal = 0;
					for (byte i = 0; i < consultaJoin.size(); i += 4) {
						Integer id = (Integer) consultaJoin.get(i);
						String nombre = (String) consultaJoin.get(i + 1);
						float precio = (int) consultaJoin.get(i + 2);
						TipoProducto tipoProducto = Producto.aTipoProducto((String) consultaJoin.get(i + 3));
						ProductoConId p = new ProductoConId(id, nombre, precio, tipoProducto);
						platosPedidos.add(p);
						precioTotal += precio;
						System.out.println("Mesa : ");
					}
					JOptionPane.showMessageDialog(ventana, "Precio total : " + precioTotal, "Cuenta",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(ventana, "Debe haber pedido plato/s primero", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private void actualizarPlatos(final JComboBox<Mesa> comboBox, final JList<ProductoConId> listaPlatos) {
		try {
			model.clear();
			productos = platosPedidos(((Mesa) comboBox.getSelectedItem()).getNumero());
			for (ProductoConId productoConId : productos) {
				model.addElement(productoConId);
			}
			System.out.println(productos);
			listaPlatos.revalidate();
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
	}

	public static ArrayList<ProductoConId> platosPedidos(int numeroMesa) throws SQLException {

		LinkedHashSet<String> columnasSelectJoin = new LinkedHashSet<String>();
		columnasSelectJoin.add("p.id");
		columnasSelectJoin.add("p.nombre");
		columnasSelectJoin.add("p.precio");
		columnasSelectJoin.add("p.tipoProducto");
		ArrayList<Object> consultaJoin = DAO.consultar(
				"Mesa_Producto mp INNER JOIN Producto p on mp.numero_mesa = " + numeroMesa+" GROUP BY mp.id", columnasSelectJoin,
				new HashMap<String, Object>());
		ArrayList<ProductoConId> platosPedidos = new ArrayList<ProductoConId>();
		for (byte i = 0; i < consultaJoin.size(); i += 4) {
			Integer id = (Integer) consultaJoin.get(i);
			String nombre = (String) consultaJoin.get(i + 1);
			float precio = (int) consultaJoin.get(i + 2);
			TipoProducto tipoProducto = Producto.aTipoProducto((String) consultaJoin.get(i + 3));
			ProductoConId p = new ProductoConId(id, nombre, precio, tipoProducto);
			platosPedidos.add(p);

		}
		return platosPedidos;
	}

}