package codigo;

import java.io.IOException;
import java.util.ArrayList;

import gestion.datos.Datos;
import gestion.presentacion.Menu;
import gestion.presentacion.Presentacion;
import gestion.reglas.Medico;
import gestion.reglas.Paciente;
import gestion.reglas.Persona;
import gestion.reglas.Software;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Presentacion presenta=new Presentacion();
		Datos datos=new Datos();
		Menu menu= new Menu();
		Software software=new Software();
		
		
		
		/*---------------------------------menu Controlador---------------------------------*/
		
		switch (menu.capturarOpcion()) {
			
			case 1:
				software.setFuncion("Funcion: 3.1 Registro medico");						//se le da una funcion al software
				String cedulamedico=presenta.registroCedula(software);						//de la presentacion obtiene la cedula del medico
				String nombremedico="";														//
				boolean existeMedico=(datos.medicoExistente(cedulamedico));					//
				Medico medico=new Medico(cedulamedico,nombremedico);						//
				
				
				if (!existeMedico)
				{
					nombremedico=presenta.registroNombreMedico(software, medico, existeMedico);	//
					medico=new Medico(cedulamedico,nombremedico);								//
					if(datos.grabarMedico(medico).equals("OK"))									//
						existeMedico=true;														//
				}
				else
					medico=datos.recuperarMedico(cedulamedico);									//
				
				presenta.registroNombreMedico(software, medico, existeMedico);					//
				break;
				
				
				
				
			case 2:
				software.setFuncion("Funcion: 3.2 Registro del turno del medico");  					//poner funcion al programa
				String cedulamedicot=presenta.registroCedula(software);						//le medico ingresa la cedula
				boolean existeMedicot=(datos.medicoExistente(cedulamedicot));						//verifica si existe en archivo
				if (!existeMedicot)										
				{
					presenta.mostrarMensajeError("No existe el Medico con la cedula ingresada"); 	//si no existe muestra error
				}
				else
				{	
					medico=datos.recuperarMedico(cedulamedicot);									//si existe, traigo el objeto	
					boolean estaenservicio=presenta.formularioMedicoServicio(software, medico);		//El medico esta en servicio (si/no)
					medico.setEnServicio(estaenservicio);											
					datos.ensamblarRegistro(medico,Boolean.toString(medico.getEnServicio()),4);						//actualizo el archivo
					presenta.formularioMedicoService(software, medico);								//formulario
				}
				break;
				
				
				
			case 3:
				software.setFuncion("Funcion: 3.3 Registro del paciente y espera a valoracion");  	//poner funcion al programa
				String cedulapaciente=presenta.registroCedula(software);						//le paciente ingresa la cedula
				boolean existepaciente=datos.pacienteExistente(cedulapaciente);					//verifica si existe
				Paciente paciente;
				if (existepaciente)
				{
					paciente=datos.recuperarPaciente(cedulapaciente); 
					Persona persona=paciente;
					presenta.mostrarPaciente(software, persona);
				}
				else
				{
					String nombrepaciente=presenta.nombrePaciente(software, cedulapaciente);
					paciente=new Paciente(cedulapaciente,nombrepaciente);
					Persona persona=paciente;
					presenta.mostrarPaciente(software, persona);
					paciente.setTurno(datos.calcularTurnoValoración());
					presenta.mostrarPaciente(software, paciente);
					datos.grabarPaciente(paciente);
				}
				break;
				
				
			case 4:
				software.setFuncion("Funcion: 3.4 Llamado paciente valoracion inicial");//se le da una funcion al software
				paciente=datos.recuperarPaciente(1,4);
				presenta.mostrarPaciente(software, paciente);
				paciente.setEstado("2");
				String ensamblar=datos.ensamblarRegistro(paciente,paciente.getEstado(), 4);
				if(ensamblar.equals("OK"));
					presenta.mostrarMensajeExito("Los datos fueron guardados correctamente");
				break;
			case 5:
				software.setFuncion("Funcion: 3.5 Valoracion inical del paciente");
				paciente=datos.recuperarPaciente(2,4);
				paciente.setPrioridad(presenta.ingresarPacienteValoracion(software, paciente));
				presenta.mostrarPacienteValoracion(software, paciente);
				paciente.setEstado("3");
				ensamblar=datos.ensamblarRegistro(paciente, paciente.getEstado(), 4);
				ensamblar=datos.ensamblarRegistro(paciente,paciente.getPrioridad(), 5);
				
				break;
			case 6:
				software.setFuncion("Funcion: 3.6 Llamado a un paciente para atencion final");//se le da una funcion al software
				boolean salir=false;
				paciente=null;
				datos.calcularTurnoUrgencia(paciente);
				
				
				
				
				for (int i = 1; i <= 3; i++) {
					if (salir)
						break;
					String triaje=""+i;
					int sice=datos.recuperarPacientes(5, triaje).size()-1;
					
					
					
					for(int j = 0; j <= sice; j++)
					{
						paciente=datos.recuperarPacientes(5, triaje).get(j);
						if(paciente.getEstado().equals("3"))
						{
							for (int k = 0; k < datos.recuperarMedicos(4,Boolean.toString(true)).size(); k++) {
								medico=datos.recuperarMedicos(4,Boolean.toString(true)).get(k);
								if(medico.getAtendiendoPaciente().equals(false))
								{
									System.out.println(medico.getNombre());
									medico.setAtendiendoPaciente(true);								//el medico esta atendiendo este paciente
									datos.ensamblarRegistro(medico,Boolean.toString(medico.getAtendiendoPaciente()), 3);//enviar el medico al archivo
									break;
								}
							}
							presenta.mostrarPacienteValoracion(software, paciente);
							paciente.setEstado("4");
							datos.ensamblarRegistro(paciente,paciente.getEstado(), 4);//emviar el paciente al archivo
							
							salir=true;
							break;
						}
						
					}
					
					
					
				}
				break;
			case 7:
				software.setFuncion("3.7 Atencion final paciente");//se le da una funcion al software
				paciente=datos.recuperarPacientes(4, "4").get(0);
				if(presenta.PacienteDeseaSalir(software, paciente))
					{datos.ensamblarRegistro(paciente, "5", 4);
					
					medico=datos.recuperarMedicos(3,Boolean.toString(true)).get(0);	
					if(medico.getAtendiendoPaciente().equals(true))
						{
							System.out.println(medico.getNombre());
							medico.setAtendiendoPaciente(false);								//el medico esta atendiendo este paciente
							datos.ensamblarRegistro(medico,Boolean.toString(medico.getAtendiendoPaciente()), 3);//enviar el medico al archivo
							break;
						}
					}
				break;
			case 8:
				software.setFuncion("3.8 Consulta de listas de espera por nivel de prioridad");			//se le da una funcion al software
				ArrayList<Paciente> pacientes=datos.recuperarPacientes(5, presenta.nivelPrioridadEscogido());
				for (int j = 0; j < pacientes.size(); j++) {
					presenta.mostrarPacienteValoracion(software, pacientes.get(j));
				}
				break;
			case 9:
				software.setFuncion("3.9 Consulta de indicadores de atencion");							//se le da una funcion al software
				
				
				double Indicador[]=datos.indicador();
				
				presenta.indices(software, Indicador[0], Indicador[1], Indicador[2], Indicador[3]);
				break;
				
		}
	}
}