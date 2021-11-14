package gestion.presentacion;

import javax.swing.JOptionPane;

import gestion.reglas.Medico;
import gestion.reglas.Software;

public class Presentacion {
	public Medico registroMedico() {
		Medico medico= new Medico();
		String id=JOptionPane.showInputDialog("Ingrese la cedula del medico");
		String nombre=JOptionPane.showInputDialog("Ingrese El nombre del medico");
		medico.setID(id);
		medico.setNombre(nombre);
		return medico;
	}
	
	public void mostrarFormularioMedico(Software soft,Medico medico, boolean existe) {
		
		
	}
	
}
