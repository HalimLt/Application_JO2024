package jeuxOlympiques.vues;

import javax.swing.*;

import jeuxOlympiques.controleurs.*;

import jeuxOlympiques.modeles.*;

import java.awt.*;
import java.io.Serializable;

//Lucas 
/**
 * @author lpivet
 */

public class PanelAjouterCategorie extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelSaisie nomCategorie;
	JButton valider;
	PanelGrille grid;
	JFrame fenetre;
	JPanel PanelMain;
	JPanel PanelBouton;
	Epreuve epreuve;
	PanelAfficherCategorie panel;

	/**
	 * Permet de créer un PanelAjouterCategorie en conservant le
	 * PanelAfficherCategorie qui l'a appelé
	 * 
	 * @param panel - PanelAfficherCategorie
	 */
	// CONSTRUCTEUR conservant le panel
	public PanelAjouterCategorie(PanelAfficherCategorie panel, Epreuve epreuve) {

		this.panel = panel;
		nomCategorie = new PanelSaisie("Nom de la catégorie : ");

		valider = new JButton("Valider");
		grid = panel.getGrille();

		// Affichage graphique
		PanelMain = new JPanel();

		PanelMain.setLayout(new BorderLayout());
		PanelMain.setLayout(new GridLayout(3, 1));

		PanelMain.add(nomCategorie, BorderLayout.NORTH);

		PanelBouton = new JPanel();
		PanelBouton.add(valider);

		PanelMain.add(PanelBouton, BorderLayout.CENTER);

		add(PanelMain);

		// Créer la fenêtre
		fenetre = new JFrame("Ajouter/Modifier une catégorie");
		fenetre.setSize(400, 100);
		fenetre.add(this);
		fenetre.pack();

		// Ecouteur ajouter Categorie sur le boutton valider en conservant toujours le
		// panel et la grille
		EcouteurAjouterCategorie ajouter = new EcouteurAjouterCategorie(panel, panel.getEpreuve(), valider, grid, fenetre,
				nomCategorie.getText());
		valider.addActionListener(ajouter);

	}

	/**
	 * créer un PanelAjouterCategorie en conservant le PanelAfficherCategorie qui
	 * l'a appelé, son épreuve ainsi que la grille des épreuves
	 * 
	 * @param panel   - PanelAfficherCategorie
	 * @param epreuve - Epreuve
	 * @param grille  - PanelGrille
	 */
	// CONSTRUCTEUR conservant le panel afficher catégorie, l'épreuve et la grille
	public PanelAjouterCategorie(PanelAfficherCategorie panel, Epreuve epreuve, PanelGrille grille) {

		this.panel = panel;

		nomCategorie = new PanelSaisie("Nom de la catégorie : ");

		valider = new JButton("Valider");
		grid = grille;

		// Affichage graphique
		PanelMain = new JPanel();

		PanelMain.setLayout(new BorderLayout());
		PanelMain.setLayout(new GridLayout(3, 1));

		PanelMain.add(nomCategorie, BorderLayout.NORTH);

		PanelBouton = new JPanel();
		PanelBouton.add(valider);

		PanelMain.add(PanelBouton, BorderLayout.CENTER);

		add(PanelMain);

		// Créer la fenêtre
		fenetre = new JFrame("Ajouter/Modifier une catégorie");
		fenetre.setSize(400, 100);
		fenetre.add(this);
		fenetre.pack();

		EcouteurAjouterCategorie ajouter = new EcouteurAjouterCategorie(panel, panel.getEpreuve(), valider, grid, fenetre,
				nomCategorie.getText());
		valider.addActionListener(ajouter);

	}

	/**
	 * Permet d'afficher la fenêtre une fois l'objet construit
	 */
	public void afficherFenetre() {
		fenetre.setLocationRelativeTo(null);

		fenetre.setVisible(true);

	}

	/**
	 * Getter de epreuve
	 * 
	 * @return epreuve - Epreuve
	 */
	public Epreuve getEpreuve() {
		return epreuve;
	}

}
