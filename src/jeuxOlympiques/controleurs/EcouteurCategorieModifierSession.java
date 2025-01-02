package jeuxOlympiques.controleurs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import java.awt.Window;

import java.util.ArrayList;

//Lucas REPLIT2
/**
 * @author lpivet
 * 
 */
public class EcouteurCategorieModifierSession implements ActionListener {
  PanelAfficherCategorie panelAfficher;
  PanelSelectionCategorie panelCase;

  
/**
 * Constructeur de EcouteurCategorieModifierSession
 * 
 * @param temp2 : PanelSelectionCategorie
 * @param temp : PanelAfficherCategorie
 */
  public EcouteurCategorieModifierSession(PanelSelectionCategorie temp2, PanelAfficherCategorie temp){

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



    //Affiche le panelAfficherSession en sauvegardant la case (pour pouvoir conserver la grille des catégories ensuite)
    //et prend l'épreuve 
    PanelAfficherSession modifCategorie=new PanelAfficherSession(panelAfficher.getEpreuve(),panelCase,panelCase.getCategorie());

    modifCategorie.afficherFenetre();

    /*PanelAfficherCategorie panel = new PanelAfficherCategorie(newGrille);
      panel.afficherFenetre();*/
  }

}
