package gestion.reglas;

public class Paciente extends Persona{
	private long turno;
	private String estado,prioridad,indicador;
	public Paciente(String id, String nombre, long turno, String estado, String prioridad, String indicador) {
		super(id,nombre);
		this.turno = turno;
		this.estado = estado;
		this.prioridad = prioridad;
		this.indicador = indicador;
	}
	public Paciente(String id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
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
		return id+","+nombre+","+turno + "," + estado + "," + prioridad + ","+ indicador;
	}
	
	
}
