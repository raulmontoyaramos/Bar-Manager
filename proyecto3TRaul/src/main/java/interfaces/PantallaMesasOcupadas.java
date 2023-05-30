package interfaces;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import clases.Mesa;
import utils.DAO;

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

public class PantallaMesasOcupadas extends JPanel {
	public PantallaMesasOcupadas(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MESAS OCUPADAS : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 23, 175, 23);
		add(lblNewLabel);
		
		JList<String> listaMesasOcupadas = new JList<String>();
		listaMesasOcupadas.setBounds(20, 57, 324, 208);
		add(listaMesasOcupadas);
		listaMesasOcupadas.setModel(modelMesasOcupadas);
		
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
				int numero = (int) mesasConsultar.get(i);
				int capacidad = (int) mesasConsultar.get(i + 1);
				int estaOcupada = (int) mesasConsultar.get(i + 2);
				Mesa m = new Mesa(numero, capacidad, estaOcupada);
				mesas.add(m);
			}
			System.out.println(mesas);
			for (Mesa mesa : mesas) {
					modelMesasOcupadas.addElement("Numero de mesa :\n " + mesa.getNumero() + "\n" + ", " + "Capacidad : "
							+ mesa.getCapacidad() + "\n");
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(340, 276, 89, 23);
		add(salirButton);
		
		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});
	}

	private Ventana ventana;
	private DefaultListModel<String> modelMesasOcupadas = new DefaultListModel<String>();
	
	
	
}
