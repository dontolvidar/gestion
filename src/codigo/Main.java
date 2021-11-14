package codigo;

import java.io.IOException;

import javax.swing.JOptionPane;

import gestion.datos.Datos;
import gestion.presentacion.Menu;
import gestion.presentacion.Presentacion;
import gestion.reglas.Medico;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Presentacion presenta=new Presentacion();
		Datos datos=new Datos();
		
		
		
		/*---------------------------------menu Controlador---------------------------------*/
		Menu menu= new Menu();
		switch (menu.capturarOpcion()) {
			case 1:
				Medico medico=new Medico();
				datos.medicoExistente(presenta.registroMedico());
			break;
		}
	}

}
