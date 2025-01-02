package jeuxOlympiques.controleurs;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;


/**
 * @author lpivet
 * 
 */

public class EcouteurAfficherAjouterEpreuve implements ActionListener {

	//Lucas 
	PanelAfficherEpreuve panelAfficher;

	

	/**
	 * Constructeur pour EcouteurAfficherAjouterEpreuve
	 * 
	 * @param temp : PanelAfficherEpreuve
	 */
	//CONSTRUCTEUR
	public EcouteurAfficherAjouterEpreuve(PanelAfficherEpreuve temp){

		panelAfficher=temp;
	}

	//Lucas
	public void actionPerformed(ActionEvent event) {

		//permet de fermer toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}

		//permet d'afficher le panel ajouterEpreuve
		PanelAjouterEpreuve panel = new PanelAjouterEpreuve(panelAfficher.getGrilleEpreuve());
		panel.afficherFenetre();






	}
}