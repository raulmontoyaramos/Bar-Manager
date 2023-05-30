package interfaces;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	public Ventana() {
		this.setSize(600, 500);
		this.setTitle("TPV");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
//		this.setContentPane(new PantallaLogin(this));
		this.setContentPane(new PantallaMenu(this));

		this.setVisible(true);
	}

	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if (clase.equals(PantallaMenu.class)) {
			this.setContentPane(new PantallaMenu(this));
		}
		if (clase.equals(PantallaAñadirProducto.class)) {
			this.setContentPane(new PantallaAñadirProducto(this));
		}
		if (clase.equals(PantallaMenuBar.class)) {
			this.setContentPane(new PantallaMenuBar(this));
		}
		if (clase.equals(PantallaEliminarProducto.class)) {
			this.setContentPane(new PantallaEliminarProducto(this));
		}
		if (clase.equals(PantallaMesasLibres.class)) {
			this.setContentPane(new PantallaMesasLibres(this));
		}
		if (clase.equals(PantallaMesasOcupadas.class)) {
			this.setContentPane(new PantallaMesasOcupadas(this));
		}
		if (clase.equals(PantallaAniadirMesa.class)) {
			this.setContentPane(new PantallaAniadirMesa(this));
		}
		if (clase.equals(PantallaEliminarMesa.class)) {
			this.setContentPane(new PantallaEliminarMesa(this));
		}
		if (clase.equals(PantallaPlatosPedidos.class)) {
			this.setContentPane(new PantallaPlatosPedidos(this));
		}
		if (clase.equals(PantallaDespedirTrabajador.class)) {
			this.setContentPane(new PantallaDespedirTrabajador(this));
		}
		if (clase.equals(PantallaMarcarMesaLibre.class)) {
			this.setContentPane(new PantallaMarcarMesaLibre(this));
		}
		if (clase.equals(PantallaMarcarMesaOcupada.class)) {
			this.setContentPane(new PantallaMarcarMesaOcupada(this));
		}
		if (clase.equals(PantallaPedirPlato.class)) {
			this.setContentPane(new PantallaPedirPlato(this));
		}
		this.getContentPane().setVisible(true);
	}
}
