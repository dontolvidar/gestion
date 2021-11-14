package gestion.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Archivo {
	public Boolean existeRegistro(String buscador) throws IOException{
		int contador = 0;
		boolean existe=false;
        try (BufferedReader br = new BufferedReader(new FileReader("..\\files\\Medicos.txt"))) {
            String record;

            System.out.println(" ------------------------------------------------------------------------------------------------- ");
            System.out.println("|	ID		Nombre 				Estado			Hora de llegada 		  Hora de salida		|");
            System.out.println(" ------------------------------------------------------------------------------------------------- ");

            while ((record = br.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(record, ",");  //la linea record e
                while (st.hasMoreTokens()) {
                    contador++;
                    System.out.print(st.nextToken() + " ");   //sin salto de linea
                    if (contador % 5 == 0) {
                        System.out.println("");
                    }
                }

                //System.out.println("|	" + st.nextToken() + "	" + st.nextToken() + " 		" + st.nextToken() + "			" + st.nextToken() + "      |");
            }

            System.out.println("");
            System.out.println("|  -------------------------------------------------------------  |");
            br.close();
        }
        return existe;
	}
}
