package gestion.reglas;

public class Paciente {
	private String ID, nombre;
	private long turno;
	private String estado,prioridad,indicador;
	public Paciente(String iD, String nombre, long turno, String estado, String prioridad, String indicador) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.turno = turno;
		this.estado = estado;
		this.prioridad = prioridad;
		this.indicador = indicador;
	}
	public Paciente() {
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
	public long getTurno() {
		return turno;
	}
	public void setTurno(long turno) {
		this.turno = turno;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public String getIndicador() {
		return indicador;
	}
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	@Override
	public String toString() {
		return "Paciente [ID=" + ID + ", nombre=" + nombre + ", turno=" + turno + ", estado=" + estado + ", prioridad="
				+ prioridad + ", indicador=" + indicador + "]";
	}
	
	
}
