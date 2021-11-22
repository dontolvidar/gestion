package gestion.reglas;

public class Medico extends Persona{
	private Boolean atendiendoPaciente=false, enServicio=false;
	public Medico(String id, String nombre, Boolean atendiendoPaciente,Boolean enServicio) {
		super(id,nombre);
		this.atendiendoPaciente = atendiendoPaciente;
		this.enServicio=enServicio;
	}
	public Medico(String id, String nombre) {
		super( id,  nombre);
	}
	
	
	
	public Boolean getAtendiendoPaciente() {
		return atendiendoPaciente;
	}
	public void setAtendiendoPaciente(Boolean atendiendoPaciente) {
		this.atendiendoPaciente = atendiendoPaciente;
	}
	public Boolean getEnServicio() {
		return enServicio;
	}
	public void setEnServicio(Boolean enServicio) {
		this.enServicio = enServicio;
	}
	
	@Override
	public String toString() {	
		return id+","+nombre+","+atendiendoPaciente + "," + enServicio;
	}
	
	
	
	
}
