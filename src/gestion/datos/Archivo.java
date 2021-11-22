package gestion.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Archivo {
	private String pacienteomedico;
	private String rutaArchivo;
	
	
	public Archivo(String pacienteomedico) {
		this.pacienteomedico=pacienteomedico;
		if (this.pacienteomedico.equals("medico"))
			this.rutaArchivo="src\\gestion\\files\\Medicos.txt";
		else if (this.pacienteomedico.equals("paciente"))
			this.rutaArchivo="src\\gestion\\files\\Pacientes.txt";
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
}
//System.out.println(" ------------------------------------------------------------------------------------------------- ");
//System.out.println("|	ID		Nombre 				Estado			Hora de llegada 		  Hora de salida		|");
//System.out.println(" ------------------------------------------------------------------------------------------------- ");
