package jeuxOlympiques.controleurs;

import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//Lucas REPLIT
/**
 * 
 * @author lpivet
 */
public class EcouteurAjouterEpreuve implements ActionListener {
	//ATTRIBUTS
	JButton valider;
	PanelGrille grille;
	JFrame nouvelleFenetreAfficheEpreuve;
	JFrame ancienneFenetre;
	JTextField nomEpreuve;
	JTextField descriptionEpreuve;

	

	/**
	 * Constructeur pour EcouteurAjouterEpreuve
	 * 
	 * @param accept : JButton
	 * @param grid : PanelGrille
	 * @param fen : JFrame
	 * @param nom : JTextField
	 * @param description : JTextField
	 */
	//CONSTRUCTEUR
	public EcouteurAjouterEpreuve(JButton accept, PanelGrille grid, JFrame fen, JTextField nom, JTextField description) {
		valider = accept;
		grille = grid;

		//Créer une nouvelle fenêtre pour afficher la nouvelle fenêtre épreuve
		nouvelleFenetreAfficheEpreuve = new JFrame("Epreuves");
		nouvelleFenetreAfficheEpreuve.setSize(800, 500);
		nouvelleFenetreAfficheEpreuve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ancienneFenetre = fen; //Fenetre d'ajouter Epreuve

		nomEpreuve = nom;
		descriptionEpreuve = description;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == valider) {

			//Ferme la fenêtre ajouterEpreuve
			ancienneFenetre.setVisible(false);

			//Créer le panelSelectionEpreuve et l'ajoute à la grille
			PanelSelectionEpreuve selectionTemp;
			Epreuve epreuve = new Epreuve(nomEpreuve.getText(), descriptionEpreuve.getText());
			selectionTemp = new PanelSelectionEpreuve(epreuve);
			grille.ajouterSelection(selectionTemp);

			//Création d'un nouveau panel avec la nouvelle grille
			PanelAfficherEpreuve afficherEpreuve;
			try {
				afficherEpreuve = new PanelAfficherEpreuve(grille);
				selectionTemp.ajouterEcouteurs(afficherEpreuve);

				nouvelleFenetreAfficheEpreuve.add(afficherEpreuve);

				nouvelleFenetreAfficheEpreuve.setLocationRelativeTo(null);

				nouvelleFenetreAfficheEpreuve.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			



		}
	}
}
