package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Producto;
import enumeraciones.TipoProducto;
import utils.DAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class PantallaAñadirProducto extends JPanel {
	private JTextField campoNombre;
	private JTextField campoPrecio;
	private JTextField campoFoto;
	private Ventana ventana;

	public PantallaAñadirProducto(Ventana v) {
		setLayout(null);
		this.ventana = v;
		JLabel lblNewLabel = new JLabel("Introduzca la informacion del producto");
		lblNewLabel.setBounds(10, 11, 192, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(31, 38, 81, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Precio");
		lblNewLabel_1_1.setBounds(31, 60, 81, 14);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Foto");
		lblNewLabel_1_1_1.setBounds(31, 85, 81, 14);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tipo de producto");
		lblNewLabel_1_1_1_1.setBounds(31, 110, 94, 14);
		add(lblNewLabel_1_1_1_1);

		campoNombre = new JTextField();
		campoNombre.setColumns(10);
		campoNombre.setBounds(116, 36, 153, 20);
		add(campoNombre);

		campoPrecio = new JTextField();
		campoPrecio.setColumns(10);
		campoPrecio.setBounds(116, 60, 153, 20);
		add(campoPrecio);

		campoFoto = new JTextField();
		campoFoto.setColumns(10);
		campoFoto.setBounds(116, 82, 153, 20);
		add(campoFoto);

		final JComboBox<String> tiposProductosComboBox = new JComboBox<String>();
		tiposProductosComboBox.setBounds(116, 106, 153, 22);
		add(tiposProductosComboBox);
		for (TipoProducto tipo : TipoProducto.values()) {
			tiposProductosComboBox.addItem(tipo.name());

		}
		JButton aniadirButton = new JButton("Aniadir");
		aniadirButton.setBounds(196, 240, 89, 23);
		aniadirButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// mas adelante meto los atributos de Producto
				String nombre = campoNombre.getText();
				String precio = campoPrecio.getText();
				String foto = campoFoto.getText();
				String tipoProducto = (String) tiposProductosComboBox.getSelectedItem();

				Producto p1 = new Producto(nombre, Float.parseFloat(precio), foto,
						Producto.aTipoProducto(tipoProducto));

				HashMap<String, Object> columnas = new HashMap<>();
				columnas.put("nombre", p1.getNombre());
				columnas.put("precio", p1.getPrecio());
				columnas.put("foto", p1.getFoto());
				columnas.put("tipoProducto", p1.getTipoProducto().name());

				try {
					DAO.insert("Producto", columnas);
					JOptionPane.showMessageDialog(ventana, "Producto añadido con exito", "Producto añadido",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana,
							"Error al añadir el producto, es posible que haya rellenado un campo con un valor invalido",
							"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		add(aniadirButton);

		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(313, 240, 89, 23);
		add(salirButton);
		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});

	}
}
