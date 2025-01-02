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

public class EcouteurEpreuveModifierCategorie implements ActionListener {
  PanelAfficherEpreuve panelAfficher;
    PanelSelectionEpreuve panelCase;

    /**
     * Constructeur EcouteurEpreuveModifierCategorie : 
     * 
     * @param temp2 : PanelSelectionEpreuve
     * @param temp : PanelAfficherEpreuve
     */

    public EcouteurEpreuveModifierCategorie(PanelSelectionEpreuve temp2, PanelAfficherEpreuve temp){

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

      //Affiche le panelAfficherCategorie en sauvegardant la case (pour pouvoir conserver la grille des catégories ensuite)
      //et prend l'épreuve 
      PanelAfficherCategorie modifEpreuve=new PanelAfficherCategorie(panelCase,panelCase.getEpreuve());
      modifEpreuve.afficherFenetre();

      /*PanelAfficherEpreuve panel = new PanelAfficherEpreuve(newGrille);
      panel.afficherFenetre();*/
    }

}
