package gestion.datos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import gestion.reglas.Medico;
import gestion.reglas.Paciente;

public class Datos {
	
	public Boolean medicoExistente(String cedulamedico) throws IOException {
		Archivo archivo=new Archivo("medico");
		return archivo.existeRegistro(cedulamedico);
	}
	public Boolean pacienteExistente(String cedulapaciente) throws IOException {
		Archivo archivo=new Archivo("paciente");
		return archivo.existeRegistro(cedulapaciente);
	}
	
	public Medico recuperarMedico(String cedulamedico) throws IOException {
		Archivo archivo=new Archivo("medico");
		String arr[]= archivo.recuperarRegistro(cedulamedico);
		Medico medico= new Medico(arr[0],arr[1],Boolean.parseBoolean(arr[2]),Boolean.parseBoolean(arr[3]));
		return medico;
	}
	
	public Paciente recuperarPaciente(String cedulapaciente) throws IOException {
		Archivo archivo=new Archivo("paciente");
//		public Paciente(String id, String nombre, long turno, String estado, String prioridad, String indicador)
		String arr[]= archivo.recuperarRegistro(cedulapaciente);
		Paciente paciente= new Paciente(arr[0],arr[1],Long.parseLong(arr[2]),(arr[3]),arr[4],arr[5]);
		return paciente;
	}
	public Paciente recuperarPaciente(int columna,int estado) throws IOException {
		Archivo archivo=new Archivo("paciente");
//		public Paciente(String id, String nombre, long turno, String estado, String prioridad, String indicador)
		String arr[]= archivo.recuperarRegistro(columna,estado);
		Paciente paciente= new Paciente(arr[0],arr[1],Long.parseLong(arr[2]),(arr[3]),arr[4],arr[5]);
		return paciente;
	}
	
	public long calcularTurnoValoración() throws IOException {
		Archivo archivo=new Archivo("paciente");
		String ultimo=archivo.recuperarUltimoDato();
		StringTokenizer st = new StringTokenizer(ultimo, ",");  //la linea record e
		long turno=1;
		if (!ultimo.equals(""))
			{st.nextToken();
			st.nextToken();
			turno=Long.parseLong(st.nextToken())+1;}
		return turno;
	}
	public String grabarMedico(Medico medico) {
		Archivo archivo=new Archivo("medico");
		archivo.grabarRegistro(medico.toString());
		return "OK";
	}
	
	public String ensamblarRegistro(Medico medico,String valor,int columna) throws FileNotFoundException, IOException {
		Archivo archivo=new Archivo("medico");
		archivo.ensamblarRegistro(medico.getId(),valor, columna);
		return "OK";
	}
	
	
	public String ensamblarRegistro(Paciente paciente,String itemactualizar,int columna) throws FileNotFoundException, IOException {
		Archivo archivo=new Archivo("paciente");
		archivo.ensamblarRegistro(paciente.getId(),itemactualizar, columna);
		return "OK";
	}
	
	public String grabarPaciente(Paciente paciente) {
		Archivo archivo=new Archivo("paciente");
		archivo.grabarRegistro(paciente.toString());
		return "OK";
	}
	
	public ArrayList<Paciente>recuperarPacientes(int columna, String valor) throws IOException{
		Archivo archivo=new Archivo("paciente");
		String todos[][]= archivo.recuperarRegistros();
		ArrayList<Paciente> algunos=new ArrayList<Paciente>();
		for (int i = 0; i < todos.length; i++) {
			if(todos[i][columna-1].equals(valor))
			{
				Paciente pacientes=new Paciente((todos[i][0]),todos[i][1],Long.parseLong(todos[i][2]),todos[i][3],todos[i][4],todos[i][5]);
				algunos.add(pacientes);
			
			}
				
		}
		return algunos;
	}
	
	public ArrayList<Medico>recuperarMedicos(int columna, String valor) throws IOException{
		Archivo archivo=new Archivo("medico");
		String todos[][]= archivo.recuperarRegistros();
		ArrayList<Medico> algunos=new ArrayList<Medico>();
		for (int i = 0; i < todos.length; i++) {
			if(todos[i][columna-1].equals(valor))
			{
				Medico medico=new Medico((todos[i][0]),todos[i][1],Boolean.parseBoolean(todos[i][2]),Boolean.parseBoolean(todos[i][3]));
				algunos.add(medico);
			
			}
				
		}
		return algunos;
	}
	public void calcularTurnoUrgencia(Paciente paciente) throws FileNotFoundException, IOException {
		int contador=0;
		for (int i = 1; i <=3; i++) {
			
			String triaje=""+i;
			int sice=recuperarPacientes(5, triaje).size();
			for (int j = 0; j < sice; j++) {
				contador++;
				paciente=recuperarPacientes(5, triaje).get(j);
				paciente.setTurnoatencion(""+contador);
				ensamblarRegistro(paciente,paciente.getTurnoatencion(), 6);//emviar el paciente al archivo
			}
		}
		
	}
	public double[] indicador() throws IOException {
		int Eindividual=0;
		int Eindividual1=0;
		int Eindividual2=0;
		int Eindividual3=0;
		int cantidad1=0;
		int cantidad2=0;
		int cantidad3=0;
		ArrayList<Paciente> pacientes5=recuperarPacientes(4, "5");
		int [][] mat=new int[pacientes5.size()][2];
		for (int i = 0; i < mat.length; i++) {
			
				Paciente paciente=pacientes5.get(i);
				mat[i][0]=Integer.parseInt(paciente.getPrioridad());
				mat[i][1]=Integer.parseInt(paciente.getTurnoatencion())-(int)pacientes5.get(i).getTurno();
				Eindividual+=mat[i][1];
				switch(mat[i][0]) {
					case 1:
						cantidad1++;
						Eindividual1+=mat[i][1];
						break;
					case 2:
						cantidad2++;
						Eindividual2+=mat[i][1];
						break;
					case 3:
						cantidad3++;
						Eindividual2+=mat[i][1];
						break;
				}
		}
		
		double general=(double)Eindividual/(double)pacientes5.size();
		double nivel1=(double)Eindividual1/(double)cantidad1;
		double nivel2=(double)Eindividual2/(double)cantidad2;
		double nivel3=(double)Eindividual3/(double)cantidad3;
		double[] mats= {general,nivel1,nivel2,nivel3};
		return mats;
	}

}
