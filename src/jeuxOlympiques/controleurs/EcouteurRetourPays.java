package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import jeuxOlympiques.vues.*;

//Halim
/**
 * @author hluquet
 */
public class EcouteurRetourPays implements ActionListener {

	PanelAfficherEquipe panel;
	PanelSelectionPays casePays;

	/**
	 * Constructeur pour EcouteurRetourPays
	 * 
	 * @param casePays : PanelSelectionPays
	 * @param panel : PanelAfficherEquipe
	 */

	public EcouteurRetourPays(PanelSelectionPays casePays,PanelAfficherEquipe panel){
		this.panel=panel;
		this.casePays=casePays;
	}

	public void actionPerformed(ActionEvent e) {

		//Permet de fermer toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}
		//Permet de récupérer l'indice de la case de l'épreuve qui a été conservé dans l'ArrayList de la grille des Payss
		int i=PanelBandeau.getGrillePays().getCases().indexOf(casePays);

		//Permet d'enregistrer la grille des catégories à la selection Pays à l'aide de son indice précédemment trouvé
		PanelBandeau.getGrillePays().getCases().get(i).setGrid(panel.getGrille());

		//Affiche le panelPays en récupérant la grillePays enregistrer de façon static dans le bandeau
		PanelAfficherPays retourPays;
		try {
			retourPays = new PanelAfficherPays(PanelBandeau.getGrillePays());
			retourPays.afficherFenetre();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
}
