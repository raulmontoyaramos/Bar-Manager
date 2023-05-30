package interfaces;

import javax.swing.JPanel;

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
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class PantallaMenu extends PanelMadre {
	private Ventana ventana;

	public PantallaMenu(Ventana v) {
		this.ventana = v;
		setLayout(null);
		JButton aniadirProductoButton = new JButton("Aniadir producto");
		aniadirProductoButton.setBounds(20, 36, 133, 23);
		aniadirProductoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaAñadirProducto.class);

			}
		});
		add(aniadirProductoButton);

		JLabel opcionesLabel = new JLabel("Que desea realizar?");
		opcionesLabel.setBounds(10, 11, 100, 14);
		add(opcionesLabel);

		JButton verMenuButton = new JButton("Ver Menu");
		verMenuButton.setBounds(20, 70, 89, 23);
		add(verMenuButton);

		verMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenuBar.class);

			}
		});

		JButton botonEliminarProducto = new JButton("Eliminar producto");
		botonEliminarProducto.setBounds(193, 36, 142, 23);
		add(botonEliminarProducto);

		botonEliminarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaEliminarProducto.class);

			}
		});

		JButton verMesasLibresButton = new JButton("Ver mesas libres");
		verMesasLibresButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		verMesasLibresButton.setBounds(193, 70, 142, 23);
		add(verMesasLibresButton);

		verMesasLibresButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMesasLibres.class);

			}
		});

		JButton verMesasOcupadasButton = new JButton("Ver mesas ocupadas");
		verMesasOcupadasButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		verMesasOcupadasButton.setBounds(20, 116, 142, 23);
		add(verMesasOcupadasButton);

		verMesasOcupadasButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMesasOcupadas.class);

			}
		});

		JButton botonAniadirMesa = new JButton("Aniadir mesa");
		botonAniadirMesa.setBounds(193, 116, 132, 23);
		add(botonAniadirMesa);

		botonAniadirMesa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaAniadirMesa.class);

			}
		});

		JButton eliminarMesaButton = new JButton("Eliminar Mesa");
		eliminarMesaButton.setBounds(20, 164, 142, 23);
		add(eliminarMesaButton);

		eliminarMesaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaEliminarMesa.class);

			}
		});
		
		JButton platosPedidosButton = new JButton("Platos pedidos");
		platosPedidosButton.setBounds(193, 164, 142, 23);
		add(platosPedidosButton);
		
		platosPedidosButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaPlatosPedidos.class);

			}
		});
	}
}
