package interfaces;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Mesa;
import utils.DAO;

public class PantallaMarcarMesaOcupada extends JPanel {

	private Ventana ventana;
	private DefaultListModel<Mesa> modelMesasLibres = new DefaultListModel<Mesa>();
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();

	public PantallaMarcarMesaOcupada(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mesas ocupadas : ");
		lblNewLabel.setBounds(10, 29, 46, 14);
		add(lblNewLabel);

		final JList<Mesa> listaMesasMarcarLibre = new JList<Mesa>();
		listaMesasMarcarLibre.setBounds(38, 54, 283, 223);
		add(listaMesasMarcarLibre);
		listaMesasMarcarLibre.setModel(modelMesasLibres);

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("numero");
		columnasSelect.add("capacidad");
		columnasSelect.add("estaOcupada");
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("estaOcupada", 0);

		try {
			ArrayList<Object> mesasConsultar = DAO.consultar("Mesa", columnasSelect, restricciones);
			ArrayList<Mesa> mesas = new ArrayList<Mesa>();
			for (byte i = 0; i < mesasConsultar.size(); i += 3) {
				int numero = (int) mesasConsultar.get(i);
				int capacidad = (int) mesasConsultar.get(i + 1);
				int estaOcupada = (int) mesasConsultar.get(i + 2);
				Mesa m = new Mesa(numero, capacidad, estaOcupada);
				mesas.add(m);
				modelMesasLibres.addElement(m);
			}
			System.out.println(mesas);
//			for (Mesa mesa : mesas) {
//					modelMesasOcupadas.addElement("Numero de mesa :\n " + mesa.getNumero() + "\n" + ", " + "Capacidad : "
//							+ mesa.getCapacidad() + "\n");
//				
//
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton marcarOcupadaButton = new JButton("Marcar ocupada");
		marcarOcupadaButton.setBounds(331, 200, 109, 23);
		add(marcarOcupadaButton);

		marcarOcupadaButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				try {
					Mesa m = listaMesasMarcarLibre.getSelectedValue();
					HashMap<String, Object> camposMarcarLibre = new HashMap<String, Object>();
					camposMarcarLibre.put("estaOcupada", 1);
					HashMap<String, Object> restricciones = new HashMap<String, Object>();
					restricciones.put("estaOcupada", 0);
					restricciones.put("numero", m.getNumero());
					DAO.actualizar("Mesa", camposMarcarLibre, restricciones);
					modelMesasLibres.removeElement(m);
					JOptionPane.showMessageDialog(ventana, "Mesa editada con exito.", "Mesa editada",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana,
							"Error al editar la mesa, es posible que la mesa indicada no exista", "Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(ventana, "Inidique qué mesa quiere marcar primero", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(331, 245, 89, 23);
		add(salirButton);

		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});
	}

}
