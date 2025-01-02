package jeuxOlympiques.vues;

import javax.swing.*;
import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

//Halim
/**
 * @author hluquet
 */
public class PanelAjouterEquipe extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	
	JButton valider;
	JButton retour;
	PanelGrille grid;
	JFrame fenetre;
	JPanel PanelMain;
	JPanel PanelBouton;
	Pays pays;
	PanelAfficherEquipe panel;
	JLabel sonEpreuve;
	JLabel saCategorie;
	ArrayList<Epreuve> epreuves;
	JComboBox<Epreuve> comboBoxEpreuve;
	JComboBox<Categorie> comboBoxCategorie;

	/**
	 * Constructeur pour PanelAjouterEquipe récupérant le PanelAfficherEquipe père
	 * 
	 * @param panel - PanelAfficherEquipe
	 */
	// CONSTRUCTEUR conservant le panel
	public PanelAjouterEquipe(PanelAfficherEquipe panel) {
		this.panel = panel;

		epreuves = Epreuve.JOParis.getSesEpreuves();
		comboBoxEpreuve = new JComboBox<>();
		sonEpreuve = new JLabel("Epreuve de l'équipe : ");
		for (Epreuve epreuve : epreuves) {
			comboBoxEpreuve.addItem(epreuve);
		}
		comboBoxEpreuve.setBounds(50, 100, 150, 20);

		saCategorie = new JLabel("Catégories de l'épreuve : ");
		comboBoxCategorie = new JComboBox<>();
		comboBoxEpreuve.setBounds(50, 100, 150, 20);

		valider = new JButton("Valider");
		retour = new JButton("Retour");
		grid = panel.getGrille();

		// Affichage graphique
		PanelMain = new JPanel();

		PanelMain.setLayout(new BorderLayout());
		PanelMain.setLayout(new GridLayout(3, 2));

		PanelMain.add(sonEpreuve/* , BorderLayout.NORTH */);
		PanelMain.add(comboBoxEpreuve);
		PanelMain.add(saCategorie/* , BorderLayout.NORTH */);
		PanelMain.add(comboBoxCategorie);
		PanelMain.add(valider);
		PanelMain.add(retour);
		add(PanelMain);
		// Créer la fenêtre
		fenetre = new JFrame("Ajouter/Modifier une équipe");
		fenetre.setSize(400, 100);
		fenetre.add(this);
		fenetre.pack();
		EcouteurComboBoxEpreuve ecouteurComboBoxEpreuve = new EcouteurComboBoxEpreuve(comboBoxCategorie);
		comboBoxEpreuve.addActionListener(ecouteurComboBoxEpreuve);

		// Ecouteur ajouter Equipe sur le boutton valider en conservant toujours le
		// panel et la grille
		EcouteurAjouterEquipe ajouter = new EcouteurAjouterEquipe(panel, pays, valider, grid, fenetre, comboBoxEpreuve,
				comboBoxCategorie/* , nomCatégorie.getText() */);
		valider.addActionListener(ajouter);

		EcouteurRetourAccueil retourAccueil = new EcouteurRetourAccueil();
		retour.addActionListener(retourAccueil);

	}

	// CONSTRUCTEUR conservant le panel afficher catégorie, l'épreuve et la grille
	/**
	 * Constructeur pour PanelAjouterEquipe récupérant le PanelAfficherEquipe père, le pays affilier, ainsi que la grille (pour la conserver)
	 * @param panel - PanelAfficherEquipe
	 * @param pays - Pays
	 * @param grille - PanelGrille
	 */
	public PanelAjouterEquipe(PanelAfficherEquipe panel, Pays pays, PanelGrille grille) {

		this.panel = panel;
		this.pays = pays;

		epreuves = Epreuve.JOParis.getSesEpreuves();
		comboBoxEpreuve = new JComboBox<>();
		sonEpreuve = new JLabel("Epreuve de l'équipe : ");
		for (Epreuve epreuve : epreuves) {
			comboBoxEpreuve.addItem(epreuve);
		}
		comboBoxEpreuve.setBounds(50, 100, 150, 20);

		saCategorie = new JLabel("Catégories de l'épreuve : ");
		comboBoxCategorie = new JComboBox<>();
		comboBoxEpreuve.setBounds(50, 100, 150, 20);

		valider = new JButton("Valider");
		retour = new JButton("Retour");
		grid = grille;

		// Affichage graphique
		PanelMain = new JPanel();
		PanelMain.setLayout(new BorderLayout());
		PanelMain.setLayout(new GridLayout(3, 1));
		PanelMain.add(sonEpreuve/* , BorderLayout.NORTH */);
		PanelMain.add(comboBoxEpreuve);
		PanelMain.add(saCategorie/* , BorderLayout.NORTH */);
		PanelMain.add(comboBoxCategorie);
		PanelMain.add(valider);
		PanelMain.add(retour);

		add(PanelMain);
		// Créer la fenêtre
		fenetre = new JFrame("Ajouter/Modifier une équipe");
		fenetre.setSize(400, 100);
		fenetre.add(this);
		fenetre.pack();

		EcouteurComboBoxEpreuve ecouteurComboBoxEpreuve = new EcouteurComboBoxEpreuve(comboBoxCategorie);
		comboBoxEpreuve.addActionListener(ecouteurComboBoxEpreuve);

		// Ecouteur ajouter Equipe sur le boutton valider en conservant toujours le
		// panel et la grille
		EcouteurAjouterEquipe ajouter = new EcouteurAjouterEquipe(panel, pays, valider, grid, fenetre, comboBoxEpreuve,
				comboBoxCategorie/* , nomCatégorie.getText() */);
		valider.addActionListener(ajouter);

		EcouteurRetourAccueil retourAccueil = new EcouteurRetourAccueil();
		retour.addActionListener(retourAccueil);
	}

	/**
	 * Permet d'afficher la fenêtre
	 */
	public void afficherFenetre() {
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}

	/**
	 * Getter de pays
	 * @return pays - Pays
	 */
	public Pays getPays() {
		return pays;
	}



}
