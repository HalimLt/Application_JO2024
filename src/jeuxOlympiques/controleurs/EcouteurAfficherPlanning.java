package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jeuxOlympiques.vues.*; 

import javax.swing.JFrame;

//Stephane
/**
 * 
 * @author sgadewa
 * 
 */
public class EcouteurAfficherPlanning implements ActionListener {


	public void actionPerformed (ActionEvent e) {
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}
		PanelAfficherCalendrier calendrier = new PanelAfficherCalendrier(); 
		calendrier.afficherCalendrier();
	}
}
