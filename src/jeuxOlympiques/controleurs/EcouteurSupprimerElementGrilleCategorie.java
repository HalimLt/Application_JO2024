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

public class EcouteurSupprimerElementGrilleCategorie implements ActionListener {
	PanelAfficherCategorie panelAfficher;
	PanelSelection panelCase;

	/**
	 * EcouteurSupprimerElementGrilleCategorie
	 * 
	 * @param temp2 : PanelSelection
	 * @param temp : PanelAfficherCategorie
	 */
	public EcouteurSupprimerElementGrilleCategorie(PanelSelection temp2, PanelAfficherCategorie temp) {

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

		//Récupère la grille du panel afficher categorie et supprime la case(sélection)
		PanelGrille newGrille = panelAfficher.getGrille(); 

		newGrille.supprimerSelection(panelCase);

		//Converti le panel Selection en panel Selection Categorie
		PanelSelectionCategorie panelCaseActuel=(PanelSelectionCategorie)panelCase;

		//Supprimer la catégorie de la liste des catégories enregistrer

		ArrayList<Epreuve> newLesEpreuves =  Epreuve.getJOParis().getSesEpreuves();

		int i=newLesEpreuves.indexOf(panelCaseActuel.getSelectionEpreuve().getEpreuve());

		ArrayList<Categorie> newLesCategories =  Epreuve.getJOParis().getSesEpreuves().get(i).getSesCategories();

		newLesCategories.remove(panelCaseActuel.getCategorie());

		Epreuve.getJOParis().getSesEpreuves().get(i).setSesCategories(newLesCategories);

		//Créer la nouvelle fenêtre en conservant la case de l'épreuve et affiche la grille modifier
		PanelAfficherCategorie panel = new PanelAfficherCategorie(panelAfficher.getEpreuve(),panelCaseActuel.getSelectionEpreuve(),newGrille);

		panel.afficherFenetre();

	}
}
