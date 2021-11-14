package gestion.presentacion;

import javax.swing.JOptionPane;

public class Menu {
	public int menu() {
		int menu=0;
		String contenido="1. Para registrar medico\n"
				+ ""
				+ ""
				+ ""
				+ ""
				+ "";
		menu=Integer.parseInt(JOptionPane.showInputDialog(contenido));
		return menu;
	}
	
	public int capturarOpcion() {
		return menu();
	}
}
