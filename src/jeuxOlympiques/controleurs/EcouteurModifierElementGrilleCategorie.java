package jeuxOlympiques.controleurs;

import java.awt.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import jeuxOlympiques.modeles.*;
import jeuxOlympiques.vues.*;

/**
 * @author lpivet
 * 
 */

public class EcouteurModifierElementGrilleCategorie implements ActionListener{

	PanelAfficherCategorie panelAfficher;
	PanelSelection panelCase;

	/**
	 * Constructeur EcouteurModifierElementGrilleCategorie
	 * 
	 * @param temp2 : PanelSelection
	 * @param temp : PanelAfficherCategorie
	 */ 

	public EcouteurModifierElementGrilleCategorie(PanelSelection temp2, PanelAfficherCategorie temp){

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

		//Converti le panel Selection en panel Selection Categorie
		PanelSelectionCategorie panelCaseActuel=(PanelSelectionCategorie)panelCase;

		//Appelle le ajouterCatégorie en conservant le panel afficher catégorie et la grille modifier
		PanelAjouterCategorie modifEpreuve=new PanelAjouterCategorie(panelAfficher,null,newGrille);

		modifEpreuve.afficherFenetre();

		/*PanelAfficherEpreuve panel = new PanelAfficherEpreuve(newGrille);
		panel.afficherFenetre();*/
	}

}
