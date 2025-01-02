package jeuxOlympiques.controleurs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import java.awt.Window;

import java.util.ArrayList;


//Lucas
/**
* @author lpivet
*/

public class EcouteurSupprimerElementGrilleSession implements ActionListener {
	PanelAfficherSession panelAfficher;
	PanelSelection panelCase;

	/**
	 * Constructeur pour EcouteurSupprimerElementGrilleSession
	 * 
	 * @param temp2 : PanelSelection
	 * @param temp : PanelAfficherSession
	 */

	public EcouteurSupprimerElementGrilleSession(PanelSelection temp2, PanelAfficherSession temp) {

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

		//Récupère la grille du panel afficher session et supprime la case(sélection)
		PanelGrille newGrille = panelAfficher.getGrille(); 

		newGrille.supprimerSelection(panelCase);

		//Converti le panel Selection en panel Selection Session
		PanelSelectionSession panelCaseActuel=(PanelSelectionSession)panelCase;

		//Supprime la session des sessions de l'épreuves
		ArrayList<Session> newLesSessions = PanelSelectionSession.getLesSessions();

		newLesSessions.remove(panelCaseActuel.getSaSession());

		PanelSelectionSession.setLesSessions(newLesSessions);

		//Créer la nouvelle fenêtre en conservant la case de l'épreuve et affiche la grille modifier
		PanelAfficherSession panel = new PanelAfficherSession(panelAfficher.getEpreuve(),panelCaseActuel.getCategorie(),newGrille);

		panel.afficherFenetre();

	}
}
