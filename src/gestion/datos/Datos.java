package gestion.datos;

import java.io.IOException;

import gestion.reglas.Medico;

public class Datos {
	public void grabarMedico(Medico medico) {
		
	}
	public Boolean medicoExistente(Medico medico) throws IOException {
		boolean existe=false;
		Archivo archivo=new Archivo();
		if (archivo.existeRegistro(medico.getID()));
			existe=true;
		return existe;
	}
}
