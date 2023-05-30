package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JButton;

public class PantallaPlatosPedidos extends JPanel {

	private Ventana ventana;
	
	public PantallaPlatosPedidos(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Platos pedidos :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(30, 39, 116, 14);
		add(lblNewLabel);
		
		JList listaPlatosPedidos = new JList();
		listaPlatosPedidos.setBounds(51, 74, 389, 285);
		add(listaPlatosPedidos);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setBounds(408, 370, 89, 23);
		add(botonSalir);
		
		botonSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});
	}
}
