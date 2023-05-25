package interfaces;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() {
		this.setSize(600,500);
		this.setTitle("Prueba");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(new PantallaLogin(this));
		this.setVisible(true);
	}
	
	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if(clase.equals(PantallaPrueba.class)) {
			this.setContentPane(new PantallaPrueba());
		}
		this.getContentPane().setVisible(true);
	}
}
