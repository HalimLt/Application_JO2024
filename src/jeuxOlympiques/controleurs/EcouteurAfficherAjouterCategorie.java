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


public class EcouteurAfficherAjouterCategorie implements ActionListener {

	//Lucas 
	PanelAfficherCategorie panelAfficher;

	

	/**
	 * 
	 * Constructeur pour EcouteurAfficherAjouterCategorie
	 * 
	 * @param temp : PanelAfficherCategorie
	 */
	public EcouteurAfficherAjouterCategorie(PanelAfficherCategorie temp){

		panelAfficher=temp;
	}



	//Lucas

	public void actionPerformed(ActionEvent event) {

		//Ferme toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}

		//Affiche le panel ajouter catégorie en conservant le panelAfficher
		PanelAjouterCategorie panel = new PanelAjouterCategorie(panelAfficher,panelAfficher.getEpreuve());
		panel.afficherFenetre();






	}
}