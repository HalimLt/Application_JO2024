package jeuxOlympiques.controleurs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import java.awt.Window;

import java.util.ArrayList;

//Lucas
/**
* @author lpivet
*/

public class EcouteurSupprimerElementGrilleEpreuve implements ActionListener {
	PanelAfficherEpreuve panelAfficher;
	PanelSelection panelCase;
	PanelGrille newGrille;

	/**
	 * Constructeur pour EcouteurSupprimerElementGrilleEpreuve
	 * 
	 * @param temp2 : PanelSelection
	 * @param temp : PanelAfficherEpreuve
	 */

	public EcouteurSupprimerElementGrilleEpreuve(PanelSelection temp2, PanelAfficherEpreuve temp) {

		panelCase = temp2;
		panelAfficher = temp;
	}

	// Lucas
	public void actionPerformed(ActionEvent event) {

		//Ferme toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}

		//Récupère la grille des épreuves
		if (panelAfficher!=null) {
			newGrille = panelAfficher.getGrilleEpreuve();
		}
		else {
			newGrille = PanelBandeau.getGrilleEpreuve();

		}

		//Supprime la case concerner
		newGrille.supprimerSelection(panelCase);

		//Supprimer l'épreuve de la liste des épreuves enregistrer
		PanelSelectionEpreuve caseActuel=(PanelSelectionEpreuve) panelCase;

		ArrayList<Epreuve> newLesEpreuves =  Epreuve.getJOParis().getSesEpreuves();

		newLesEpreuves.remove(caseActuel.getEpreuve());

		Epreuve.getJOParis().setSesEpreuves(newLesEpreuves);

		//affiche le nouveau panelAfficherEpreuve avec la nouvelle Grille
		PanelAfficherEpreuve panel;
		
		try {
			panel = new PanelAfficherEpreuve(newGrille);
			panel.afficherFenetre();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
