package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaMenu extends JPanel {
	private Ventana ventana;

	public PantallaMenu(Ventana v) {
		this.ventana = v;
		setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 21);
		add(menuBar);
		JMenu menuMenu = new JMenu("Menu");
		menuBar.add(menuMenu);
		JMenuItem aniadirProductoMenuItem = new JMenuItem("Aniadir producto");
		menuMenu.add(aniadirProductoMenuItem);
		aniadirProductoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAñadirProducto.class);
			}
		});
		JMenuItem eliminarProductoMenuItem = new JMenuItem("Eliminar producto");
		menuMenu.add(eliminarProductoMenuItem);
		eliminarProductoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaEliminarProducto.class);
			}
		});
		JMenu mesaMenu = new JMenu("Mesa");
		menuBar.add(mesaMenu);
		JMenuItem aniadirMesaMenuItem = new JMenuItem("Aniadir mesa");
		mesaMenu.add(aniadirMesaMenuItem);
		aniadirMesaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAniadirMesa.class);
			}
		});
		JMenuItem eliminarMesaMenuItem = new JMenuItem("Eliminar mesa");
		mesaMenu.add(eliminarMesaMenuItem);
		eliminarMesaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaEliminarMesa.class);
			}
		});
		JMenu trabajadorMenu = new JMenu("Trabajador");
		menuBar.add(trabajadorMenu);
		JMenuItem editarTrabajadorMenuItem = new JMenuItem("Editar trabajador");
		trabajadorMenu.add(editarTrabajadorMenuItem);
		editarTrabajadorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaEditarTrabajador.class);
			}
		});
		JMenuItem despedirTrabajadorMenuItem = new JMenuItem("Despedir trabajador");
		trabajadorMenu.add(despedirTrabajadorMenuItem);
		despedirTrabajadorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaDespedirTrabajador.class);
			}
		});
		JButton verMenuButton = new JButton("Ver Menu");
		verMenuButton.setBounds(176, 160, 89, 23);
		add(verMenuButton);
		verMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenuBar.class);
			}
		});
		JButton marcarMesaLibreButton = new JButton("Marcar mesa libre");
		marcarMesaLibreButton.setBounds(176, 200, 142, 23);
		add(marcarMesaLibreButton);
		marcarMesaLibreButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMarcarMesaLibre.class);
			}
		});
		JButton marcarMesaOcupadaButton = new JButton("Marcar mesa ocupada");
		marcarMesaOcupadaButton.setBounds(176, 240, 186, 23);
		add(marcarMesaOcupadaButton);
		marcarMesaOcupadaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMarcarMesaOcupada.class);
			}
		});
		JButton pedirPlatoButton = new JButton("Pedir plato");
		pedirPlatoButton.setBounds(176, 280, 142, 23);
		add(pedirPlatoButton);
		pedirPlatoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaPedirPlato.class);
			}
		});
		JButton platosPedidosButton = new JButton("Platos pedidos");
		platosPedidosButton.setBounds(176, 320, 142, 23);
		add(platosPedidosButton);
		platosPedidosButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaPlatosPedidos.class);
			}
		});
		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(176, 360, 89, 23);
		add(salirButton);
		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		JLabel opcionesLabel = new JLabel("Que desea realizar?");
		opcionesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		opcionesLabel.setBounds(166, 123, 180, 14);
		add(opcionesLabel);
	}

}
