package excepciones;

public class CampoVacioException extends Exception {
	public CampoVacioException() {
		super("Debe rellenar todos los campos.");
	}
}
