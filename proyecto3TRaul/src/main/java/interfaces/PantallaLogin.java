package interfaces;

import javax.swing.JPanel;

import javax.swing.JTextField;

import clases.Trabajador;
import excepciones.CampoVacioException;
import excepciones.UsuarioNoExisteException;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PantallaLogin extends JPanel {
	private JTextField campoNombreRegistro;
	private JTextField campoEmailRegistro;
	private JTextField campoTelefonoRegistro;
	private JTextField campoEmailInicioSesion;
	private JPasswordField campoContraseniaInicioSesion;
	private JPasswordField campoContraseniaRegistro;
	private Ventana ventana;

	public PantallaLogin(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel registrateOIniciaSesion = new JLabel("Hola! Registrate o inicia sesion para usar la tpv.");
		registrateOIniciaSesion.setBounds(57, 47, 243, 20);
		add(registrateOIniciaSesion);

		JLabel cartelRegistro = new JLabel("REGISTRO");
		cartelRegistro.setFont(new Font("Tahoma", Font.BOLD, 16));
		cartelRegistro.setBounds(138, 75, 86, 20);
		add(cartelRegistro);

		JLabel labelNombreRegistro = new JLabel("Nombre :");
		labelNombreRegistro.setBounds(57, 109, 56, 14);
		add(labelNombreRegistro);

		JLabel labelEmailRegistro = new JLabel("Email :");
		labelEmailRegistro.setBounds(57, 134, 46, 14);
		add(labelEmailRegistro);

		JLabel labelContraseniaRegistro = new JLabel("Contrasenia :");
		labelContraseniaRegistro.setBounds(57, 159, 89, 14);
		add(labelContraseniaRegistro);

		JLabel labelTelefonoRegistro = new JLabel("Telefono :");
		labelTelefonoRegistro.setBounds(57, 184, 56, 14);
		add(labelTelefonoRegistro);

		campoNombreRegistro = new JTextField();
		campoNombreRegistro.setToolTipText("Ingresa aquí tu nombre");
		campoNombreRegistro.setBounds(174, 106, 159, 20);
		add(campoNombreRegistro);
		campoNombreRegistro.setColumns(10);

		campoEmailRegistro = new JTextField();
		campoEmailRegistro.setToolTipText("Ingresa aquí tu email");
		campoEmailRegistro.setBounds(174, 131, 159, 20);
		add(campoEmailRegistro);
		campoEmailRegistro.setColumns(10);

		campoTelefonoRegistro = new JTextField();
		campoTelefonoRegistro.setToolTipText("Ingresa aquí tu telefono");
		campoTelefonoRegistro.setBounds(174, 181, 159, 20);
		add(campoTelefonoRegistro);
		campoTelefonoRegistro.setColumns(10);

		JLabel lineaDivisoria = new JLabel(
				"------------------------------------------------------------------------------------------------------------------------------------------------");
		lineaDivisoria.setBounds(10, 249, 580, 14);
		add(lineaDivisoria);

		JLabel cartelInicioSesion = new JLabel("INICO DE SESION");
		cartelInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		cartelInicioSesion.setBounds(138, 268, 148, 20);
		add(cartelInicioSesion);

		JLabel lblEmailInicioSesion = new JLabel("Email :");
		lblEmailInicioSesion.setBounds(57, 302, 46, 14);
		add(lblEmailInicioSesion);

		JLabel lblContraseniaInicioSesion = new JLabel("Contrasenia :");
		lblContraseniaInicioSesion.setBounds(57, 327, 89, 14);
		add(lblContraseniaInicioSesion);

		campoEmailInicioSesion = new JTextField();
		campoEmailInicioSesion.setToolTipText("Ingresa aquí tu email");
		campoEmailInicioSesion.setColumns(10);
		campoEmailInicioSesion.setBounds(174, 299, 159, 20);
		add(campoEmailInicioSesion);

		JButton aceptarRegistro = new JButton("Aceptar");
		aceptarRegistro.setBounds(343, 215, 89, 23);
		aceptarRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					// TODO: NO CONSIGO controlar que los campos no estén vacíos
					// DAO.insert para trabajador lo haga en el constructor de trabajador con todos
					// sus campos en vez de desde aquí
					String nombre = campoNombreRegistro.getText();
					String email = campoEmailRegistro.getText();
					String contrasenia = new String(campoContraseniaRegistro.getPassword());
					String telefono = campoTelefonoRegistro.getText();

					Trabajador trabajadorLogado = Trabajador.añadirTrabajador(email, nombre, contrasenia, telefono);
					JOptionPane.showMessageDialog(ventana, "Bienvenid@, " + nombre, "Registro exitoso",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.setTrabajadorLogado(trabajadorLogado);
					ventana.cambiarAPantalla(PantallaMenu.class);

				} catch (SQLIntegrityConstraintViolationException e2) {
					JOptionPane.showMessageDialog(ventana, "El email ya existe", "Registro fallido",
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, "No se pudo conectar a la base de datos", "Registro fallido",
							JOptionPane.ERROR_MESSAGE);
					System.out.println(e1.getMessage());
				} catch (CampoVacioException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Registro fallido",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(ventana, "Tienes que poner el número de teléfono usando solo números",
							"Registro fallido", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		add(aceptarRegistro);

		JButton aceptarInicioSesion = new JButton("Aceptar");
		aceptarInicioSesion.setBounds(343, 356, 89, 23);
		aceptarInicioSesion.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String email = campoEmailInicioSesion.getText();
				String contrasenia = new String(campoContraseniaInicioSesion.getPassword());

				try {
					Trabajador resultado = Trabajador.consultarTrabajador(email, contrasenia);
					JOptionPane.showMessageDialog(ventana, "Login realizado con exito", "Login exitoso",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.setTrabajadorLogado(resultado);
					ventana.cambiarAPantalla(PantallaMenu.class);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Login fallido", JOptionPane.ERROR_MESSAGE);
					System.out.println(e1.getMessage());
				} catch (UsuarioNoExisteException e2) {
					JOptionPane.showMessageDialog(ventana, e2.getMessage(), "Login fallido", JOptionPane.ERROR_MESSAGE);
				} catch (CampoVacioException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Login fallido", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(aceptarInicioSesion);

		campoContraseniaInicioSesion = new JPasswordField();
		campoContraseniaInicioSesion.setToolTipText("Ingresa aquí tu contrasenia");
		campoContraseniaInicioSesion.setBounds(174, 324, 159, 20);
		add(campoContraseniaInicioSesion);

		campoContraseniaRegistro = new JPasswordField();
		campoContraseniaRegistro.setToolTipText("Ingresa aquí tu contrasenia");
		campoContraseniaRegistro.setBounds(174, 156, 159, 20);
		add(campoContraseniaRegistro);
	}
}
