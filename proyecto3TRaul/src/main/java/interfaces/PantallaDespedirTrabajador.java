package interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import clases.Mesa;
import clases.Trabajador;
import utils.DAO;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class PantallaDespedirTrabajador extends JPanel {

	private Ventana ventana;
	private DefaultListModel<Trabajador> model = new DefaultListModel<Trabajador>();
	private ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();

	public PantallaDespedirTrabajador(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Bienvenido");
		add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JButton salirButton = new JButton("Salir");
		panel.add(salirButton);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		final JPanel contenedorElementos = new JPanel();
		scrollPane.setViewportView(contenedorElementos);
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<String>();
		columnasSelect.add("email");
		columnasSelect.add("nombre");
		columnasSelect.add("telefono");

		try {
			ArrayList<Object> trabajadoresConsultar = DAO.consultar("Trabajador", columnasSelect,
					new HashMap<String, Object>());
			ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
			for (short i = 0; i < trabajadoresConsultar.size(); i += 3) {
				String email = (String) trabajadoresConsultar.get(i);
				String nombre = (String) trabajadoresConsultar.get(i + 1);
				int telefono = (int) trabajadoresConsultar.get(i + 2);
				Trabajador t = new Trabajador(email, nombre, "", telefono);
				trabajadores.add(t);
				contenedorElementos.add(new ElementoLista(ventana, t));
			}
			System.out.println(trabajadores);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton eliminarButton = new JButton("Eliminar");
		panel.add(eliminarButton);

		eliminarButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}
		});

	}
}
