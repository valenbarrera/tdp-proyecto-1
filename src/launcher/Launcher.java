package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
		Student valentina = new Student(126661,"Barrera","Valentina","valen.barrera2001@gmail.com","https://github.com/valenbarrera","/images/imagen.jpg");
		
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen window = new SimplePresentationScreen(valentina);
            	window.setVisible(true);
            }
        });
    }
}