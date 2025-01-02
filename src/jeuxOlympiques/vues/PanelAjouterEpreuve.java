package jeuxOlympiques.vues;

import javax.swing.*;

import jeuxOlympiques.controleurs.*;

import java.awt.*;
import java.io.Serializable;

//Lucas
/**
 * @author lpivet
 */

public class PanelAjouterEpreuve extends JPanel implements Serializable{

	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelSaisie nomEpreuve;
	PanelSaisie descriptionEpreuve;
	JButton valider;
	PanelGrille grid;
	JFrame fenetre;
	JPanel PanelMain;
	JPanel PanelBouton;

	// CONSTRUCTEUR avec la grille (pour la conservation)
	public PanelAjouterEpreuve(PanelGrille grille) {

		// Définition des attributs
		nomEpreuve = new PanelSaisie("Nom de l'épreuve : ");
		descriptionEpreuve = new PanelSaisie("Description de l'épreuve");
		valider = new JButton("Valider");
		grid = grille;

		// Affichage graphique
		PanelMain = new JPanel();

		PanelMain.setLayout(new BorderLayout());
		PanelMain.setLayout(new GridLayout(3, 1));

		PanelMain.add(nomEpreuve, BorderLayout.NORTH);
		PanelMain.add(descriptionEpreuve, BorderLayout.NORTH);

		PanelBouton = new JPanel();
		PanelBouton.add(valider);

		PanelMain.add(PanelBouton, BorderLayout.CENTER);

		add(PanelMain);

		// Créer la nouvelle fenêtre
		fenetre = new JFrame("Ajouter/Modifier une epreuve");
		fenetre.setSize(400, 100);
		fenetre.add(this);
		fenetre.pack();

		// ajoute l'écouteur au bouton valider en récupérant les informations du
		// panelAjouterEpreuve (tout en conservant la grid)
		EcouteurAjouterEpreuve ajouterEpreuve = new EcouteurAjouterEpreuve(valider, grid, fenetre, nomEpreuve.getText(),
				descriptionEpreuve.getText());
		valider.addActionListener(ajouterEpreuve);

	}

	public void afficherFenetre() {
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);

	}

}
