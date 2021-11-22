package gestion.reglas;

public class Software {
	private String funcion;
	private String identificacion="Programa gestion turnos";
	public Software(String funcion) {
		super();
		this.funcion = funcion;
	}
	public Software() {
		super();
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getIdentificacion() {
		return identificacion;
	}

	@Override
	public String toString() {
		return "Software [funcion=" + funcion + ", identificacion=" + identificacion + "]";
	}
	
	
}
