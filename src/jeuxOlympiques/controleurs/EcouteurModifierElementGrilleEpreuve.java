package jeuxOlympiques.controleurs;

import java.awt.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import jeuxOlympiques.modeles.*;
import jeuxOlympiques.vues.*;
// Lucas
/**
 * @author lpivet
 * 
 */

public class EcouteurModifierElementGrilleEpreuve implements ActionListener{

	PanelAfficherEpreuve panelAfficher;
	PanelSelection panelCase;

	/**
	 * Constructeur de EcouteurModifierElementGrilleEpreuve
	 * 
	 * @param temp2 : PanelSelection
	 * @param temp : PanelAfficherEpreuve
	 */

	public EcouteurModifierElementGrilleEpreuve(PanelSelection temp2, PanelAfficherEpreuve temp){

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
		PanelGrille newGrille = panelAfficher.getGrilleEpreuve();

		newGrille.supprimerSelection(panelCase);

		//Recréer une nouvelle case
		PanelAjouterEpreuve modifEpreuve=new PanelAjouterEpreuve(newGrille);
		modifEpreuve.afficherFenetre();


	}

}