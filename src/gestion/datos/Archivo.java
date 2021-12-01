package gestion.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Archivo {
	private String pacienteomedico;
	private String rutaArchivo;
	
	
	public Archivo(String pacienteomedico) {
		this.pacienteomedico=pacienteomedico;
		if (this.pacienteomedico.equals("medico"))
			this.rutaArchivo="src\\gestion\\files\\Medicos.csv";
		else if (this.pacienteomedico.equals("paciente"))
			this.rutaArchivo="src\\gestion\\files\\Pacientes.csv";
	}

	public Boolean existeRegistro(String buscador) throws IOException{
		int contador = 0;
		boolean existe=false;
			
		try (BufferedReader br = new BufferedReader(new FileReader(this.rutaArchivo))) {
            String record;
            int contador1=1;
            
            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");  //la linea record e
                int numTokens=st.countTokens();
                while (st.hasMoreTokens()) {
                    contador++;
                    String atributo=st.nextToken();
                    
                    if (contador % numTokens == 0) {
                        System.out.println("");
                    }
                    
                	if(atributo.equals(buscador)&&contador1==contador) 
                    	existe=true;
                	if (contador1==contador)
                		contador1+=numTokens;
                }
            }

            br.close();
        }
        return existe;
	}
	
	
	
	public String [] recuperarRegistro(String buscador) throws IOException{
		int contador = 0;
		String persona[]=null;
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String record;
            int contador1=1;
            
            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");  //la linea record e
                int numTokens=st.countTokens();
                persona= new String[numTokens];
                while (st.hasMoreTokens()) {
                    contador++;
                    String atributo=st.nextToken();
                    
                    if (contador % numTokens == 0) {
                    }
                    
                	if(atributo.equals(buscador)&&contador1==contador) 
                    	{
                    		 persona[0]=atributo;
	                    	 for (int i = 1; i < numTokens; i++) {
	                    		 persona[i]=st.nextToken();
	                    	 }
	                    	 return persona;
                    	}
                	if (contador1==contador)
                		contador1+=numTokens;
                }
            }

            br.close();
        }
        return persona;
	}
	
	public String [] recuperarRegistro(long buscador, int estado) throws IOException{
		int contador = 0;
		String persona="";
		String vacio[]=null;
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String record;
            int contador1=1;
            
            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");  //la linea record e
                int numTokens=st.countTokens();
                while (st.hasMoreTokens()) {
                	String atributo=st.nextToken();
                    if (contador==numTokens)
                    	{	contador=0;
                    		
                    	}
                	contador++;
                    
                    if (contador==1)
                    	persona=atributo;
                    
                    
                	if(contador % estado == 0 &&Integer.parseInt(atributo)==(buscador)) 
                    	{
                    		
	                    	 return recuperarRegistro(persona);
                    	}
                    
                	if (contador1==contador)
                		contador1+=numTokens;
                }
            }

            br.close();
        }
        return vacio;
	}
	
	public String [][] recuperarRegistros() throws IOException{
		int contadorlineas=0;
		int numTokens=0;
		String scadena="";
		try (BufferedReader brs = new BufferedReader(new FileReader(rutaArchivo))){
			while ((scadena = brs.readLine())!=null) {
				  contadorlineas++;
				  if (contadorlineas==1) {
					  StringTokenizer st = new StringTokenizer(scadena, ",");
					  numTokens=st.countTokens();}
				}
			brs.close();
		}
		String todos[][]=new String[contadorlineas][numTokens];
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String record;
            int i=0;
            int j=0;
            
            while ((record = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(record, ",");  //la linea record e
                while (st.hasMoreTokens()) {
                	todos[i][j]=st.nextToken();
                	
                	j++;
                }
                i++;
                j=0;
            }
            
            br.close();
        }
        return todos;
	}
	
	
	public String recuperarUltimoDato() throws IOException{
		String persona="";
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String record="";
            
            while ((record = br.readLine()) != null) {
               	persona=record;
                
            }

            br.close();
        }
        return persona;
	}
	
	public boolean grabarRegistro(String pRegistro) {
		FileWriter fileWriter;
		PrintWriter printWriter;
		boolean rGrabar;
		rGrabar = false;
		try {
			fileWriter = new FileWriter(this.rutaArchivo, true);
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(""+pRegistro);
			fileWriter.close();
			rGrabar = true;
		} catch(Exception e) {
			
		}
		return rGrabar;
	}
	
	
	public void ensamblarRegistro(String ID, String valor, int columna) throws FileNotFoundException, IOException {
        int numtokens=0;
        int contador = 0;

        ArrayList<String> backup = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String record;
            String item = "";
            Boolean value=false;
            while ((record = br.readLine()) != null) {
            	contador=0;
                StringTokenizer st = new StringTokenizer(record, ",");  //la linea record e
                numtokens=st.countTokens();
                
                while (st.hasMoreTokens()) {
                    contador++;
                    item = st.nextToken();
                    if (((contador == 1) && item.equals(ID))) {
                    	backup.add(item);
                    	value=true;
                    } 
                    else if(value==true&&contador==columna){
                    	backup.add(valor);    
                    	value=false;
                    }
                    else
                    	backup.add(item);
                }
            }
            
            
            contador = 0;
            File fi = new File(rutaArchivo);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fi, false))) { //false para sobre escribir
                for (String cc : backup) {
                    contador++;
                    
                    if (!(contador % numtokens == 0)) {
                        bw.write(cc + ",");
                        
                    }
                    else
                    {
                        bw.write(cc);
                        bw.flush();
                        bw.newLine();
                    }
                }
                bw.close();
            }

             br.close();
        }

    }
}
//System.out.println(" ------------------------------------------------------------------------------------------------- ");
//System.out.println("|	ID		Nombre 				Estado			Hora de llegada 		  Hora de salida		|");
//System.out.println(" ------------------------------------------------------------------------------------------------- ");
