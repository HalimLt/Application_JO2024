package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import jeuxOlympiques.vues.*;

/**
 * @author lpivet
 * 
 */

public class EcouteurRetourCategorie implements ActionListener {

	PanelAfficherSession panel;
	PanelSelectionCategorie caseCategorie;

	/**
	 * Constructeur pour EcouteurRetourCategorie
	 * 
	 * @param caseCategorie : PanelSelectionCategorie
	 * @param panel : PanelAfficherSession
	 */
	public EcouteurRetourCategorie(PanelSelectionCategorie caseCategorie,PanelAfficherSession panel){
		this.panel=panel;
		this.caseCategorie=caseCategorie;
	}

	public void actionPerformed(ActionEvent e) {

		//Permet de fermer toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}

		int i=PanelBandeau.getGrilleEpreuve().getCases().indexOf(caseCategorie.getSelectionEpreuve());

		int j=PanelBandeau.getGrilleEpreuve().getCases().get(i).getGrid().getCases().indexOf(caseCategorie);


		PanelBandeau.getGrilleEpreuve().getCases().get(i).getGrid().getCases().get(j).setGrid(panel.getGrille());


		//Affiche le panelCategorie en récupérant la grilleCategorie enregistrer de façon static dans le bandeau
		PanelAfficherCategorie retourCategorie=new PanelAfficherCategorie(panel.getEpreuve(),caseCategorie.getSelectionEpreuve(),PanelBandeau.getGrilleEpreuve().getCases().get(i).getGrid());

		retourCategorie.afficherFenetre();

	}

}
