package interfaces;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import clases.Mesa;
import clases.Producto;
import enumeraciones.TipoProducto;
import utils.DAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.JButton;
import javax.swing.JList;

public class PantallaMesasLibres extends JPanel {

	private Ventana ventana;
	private DefaultListModel<String> modelMesasLibres = new DefaultListModel<String>();
	private DefaultListModel<String> modelMesasOcupadas = new DefaultListModel<String>();

	public PantallaMesasLibres(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("MESAS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(33, 33, 89, 34);
		add(lblNewLabel);

		JList<String> listaMesasLibres = new JList<String>();
		listaMesasLibres.setBounds(33, 117, 346, 212);
		add(listaMesasLibres);
		listaMesasLibres.setModel(modelMesasLibres);

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
				int numero = (int) mesasConsultar.get(i); // numero era short, capacidad era byte y estaOcupada boolean
				int capacidad = (int) mesasConsultar.get(i + 1);// pero no me funcionaban los casteos de otra forma, he
				int estaOcupada = (int) mesasConsultar.get(i + 2);// tenido que cambiar los tipos en la clase Mesa
				boolean ocupada = false;
				if(estaOcupada==1) {
					ocupada=true;
				}
				Mesa m = new Mesa(numero, capacidad, ocupada);
				mesas.add(m);
			}
			System.out.println(mesas);
			for (Mesa mesa : mesas) {// Si funcionase el \n podría tener una lista d mesasLibres y otra de ocupadas
										// en ésta pantalla, como no puedo esta es de libres y hay otra de ocupadas
				modelMesasLibres.addElement("Numero de mesa :\n " + mesa.getNumero() + "\n" + ", " + "Capacidad : "
						+ mesa.getCapacidad() + "\n");

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton botonSalir = new JButton("Salir");
		botonSalir.setBounds(321, 346, 77, 18);
		add(botonSalir);

		JLabel lblNewLabel_1 = new JLabel("Mesas libres:");
		lblNewLabel_1.setBounds(10, 78, 112, 18);
		add(lblNewLabel_1);

		botonSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});
	}
}
