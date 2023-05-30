package interfaces;

import javax.swing.JPanel;

import clases.Mesa;
import clases.Trabajador;
import utils.DAO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;

public class ElementoLista extends JPanel {

	private Ventana ventana;
	private Trabajador trabajador;

	public ElementoLista(Ventana v, final Trabajador t) {
		this.ventana = v;
		this.trabajador = t;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelNombre = new JLabel(trabajador.getNombre());
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 0;
		gbc_labelNombre.gridy = 0;
		add(labelNombre, gbc_labelNombre);

		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);

		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				HashMap<String, Object> camposEliminar = new HashMap<String, Object>();
				camposEliminar.put("email", t.getEmail());

				try {
					DAO.delete("Trabajador", camposEliminar);
					JOptionPane.showMessageDialog(ventana, "Trabajador despedido.", "Despidos",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, "Error en el despido", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		JLabel labelEmail = new JLabel(trabajador.getEmail());
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 0;
		gbc_labelEmail.gridy = 1;
		add(labelEmail, gbc_labelEmail);

		JLabel labelTelefono = new JLabel("" + trabajador.getTelefono());
		GridBagConstraints gbc_labelTelefono = new GridBagConstraints();
		gbc_labelTelefono.anchor = GridBagConstraints.SOUTHWEST;
		gbc_labelTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_labelTelefono.gridx = 0;
		gbc_labelTelefono.gridy = 2;
		add(labelTelefono, gbc_labelTelefono);
	}
}
