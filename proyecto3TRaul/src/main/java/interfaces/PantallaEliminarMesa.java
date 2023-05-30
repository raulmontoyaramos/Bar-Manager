package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import clases.Mesa;
import clases.Producto;
import clases.ProductoConId;
import enumeraciones.TipoProducto;
import utils.DAO;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class PantallaEliminarMesa extends JPanel {

	private Ventana ventana;
	private DefaultListModel<Mesa> model = new DefaultListModel<Mesa>();
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();

	public PantallaEliminarMesa(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mesas :");
		lblNewLabel.setBounds(38, 38, 46, 14);
		add(lblNewLabel);

		final JList<Mesa> listaMesasEliminar = new JList<Mesa>();
		listaMesasEliminar.setBounds(38, 75, 366, 302);
		add(listaMesasEliminar);
		listaMesasEliminar.setModel(model);

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("numero");
		columnasSelect.add("capacidad");
		columnasSelect.add("estaOcupada");

		try {
			ArrayList<Object> mesasConsultar = DAO.consultar("Mesa", columnasSelect, new HashMap<String, Object>());
			for (byte i = 0; i < mesasConsultar.size(); i += 3) {
				int numero = (int) mesasConsultar.get(i);
				int capacidad = (int) mesasConsultar.get(i + 1);
				int estaOcupada = (int) mesasConsultar.get(i + 2);
				Mesa m = new Mesa(numero, capacidad, estaOcupada);
				mesas.add(m);
				model.addElement(m);
			}
			System.out.println(mesas);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(418, 354, 89, 23);
		add(salirButton);

		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});

		JButton eliminarButton = new JButton("Eliminar");
		eliminarButton.setBounds(418, 288, 89, 23);
		add(eliminarButton);

		eliminarButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Mesa m = listaMesasEliminar.getSelectedValue();
				HashMap<String, Object> camposEliminar = new HashMap<String, Object>();
				camposEliminar.put("numero", m.getNumero());

				try {
					DAO.delete("Mesa", camposEliminar);
					model.removeElement(m);
					JOptionPane.showMessageDialog(ventana, "Mesa eliminada con exito.", "Mesa eliminada",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana,
							"Error al eliminar la mesa, es posible que la mesa indicada no exista", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
	}

}
