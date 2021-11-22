package gestion.presentacion;

import javax.swing.JOptionPane;

import gestion.reglas.Medico;
import gestion.reglas.Software;


public class Presentacion {
	//-----------------------------------------------------Utilidades-------------------------------------------------------------------//
	public boolean validarCampos(){
		return true;
	}
	
	public void mostrarMensajeError(String mensaje) {
		
	}
	public void mostrarMensajeExito(String mensaje) {
		
	}
	

	//-----------------------------------------------------Registro medico--------------------------------------------------------------//
	public String registroCedulaMedico(Software soft) {
		boolean validarcampos=validarCampos();
		String cedulamedico="";
		while(validarcampos) {
			
			cedulamedico=JOptionPane.showInputDialog(""
					+ "Id del software "+soft.getIdentificacion()
					+ "\nFuncion del software "+soft.getFuncion()+
					"\n\nIngrese la cedula del medico");
			if (cedulamedico.equals(""))
				validarcampos=true;
			else
				validarcampos=false;
		}
		return cedulamedico;
	}
	
	
	public String registroNombreMedico(Software soft,Medico medico, boolean existe) {
		String nombre="";
		boolean validarcampos=validarCampos();
		while(validarcampos) {
			if (existe)
				{JOptionPane.showMessageDialog(null, ""
					+ "Id del software "+soft.getIdentificacion()
					+ "\nFuncion del software "+soft.getFuncion()
					+ "\n\nId del medico "+medico.getId()
					+ "\nnombre del medico "+medico.getNombre());
					validarcampos=false;
				}
			else
				{nombre=JOptionPane.showInputDialog (""
					+ "Id del software "+soft.getIdentificacion()
					+ "\nFuncion del software "+soft.getFuncion()
					+ "\n\nId del medico "+medico.getId()
					+ "\n\n\nIngrese el nombre del medico: ... \n");
					if (nombre.equals(""))
						validarcampos=true;
					else
						validarcampos=false;
				}
		}
		return nombre;
	}
	
	public String estaEnTurno(String cedula) {
		boolean turno=false;
		boolean validarcampos=validarCampos();
		while(validarcampos) {
			if (existe)
				{JOptionPane.showMessageDialog(null, ""
					+ "Id del software "+soft.getIdentificacion()
					+ "\nFuncion del software "+soft.getFuncion()
					+ "\n\nId del medico "+medico.getId()
					+ "\nnombre del medico "+medico.getNombre());
					validarcampos=false;
				}
			else
				{nombre=JOptionPane.showInputDialog (""
					+ "Id del software "+soft.getIdentificacion()
					+ "\nFuncion del software "+soft.getFuncion()
					+ "\n\nId del medico "+medico.getId()
					+ "\n\n\nIngrese el nombre del medico: ... \n");
					if (nombre.equals(""))
						validarcampos=true;
					else
						validarcampos=false;
				}
		}
		return nombre;
	}
	
}
