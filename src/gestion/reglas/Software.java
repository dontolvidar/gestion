package gestion.reglas;

public class Software {
	private String funcion;
	private String identificacion;
	public Software(String funcion, String identificacion) {
		super();
		this.funcion = funcion;
		this.identificacion = identificacion;
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
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	@Override
	public String toString() {
		return "Software [funcion=" + funcion + ", identificacion=" + identificacion + "]";
	}
	
	
}
