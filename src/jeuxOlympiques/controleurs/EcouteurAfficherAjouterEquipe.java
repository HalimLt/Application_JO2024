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
public class EcouteurAfficherAjouterEquipe implements ActionListener {

  //Halim
  PanelAfficherEquipe panelAfficher;

  

  /**
   * Constructeur pour EcouteurAfficherAjouterEquipe
   * 
   * @param temp : PanelAfficherEquipe
   */
  public EcouteurAfficherAjouterEquipe(PanelAfficherEquipe temp){
    panelAfficher=temp;
  }

  //Halim
  
  public void actionPerformed(ActionEvent event) {
    //Ferme toutes les fenêtres
    for (Window window : Window.getWindows()) {
      if (window instanceof JFrame) {
        window.dispose();
      }
    }
    //Affiche le panel ajouter catégorie en conservant le panelAfficher
    PanelAjouterEquipe panel = new PanelAjouterEquipe(panelAfficher);
    panel.afficherFenetre();
  }
}