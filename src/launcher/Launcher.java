package launcher;
import javax.swing.JFrame;
import entities.*;
import gui.*;

public class Launcher {
	
	private static Student estudiante;
	private static JFrame f;
	public static void main(String [] args) {
		estudiante = new Student(121909,"Leal","Alejandro Sergio","alejandro.sergioleal@hotmail.com","https://github.com/AlejandroSergioLeal/","/images/foto.png");
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	f = new SimplePresentationScreen(estudiante);
            	f.setVisible(true);
            }
        });
    }
    
}