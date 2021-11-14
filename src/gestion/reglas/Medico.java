package gestion.reglas;

public class Medico {
	private String ID,nombre;
	private Boolean estadoActivo;
	private float hora_llegada,hora_salida;
	public Medico(String iD, String nombre, Boolean estadoActivo, float hora_llegada, float hora_salida) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.estadoActivo = estadoActivo;
		this.hora_llegada = hora_llegada;
		this.hora_salida = hora_salida;
	}
	public Medico() {
		super();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getEstadoActivo() {
		return estadoActivo;
	}
	public void setEstadoActivo(Boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}
	public float getHora_llegada() {
		return hora_llegada;
	}
	public void setHora_llegada(float hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	public float getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(float hora_salida) {
		this.hora_salida = hora_salida;
	}
	@Override
	public String toString() {
		return "Medico [ID=" + ID + ", nombre=" + nombre + ", estadoActivo=" + estadoActivo + ", hora_llegada="
				+ hora_llegada + ", hora_salida=" + hora_salida + "]";
	}
	
	
}
