package interfaces;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clases.Trabajador;
import utils.DAO;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class PantallaEditarTrabajador extends JPanel {

	private Ventana ventana;
	private JTextField campoNombreRegistro;
	private JTextField campoEmailRegistro;
	private JTextField campoTelefonoRegistro;
	private JTextField campoEmailInicioSesion;
	private JPasswordField campoContrasenia;

	public PantallaEditarTrabajador(Ventana v) {
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

		campoContrasenia = new JPasswordField();
		campoContrasenia.setToolTipText("Ingresa aquí tu contrasenia");
		campoContrasenia.setBounds(174, 156, 159, 20);
		add(campoContrasenia);

		campoEmailRegistro.setText(ventana.getTrabajadorLogado().getEmail());
		campoNombreRegistro.setText(ventana.getTrabajadorLogado().getNombre());
		campoContrasenia.setText(ventana.getTrabajadorLogado().getContraseña());
		campoTelefonoRegistro.setText("" + ventana.getTrabajadorLogado().getTelefono());

		JButton aceptarButton = new JButton("Actualizar");
		aceptarButton.setBounds(306, 371, 89, 23);
		add(aceptarButton);

		aceptarButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Trabajador trabajadorLogado = new Trabajador(campoEmailRegistro.getText(),
						campoNombreRegistro.getText(), new String(campoContrasenia.getPassword()),
						Integer.parseInt(campoTelefonoRegistro.getText()));
				HashMap<String, Object> datosAActualizar = new HashMap<String, Object>();
				datosAActualizar.put("email", campoEmailRegistro.getText());
				datosAActualizar.put("nombre", campoNombreRegistro.getText());
				datosAActualizar.put("contrasenia", new String(campoContrasenia.getPassword()));
				datosAActualizar.put("telefono", campoTelefonoRegistro.getText());
				HashMap<String, Object> restricciones = new HashMap<String, Object>();
				restricciones.put("email", trabajadorLogado.getEmail());
				try {
					DAO.actualizar("Trabajador", datosAActualizar, restricciones);
					JOptionPane.showMessageDialog(ventana, "Informacion actualizada.", "Actualizar",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.setTrabajadorLogado(trabajadorLogado);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton salirButton = new JButton("Salir");
		salirButton.setBounds(429, 371, 89, 23);
		add(salirButton);

		salirButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenu.class);
			}
		});
	}

}
