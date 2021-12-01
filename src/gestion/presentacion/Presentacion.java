package gestion.presentacion;

import javax.swing.JOptionPane;

import gestion.reglas.Medico;
import gestion.reglas.Paciente;
import gestion.reglas.Persona;
import gestion.reglas.Software;


public class Presentacion {
	//-----------------------------------------------------Utilidades-------------------------------------------------------------------//
	public boolean validarCampos(){
		return true;
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(null,"Mensaje de error "+mensaje);
	}
	public void mostrarMensajeExito(String mensaje) {
		JOptionPane.showMessageDialog(null,"Mensaje de exito "+mensaje);
	}
	

	//-----------------------------------------------------1. Registro medico--------------------------------------------------------------//
	
	
	
	public String registroNombreMedico(Software soft,Medico medico, boolean existe) {
		String nombre="";
		boolean validarcampos=validarCampos();
		while(validarcampos) {
			if (existe)
				{JOptionPane.showMessageDialog(null, ""
					+softwareString(soft)
					+datosPersonaString(medico,"medico"));
					validarcampos=false;
				}
			else
				{nombre=JOptionPane.showInputDialog (""
					+ softwareString(soft)
					+ "Id del medico "+medico.getId()
					+ "\n\n\nIngrese el nombre del medico: ... \n");
					if (nombre.equals(""))
						validarcampos=true;
					else
						validarcampos=false;
				}
		}
		return nombre;
	}
	//---------------------------------------2. Servicio Medico------------------------///
	public boolean formularioMedicoServicio(Software soft, Medico medico) {
		boolean indicativo=false;		
		if (JOptionPane.showConfirmDialog(null, 
						softwareString(soft)
						+ datosPersonaString(medico,"medico")
						+ "Esta el medico en servicio? ", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						    // yes option
							indicativo=true;
						} else {
						    // no option
							indicativo=false;
						}
		return indicativo;
		
	}
	
	public void formularioMedicoService(Software soft, Medico medico) {
		JOptionPane.showMessageDialog(null, softwareString(soft)+
				datosPersonaString(medico,"medico")
				+"Estado del medico en servicio : "+medico.getEnServicio());
	}
	
	//----------------------------------Paciente-------------------------------------------------------------//
	
	public void mostrarPaciente(Software soft, Persona persona) {
		JOptionPane.showMessageDialog(null, softwareString(soft)+
				datosPersonaString(persona,"paciente"));
	}
	public void mostrarPaciente(Software soft, Paciente paciente) {
		JOptionPane.showMessageDialog(null, softwareString(soft)
				+"El turno de valoracion del paciente es : "+paciente.getTurno()
				+datosPersonaString(paciente,"paciente"));
	}
	public void mostrarPacienteValoracion(Software soft, Paciente paciente) {
		JOptionPane.showMessageDialog(null, softwareString(soft)
				+"El turno de valoracion del paciente es : "+paciente.getTurno()
				+datosPersonaString(paciente,"paciente")
				+"El paciente tiene como nivel de prioridad "+paciente.getPrioridad());
	}
	public String ingresarPacienteValoracion(Software soft, Paciente paciente) {
		return JOptionPane.showInputDialog(softwareString(soft)
				+"El turno de valoracion del paciente es : "+paciente.getTurno()
				+datosPersonaString(paciente,"paciente")
				+"Cual es el nivel de prioridad? ");
	}
	
	public boolean PacienteDeseaSalir(Software soft, Paciente paciente) {
		boolean indicativo=false;		
		if (JOptionPane.showConfirmDialog(null, 
				softwareString(soft)
				+"El turno de valoracion del paciente es : "+paciente.getTurno()
				+datosPersonaString(paciente,"paciente")
				+"Nivel de prioridad: "+paciente.getPrioridad()
				+"\n\nEl paciente ya salio de atencion final? ", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						    // yes option
							indicativo=true;
						} else {
						    // no option
							indicativo=false;
						}
		return indicativo;
	}
	
	public void indices(Software soft, double general,double in1,double in2, double in3) {
		JOptionPane.showMessageDialog(null,softwareString(soft)+
				"Indice general : "+Double.toString(general)
				+"\nIndice triaje 1 : "+Double.toString(in1)
				+"\nIndice triaje 2 : "+Double.toString(in2)
				+"\nIndice triaje 3 : "+Double.toString(in3));
	}
	
	public String nombrePaciente(Software soft, String cedula) {
		String nombre="";
		
		nombre=JOptionPane.showInputDialog(softwareString(soft)
				+"Cedula del paciente "+cedula
				+"\nIngresar el nombre del paciente ");
		if (nombre.equals(""))
			return nombrePaciente(soft, cedula);
		return nombre;
	}
	
	
	
	
	public String nivelPrioridadEscogido() 
	{
		return JOptionPane.showInputDialog("Nivel de prioridad o triaje que desea consultar");
	}
	
	//------------------------------mas utilidades--------------------//
	public String registroCedula(Software soft) {
		boolean validarcampos=validarCampos();
		String cedulamedico="";
		while(validarcampos) {
			
			cedulamedico=JOptionPane.showInputDialog(""
					+softwareString(soft)
					+"Ingrese la cedula : ");
			if (cedulamedico.equals(""))
				validarcampos=true;
			else
				validarcampos=false;
		}
		return cedulamedico;
	}
	
	
	
	
	public String softwareString(Software soft) {
		return (""
				+ "Id del software "+soft.getIdentificacion()
				+ "\nFuncion del software "+soft.getFuncion())+"\n\n";
	}
	
	public String datosPersonaString(Persona persona,String medicoopaciente) {
		
		return (""
				+ "\n\nId del " + medicoopaciente +" : "+persona.getId()
				+ "\nNombre del " + medicoopaciente +" : "+persona.getNombre()+"\n\n");
	}
	
}
