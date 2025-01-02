package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import jeuxOlympiques.vues.*;


//Lucas
/**
* @author lpivet
*/
public class EcouteurRetourEpreuve implements ActionListener {

	PanelAfficherCategorie panel;
	PanelSelectionEpreuve caseEpreuve;

	/**
	 * 
	 * Constructeur pour EcouteurRetourEpreuve
	 * 
	 * @param caseEpreuve : PanelSelectionEpreuve
	 * @param panel : PanelAfficherCategorie
	 */

	public EcouteurRetourEpreuve(PanelSelectionEpreuve caseEpreuve,PanelAfficherCategorie panel){
		this.panel=panel;
		this.caseEpreuve=caseEpreuve;
	}

	public void actionPerformed(ActionEvent e) {

		//Permet de fermer toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}
		//Permet de récupérer l'indice de la case de l'épreuve qui a été conservé dans l'ArrayList de la grille des Epreuves
		int i=PanelBandeau.getGrilleEpreuve().getCases().indexOf(caseEpreuve);

		//Permet d'enregistrer la grille des catégories à la selection epreuve à l'aide de son indice précédemment trouvé
		PanelBandeau.getGrilleEpreuve().getCases().get(i).setGrid(panel.getGrille());

		//Affiche le panelEpreuve en récupérant la grilleEpreuve enregistrer de façon static dans le bandeau
		PanelAfficherEpreuve retourEpreuve;
		
		try {
			retourEpreuve = new PanelAfficherEpreuve(PanelBandeau.getGrilleEpreuve());
			retourEpreuve.afficherFenetre();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		

	}

}
