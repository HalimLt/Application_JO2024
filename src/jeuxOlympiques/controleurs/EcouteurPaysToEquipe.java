package jeuxOlympiques.controleurs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import java.awt.Window;
import java.util.ArrayList;

//Halim

//Halim
/**
* @author hluquet
*/

public class EcouteurPaysToEquipe implements ActionListener {
	PanelAfficherPays panelAfficher;
	PanelSelectionPays panelCase;

	/**
	 * Constructeur pour EcouteurPaysToEquipe
	 * 
	 * @param temp2 : PanelSelectionPays
	 * @param temp : PanelAfficherPays
	 */

	public EcouteurPaysToEquipe(PanelSelectionPays temp2, PanelAfficherPays temp){

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

		//Affiche le panelAfficherEquipe en sauvegardant la case (pour pouvoir conserver la grille des catégories ensuite)
		//et prend l'épreuve 
		PanelAfficherEquipe equipes=new PanelAfficherEquipe(panelCase,panelCase.getPays());
		equipes.afficherFenetre();


	}

}
