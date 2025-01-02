package jeuxOlympiques.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import java.awt.Window;
import java.util.ArrayList;

//Halim
/**
* @author hluquet
*/

public class EcouteurSupprimerElementGrilleEquipe implements ActionListener {
	PanelAfficherEquipe panelAfficher;
	PanelSelection panelCase;

	/**
	 * Constructeur pour EcouteurSupprimerElementGrilleEquipe
	 * 
	 * @param temp2 : PanelSelection
	 * @param temp : PanelAfficherEquipe
	 */

	public EcouteurSupprimerElementGrilleEquipe(PanelSelection temp2, PanelAfficherEquipe temp) {

		panelCase = temp2;
		panelAfficher = temp;
	}

	// Lucas
	public void actionPerformed(ActionEvent event) {

		//Permet de fermer toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}

		//Récupère la grille du panel afficher equipe et supprime la case(sélection)
		PanelGrille newGrille = panelAfficher.getGrille(); 

		newGrille.supprimerSelection(panelCase);

		//Converti le panel Selection en panel Selection Equipe
		PanelSelectionEquipe panelCaseActuel=(PanelSelectionEquipe)panelCase;

		//Créer la nouvelle fenêtre en conservant la case de l'épreuve et affiche la grille modifier
		PanelAfficherEquipe panel = new PanelAfficherEquipe(panelCaseActuel.getPays(),newGrille);

		panel.afficherFenetre();

	}
}
