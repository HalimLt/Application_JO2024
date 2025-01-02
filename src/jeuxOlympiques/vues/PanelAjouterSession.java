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

public class PanelAjouterSession extends JPanel implements Serializable{

	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelSaisie typeSession;
	PanelSaisie descSession;
	PanelSaisie dateSession;
	PanelSaisie heureDebut;
	PanelSaisie heureFin;
	JButton valider;
	PanelGrille grid;
	JFrame fenetre;
	JPanel PanelMain;
	JPanel PanelBouton;
	Categorie categorie;
	PanelAfficherSession panel;

	/**
	 * Méthode qui permet de créer le PanelAjouterSession en conservant le panel
	 * 
	 * @param panel - PanelAfficherSession
	 */
	// CONSTRUCTEUR 
	public PanelAjouterSession(PanelAfficherSession panel) {

		this.panel = panel;
		typeSession = new PanelSaisie("Type de la session: ");
		descSession = new PanelSaisie("Description de la session: ");
		dateSession = new PanelSaisie("Date de la session: ");
		heureDebut = new PanelSaisie("Heure de début de la session: ");
		heureFin = new PanelSaisie("Heure de fin de la session: ");

		valider = new JButton("Valider");
		grid = panel.getGrille();

		// Affichage graphique
		PanelMain = new JPanel();

		PanelMain.setLayout(new BorderLayout());
		PanelMain.setLayout(new GridLayout(3, 1));

		PanelMain.add(typeSession, BorderLayout.NORTH);
		PanelMain.add(descSession, BorderLayout.NORTH);
		PanelMain.add(dateSession, BorderLayout.NORTH);
		PanelMain.add(heureDebut, BorderLayout.NORTH);
		PanelMain.add(heureFin, BorderLayout.NORTH);

		PanelBouton = new JPanel();
		PanelBouton.add(valider);

		PanelMain.add(PanelBouton, BorderLayout.CENTER);

		add(PanelMain);

		// Créer la fenêtre
		fenetre = new JFrame("Ajouter/Modifier une catégorie");
		fenetre.setSize(400, 100);
		fenetre.add(this);
		fenetre.pack();

		// Ecouteur ajouter Session sur le boutton valider en conservant toujours le
		// panel et la grille
		EcouteurAjouterSession ajouter = new EcouteurAjouterSession(panel, categorie, valider, grid, fenetre,
				typeSession.getText(), descSession.getText(), dateSession.getText(), heureDebut.getText(), heureFin.getText());
		valider.addActionListener(ajouter);

	}
	/**
	 * Méthode qui permet de créer le PanelAjouterSession en conservant le panel la catégorie et la grille 
	 * 
	 * @param panel     - PanelAfficherSession
	 * @param categorie - Categorie
	 * @param grille    - PanelGrille
	 */
	// CONSTRUCTEUR conservant le panel afficher catégorie et la grille
	public PanelAjouterSession(PanelAfficherSession panel, Categorie categorie, PanelGrille grille) {

		this.panel = panel;

		this.categorie = categorie;

		typeSession = new PanelSaisie("Type de la session: ");
		descSession = new PanelSaisie("Description de la session: ");
		dateSession = new PanelSaisie("Date de la session: ");
		heureDebut = new PanelSaisie("Heure de début de la session: ");
		heureFin = new PanelSaisie("Heure de fin de la session: ");

		valider = new JButton("Valider");
		grid = grille;

		// Affichage graphique
		PanelMain = new JPanel();

		PanelMain.setLayout(new BorderLayout());
		PanelMain.setLayout(new GridLayout(3, 1));

		PanelMain.add(typeSession, BorderLayout.NORTH);
		PanelMain.add(descSession, BorderLayout.NORTH);
		PanelMain.add(dateSession, BorderLayout.NORTH);
		PanelMain.add(heureDebut, BorderLayout.NORTH);
		PanelMain.add(heureFin, BorderLayout.NORTH);

		PanelBouton = new JPanel();
		PanelBouton.add(valider);

		PanelMain.add(PanelBouton, BorderLayout.CENTER);

		add(PanelMain);

		// Créer la fenêtre
		fenetre = new JFrame("Ajouter/Modifier une catégorie");
		fenetre.setSize(400, 100);
		fenetre.add(this);
		fenetre.pack();

		EcouteurAjouterSession ajouter = new EcouteurAjouterSession(panel, categorie, valider, grid, fenetre,
				typeSession.getText(), descSession.getText(), dateSession.getText(), heureDebut.getText(), heureFin.getText());
		valider.addActionListener(ajouter);

	}

	/**
	 * Methode qui permet d'afficher la fenetre
	 */
	public void afficherFenetre() {
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);

	}

	/**
	 * Getter de categorie
	 * 
	 * @return categorie - Categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

}
