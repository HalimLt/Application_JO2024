package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import jeuxOlympiques.vues.*;

/**
 * 
 * @author lpivet
 *
 */

public class EcouteurRetourAccueil implements ActionListener {

  public void actionPerformed(ActionEvent e) {

	  
    //Permet de fermer toutes les fenêtres
    for (Window window : Window.getWindows()) {
      if (window instanceof JFrame) {
        window.dispose();
      }
    }
    //Affiche le panelCategorie en récupérant la grilleCategorie enregistrer de façon static dans le bandeau
    PanelAccueil retourCategorie=new PanelAccueil();
    retourCategorie.afficherFenetre();

  }

}
