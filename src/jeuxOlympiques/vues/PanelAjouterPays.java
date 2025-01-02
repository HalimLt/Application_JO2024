package jeuxOlympiques.vues;

import javax.swing.*;
import jeuxOlympiques.controleurs.*;
import java.awt.*;
import java.io.Serializable;

//Halim 
/**
 * @author hluquet
 */
public class PanelAjouterPays extends JPanel implements Serializable{

	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelSaisie nomPays;
	JButton valider;
	PanelGrille grid;
	JFrame fenetre;
	JPanel PanelMain;
	JPanel PanelBouton;

	/**
	 * Constructeur pour PanelAjouterPays récupérant la grille pour la conserver
	 * @param grille - PanelGrille 
	 */
	// CONSTRUCTEUR avec la grille (pour la conservation)
	public PanelAjouterPays(PanelGrille grille) {

		// Définition des attributs
		nomPays = new PanelSaisie("Nom du Pays : ");
		valider = new JButton("Valider");
		grid = grille;

		// Affichage graphique
		PanelMain = new JPanel();

		PanelMain.setLayout(new BorderLayout());
		PanelMain.setLayout(new GridLayout(2, 1));

		PanelMain.add(nomPays, BorderLayout.NORTH);

		PanelBouton = new JPanel();
		PanelBouton.add(valider);
		PanelMain.add(PanelBouton, BorderLayout.CENTER);
		add(PanelMain);

		// Créer la nouvelle fenêtre
		fenetre = new JFrame("Ajouter/Modifier une Pays");
		fenetre.setSize(400, 100);
		fenetre.add(this);
		fenetre.pack();

		// ajoute l'écouteur au bouton valider en récupérant les informations du
		// panelAjouterPays (tout en conservant la grid)
		EcouteurAjouterPays ajouterPays = new EcouteurAjouterPays(valider, grid, fenetre, nomPays.getText());
		valider.addActionListener(ajouterPays);
	}


	/**
	 * Méthode pour afficher l'objet 
	 */
	public void afficherFenetre() {
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}
}
