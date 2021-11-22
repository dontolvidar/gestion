package gestion.presentacion;

import javax.swing.JOptionPane;

public class Menu {
	public int menu() {
		int menu=0;
		String contenido=""
				+ "1. Para registrar medico\n"
				+ "2. Registro turno del medico"				//El medico llega
				+ "3. Registro paciente\n"							//El paciente llega
				+ "4. Paciente llamado a valoracion inicial\n"		//Pantalla que muestra el paciente que debe ser llamado a valoracion
				+ "5. Valoracion del enfermero para el paciente\n"    //El enfermero muestra una valoracion
				+ "6. Paciente llamado para atencion final\n"         //Pantalla que muestra el paciente que debe ser llamado a atencion final
				+ "7. Paciente que salio de la atencion\n"			//El medico atiende al paciente, se muestra en pantalla 2 opciones  (si quiere salir o quedarse) ... con el fin registrar su salida
				+ "8. Mostrar Pacientes en espera por nivel de prioridad"
				+ "9. Recorrer pacientes que ya salieron (estado 5) y su nivel de prioridad" 
				+ "10. Salir";			
		menu=Integer.parseInt(JOptionPane.showInputDialog(contenido));
		return menu;
	}
	
	public int capturarOpcion() {
		return menu();
	}
}
