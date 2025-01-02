package jeuxOlympiques.controleurs;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;

/**
 * 
 * @author hluquet
 */
public class EcouteurAfficherAjouterPays implements ActionListener {

	//Halim
	PanelAfficherPays panelAfficher;

	

	/**
	 * 
	 * Constructeur pour EcouteurAfficherAjouterPays
	 * 
	 * @param temp : PanelAfficherPays
	 */
	//CONSTRUCTEUR
	public EcouteurAfficherAjouterPays(PanelAfficherPays temp){

		panelAfficher=temp;
	}

	//Halim
	public void actionPerformed(ActionEvent event) {

		//permet de fermer toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}
		//permet d'afficher le panel ajouterPays
		PanelAjouterPays panel = new PanelAjouterPays(panelAfficher.getGrillePays());
		panel.afficherFenetre();
	}
}