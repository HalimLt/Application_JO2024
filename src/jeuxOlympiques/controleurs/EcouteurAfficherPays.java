package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import jeuxOlympiques.vues.*;

/**
 * 
 * @author sgadewa
 */
//Stephane
public class EcouteurAfficherPays implements ActionListener{

	PanelGrille grid;

	

	/**
	 * Constructeur pour EcouteurAfficherPays
	 * 
	 * @param grille : PanelGrille
	 */

	public EcouteurAfficherPays(PanelGrille grille){
		grid=grille;
	}

	public void actionPerformed(ActionEvent e) {
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}
		PanelAfficherPays pays;
		try {
			pays = new PanelAfficherPays(grid);
			pays.afficherFenetre();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
