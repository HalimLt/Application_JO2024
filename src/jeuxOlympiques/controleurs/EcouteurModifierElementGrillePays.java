package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import jeuxOlympiques.modeles.*;
import jeuxOlympiques.vues.*;

//Halim
/**
* @author hluquet
*/

public class EcouteurModifierElementGrillePays implements ActionListener{

	PanelAfficherPays panelAfficher;
	PanelSelection panelCase;

/**
 * Constructeur pour EcouteurModifierElementGrillePays
 * 
 * @param temp2 : PanelSelection
 * @param temp : PanelAfficherPays
 */
	public EcouteurModifierElementGrillePays(PanelSelection temp2, PanelAfficherPays temp){

		panelCase=temp2;
		panelAfficher=temp;
	}

	public void actionPerformed(ActionEvent e) {

		//Ferme toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}

		//Supprime l'élément comme dans supprimer
		PanelGrille newGrille = panelAfficher.getGrillePays();

		newGrille.supprimerSelection(panelCase);

		//Recréer une nouvelle case
		PanelAjouterPays modifPays=new PanelAjouterPays(newGrille);
		modifPays.afficherFenetre();


	}

}