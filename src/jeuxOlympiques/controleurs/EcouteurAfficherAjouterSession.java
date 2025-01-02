package jeuxOlympiques.controleurs;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;


/**
 * @author lpivet
 */

public class EcouteurAfficherAjouterSession implements ActionListener {

	//Lucas
	PanelAfficherSession panelAfficher;

	

	/**
	 * Constructeur pour EcouteurAfficherAjouterSession
	 * 
	 * @param temp : PanelAfficherSession
	 */

	public EcouteurAfficherAjouterSession(PanelAfficherSession temp){

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
		PanelAjouterSession panel = new PanelAjouterSession(panelAfficher);
		panel.afficherFenetre();






	}
}