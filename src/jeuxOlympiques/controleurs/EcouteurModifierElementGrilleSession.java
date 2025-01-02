package jeuxOlympiques.controleurs;

import java.awt.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.util.ArrayList;

import jeuxOlympiques.modeles.*;
import jeuxOlympiques.vues.*;

//Lucas
/**
* @author lpivet
*/

public class EcouteurModifierElementGrilleSession implements ActionListener{

	PanelAfficherSession panelAfficher;
	PanelSelection panelCase;

/**
 * Constructeur EcouteurModifierElementGrilleSession
 * 
 * @param temp2 : PanelSelection
 * @param temp : PanelAfficherSession
 */

	public EcouteurModifierElementGrilleSession(PanelSelection temp2, PanelAfficherSession temp){

		panelCase=temp2;
		panelAfficher=temp;
	}

	public void actionPerformed(ActionEvent e) {

		//Permet de fermer toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}
		//Récupère la grille du panel afficher catégorie et supprime la case(selection)
		PanelGrille newGrille = panelAfficher.getGrille();
		newGrille.supprimerSelection(panelCase);

		//Converti le panel Selection en panel Selection Session
		PanelSelectionSession panelCaseActuel=(PanelSelectionSession)panelCase;

		//Supprime la session des sessions de l'épreuves
		ArrayList<Session> newLesSessions = PanelSelectionSession.getLesSessions();
		newLesSessions.remove(panelCaseActuel.getSaSession());
		PanelSelectionSession.setLesSessions(newLesSessions);

		//Appelle le ajouterCatégorie en conservant le panel afficher catégorie et la grille modifier
		PanelAjouterSession modifCategorie=new PanelAjouterSession(panelAfficher,null,newGrille);

		modifCategorie.afficherFenetre();


	}

}
