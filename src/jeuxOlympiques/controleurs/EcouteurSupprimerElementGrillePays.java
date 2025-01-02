package jeuxOlympiques.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import java.awt.Window;

import java.util.ArrayList;

//Halim
/**
* @author hluquet
*/

public class EcouteurSupprimerElementGrillePays implements ActionListener {
	PanelAfficherPays panelAfficher;
	PanelSelection panelCase;
	PanelGrille newGrille;

	/**
	 * Constructeur pour EcouteurSupprimerElementGrillePays
	 * 
	 * @param temp2 : PanelSelection
	 * @param temp : PanelAfficherPays
	 */

	public EcouteurSupprimerElementGrillePays(PanelSelection temp2, PanelAfficherPays temp) {

		panelCase = temp2;
		panelAfficher = temp;
	}

	// Halim
	public void actionPerformed(ActionEvent event) {

		//Ferme toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}

		//Récupère la grille des épreuves
		if (panelAfficher!=null) {
			newGrille = panelAfficher.getGrillePays();
		}
		else {
			newGrille = PanelBandeau.getGrillePays();

		}

		//Supprime la case concerner
		newGrille.supprimerSelection(panelCase);

		//affiche le nouveau panelAfficherPays avec la nouvelle Grille
		PanelAfficherPays panel;
		try {
			panel = new PanelAfficherPays(newGrille);
			panel.afficherFenetre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
