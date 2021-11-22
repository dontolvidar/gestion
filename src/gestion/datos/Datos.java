package gestion.datos;

import java.io.IOException;

import gestion.reglas.Medico;

public class Datos {
	
	public Boolean medicoExistente(String cedulamedico) throws IOException {
		Archivo archivo=new Archivo("medico");
		return archivo.existeRegistro(cedulamedico);
	}
	
	public Medico recuperarMedico(String cedulamedico) throws IOException {
		Archivo archivo=new Archivo("medico");
		String arr[]= archivo.recuperarRegistro(cedulamedico);
		Medico medico= new Medico(arr[0],arr[1],Boolean.parseBoolean(arr[2]),Boolean.parseBoolean(arr[3]));
		return medico;
	}
	
	public String grabarMedico(Medico medico) {
		Archivo archivo=new Archivo("medico");
		archivo.grabarRegistro(medico.toString());
		return "OK";
	}
}
