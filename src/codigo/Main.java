package codigo;

import java.io.IOException;


import gestion.datos.Datos;
import gestion.presentacion.Menu;
import gestion.presentacion.Presentacion;
import gestion.reglas.Medico;
import gestion.reglas.Software;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Presentacion presenta=new Presentacion();
		Datos datos=new Datos();
		
		
		
		/*---------------------------------menu Controlador---------------------------------*/
		Menu menu= new Menu();
		Software software=new Software();
		switch (menu.capturarOpcion()) {// Registrar medico
			case 1:
				software.setFuncion("Funcion: Registro medico");
				String cedulamedico=presenta.registroCedulaMedico(software);
				String nombremedico="";
				boolean existeMedico=(datos.medicoExistente(cedulamedico));
				Medico medico=new Medico(cedulamedico,nombremedico);
				
				
				if (!existeMedico)
				{
					nombremedico=presenta.registroNombreMedico(software, medico, existeMedico);
					medico=new Medico(cedulamedico,nombremedico);
					if(datos.grabarMedico(medico).equals("OK"))
						existeMedico=true;
				}
				else
					medico=datos.recuperarMedico(cedulamedico);
				
				presenta.registroNombreMedico(software, medico, existeMedico);
				break;
			case 2:
				software.setFuncion("Funcion: Registro del turno del medico");
				String cedulamedicot=presenta.registroCedulaMedico(software);
				boolean existeMedicot=(datos.medicoExistente(cedulamedicot));
				if (!existeMedicot)
				{
					presenta.mostrarMensajeError("No existe el Medico con la cedula ingresada");
				}
				else
				{	
					medico=datos.recuperarMedico(cedulamedicot);
				}
				break;
			
		}
	}
}