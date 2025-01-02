package jeuxOlympiques.controleurs;

import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Lucas 
/**
 * 
 * @author lpivet
 * 
 */
public class EcouteurAjouterCategorie implements ActionListener {

  //ATTRIBUTS
  JButton valider;
  PanelGrille grille;
  JFrame nouvelleFenetreAffiche;
  JFrame ancienneFenetre;
  JTextField nomCategorie;
  Epreuve epreuve;
  PanelAfficherCategorie panel;

 

  /**
   * Constructeur pour EcouteurAjouterCategorie
   * 
   * @param panel : PanelAfficherCategorie
   * @param epreuve : Epreuve
   * @param accept : JButton
   * @param grid : PanelGrille
   * @param fen : JFrame
   * @param nom : JTextField
   */

  //CONSTRUCTEUR conservant le panel et la grille
  public EcouteurAjouterCategorie(PanelAfficherCategorie panel,Epreuve epreuve,JButton accept, PanelGrille grid, JFrame fen, JTextField nom) {
    this.panel=panel;
    this.epreuve=epreuve;
    valider = accept;
    grille = grid;

    //Créer une nouvelle fenêtre
    nouvelleFenetreAffiche = new JFrame("Categorie");
    nouvelleFenetreAffiche.setSize(800, 500);
    nouvelleFenetreAffiche.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ancienneFenetre = fen;

    nomCategorie = nom;

  }

  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == valider) {

      //Ferme la fenêtre de ajouter Categorie
      ancienneFenetre.dispose();

      //Créer le panel selection Categorie
      PanelSelectionCategorie selectionTemp;

      selectionTemp = new PanelSelectionCategorie(new Categorie(epreuve,nomCategorie.getText()));	
      selectionTemp.setSelectionEpreuve(panel.getCaseEpreuve());

      //Ajoute le panel à la grille et affiche le nouveau panel afficher categorie (en ayant conserver la case de l'épreuve 
      //grâce à panel.getCaseEpreuve()
      grille.ajouterSelection(selectionTemp);
      PanelAfficherCategorie afficherCategorie = new PanelAfficherCategorie(panel.getEpreuve(),panel.getCaseEpreuve(),grille);

      //Permet d'initialiser les écouteurs en gardant le panel afficher catégorie pour pouvoir ensuite récupérer le panel selection et la grid
      selectionTemp.ajouterEcouteurs(afficherCategorie); 

      nouvelleFenetreAffiche.add(afficherCategorie);

      nouvelleFenetreAffiche.setLocationRelativeTo(null);

      nouvelleFenetreAffiche.setVisible(true);

    }
  }
}
