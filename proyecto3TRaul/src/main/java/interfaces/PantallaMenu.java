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

public class PantallaMenu extends PanelMadre {
	private Ventana ventana;

	public PantallaMenu(Ventana v) {
		this.ventana = v;
		setLayout(null);
		JButton aniadirProductoButton = new JButton("Aniadir producto");
		aniadirProductoButton.setBounds(20, 36, 119, 23);
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

	}
}
