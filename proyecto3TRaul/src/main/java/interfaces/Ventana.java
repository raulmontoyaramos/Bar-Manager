package interfaces;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() {
		this.setSize(600,500);
		this.setTitle("TPV");
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
		if(clase.equals(PantallaMenu.class)) {
			this.setContentPane(new PantallaMenu(this));
		}
		if(clase.equals(PantallaAñadirProducto.class)) {
			this.setContentPane(new PantallaAñadirProducto(this));
		}
		if(clase.equals(PantallaMenuBar.class)) {
			this.setContentPane(new PantallaMenuBar(this));
		}
		this.getContentPane().setVisible(true);
	}
}
