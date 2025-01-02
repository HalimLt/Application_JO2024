package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import jeuxOlympiques.modeles.*;
import jeuxOlympiques.vues.*;


//Halim
/**
* @author hluquet
*/



public class EcouteurModifierElementGrilleEquipe implements ActionListener{

    PanelAfficherEquipe panelAfficher;
    PanelSelection panelCase;

    /**
     * Constructeur pour EcouteurModifierElementGrilleEquipe
     * 
     * @param temp2 : PanelSelection
     * @param temp : PanelAfficherEquipe
     */

    public EcouteurModifierElementGrilleEquipe(PanelSelection temp2, PanelAfficherEquipe temp){
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
      //Récupère la grille du panel afficher équipe et supprime la case(selection)
      PanelGrille newGrille = panelAfficher.getGrille();
      newGrille.supprimerSelection(panelCase);

      //Converti le panel Selection en panel Selection Equipe
      PanelSelectionEquipe panelCaseActuel=(PanelSelectionEquipe)panelCase;

      //Appelle le ajouterCatégorie en conservant le panel afficher catégorie et la grille modifier
      PanelAjouterEquipe modifEquipe=new PanelAjouterEquipe(panelAfficher,null,newGrille);

      modifEquipe.afficherFenetre();
    }

  }
