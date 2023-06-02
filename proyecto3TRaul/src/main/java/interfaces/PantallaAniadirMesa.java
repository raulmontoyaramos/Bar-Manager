package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Mesa;
import clases.Trabajador;
import excepciones.CampoVacioException;
import utils.DAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;

import javax.swing.JButton;

public class PantallaAniadirMesa extends JPanel {

	private Ventana ventana;
	private JTextField campoNumero;
	private JTextField campoCapacidad;

	public PantallaAniadirMesa(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Introduzca la informacion de la mesa :");
		lblNewLabel.setBounds(28, 36, 199, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numero :");
		lblNewLabel_1.setBounds(10, 72, 64, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Capacidad :");
		lblNewLabel_2.setBounds(10, 106, 64, 14);
		add(lblNewLabel_2);

		campoNumero = new JTextField();
		campoNumero.setBounds(161, 69, 111, 20);
		add(campoNumero);
		campoNumero.setColumns(10);

		campoCapacidad = new JTextField();
		campoCapacidad.setBounds(161, 103, 111, 20);
		add(campoCapacidad);
		campoCapacidad.setColumns(10);

		JButton botonAniadir = new JButton("Aniadir");
		botonAniadir.setBounds(193, 247, 89, 23);
		botonAniadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String numero = campoNumero.getText();
					String capacidad = campoCapacidad.getText();

					Trabajador.añadirMesa(numero, capacidad);
					JOptionPane.showMessageDialog(ventana, "Mesa añadida con exito", "Mesa añadida",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLIntegrityConstraintViolationException e4) {
					JOptionPane.showMessageDialog(ventana,
							"Error al añadir la mesa, ya existe una mesa con ese número, ingrese otro diferente",
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana,
							"Error al añadir la mesa, es posible que haya rellenado un campo con un valor invalido",
							"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (CampoVacioException e2) {
					JOptionPane.showMessageDialog(ventana, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(ventana, "Existe al menos un campo que admite solo números", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		add(botonAniadir);

		JButton botonSalir = new JButton("Salir");
		botonSalir.setBounds(320, 247, 89, 23);
		add(botonSalir);

		botonSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});
	}

}
