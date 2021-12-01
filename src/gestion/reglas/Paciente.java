package gestion.reglas;

public class Paciente extends Persona{
	private long turno=0;
	private String estado="1";
	private String prioridad="-1";
	private String turnoatencion="-1";
	public Paciente(String id, String nombre, long turno, String estado, String prioridad, String turnoatencion) {
		super(id,nombre);
		this.turno = turno;
		this.estado = estado;
		this.prioridad = prioridad;
		this.turnoatencion = turnoatencion;
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
	
	public String getTurnoatencion() {
		return turnoatencion;
	}
	public void setTurnoatencion(String turnoatencion) {
		this.turnoatencion = turnoatencion;
	}
	@Override
	public String toString() {
		return id+","+nombre+","+turno + "," + estado + "," + prioridad + ","+ turnoatencion;
	}
	
	
}
