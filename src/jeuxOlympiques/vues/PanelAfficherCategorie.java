package jeuxOlympiques.vues;

import java.io.Serializable;

import javax.swing.*;

import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Lucas 

/**
 * 
 * @author lpivet
 */
public class PanelAfficherCategorie extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelBandeau bandeau;
	PanelGrille grille;
	JButton ajouter;
	JButton retour;
	JFrame fenetre;
	Epreuve epreuve;
	PanelSelectionEpreuve caseEpreuve;

	/**
	 * Getter de la fenetre enregistrer dans le panel
	 * 
	 * @return fenetre - JFrame
	 */
	public JFrame getFenetre() {
		return fenetre;
	}

	/**
	 * Setter de la fenetre enregistrer dans le panel
	 * 
	 * @param fenetre - JFrame
	 */
	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}

	/**
	 * Permet de créer le PanelAfficherCategorie en conservant le
	 * panelSelectionEpreuve
	 * père ainsi que la grille existante
	 * 
	 * @param caseEpreuve
	 * @param grille
	 */
	// CONSTRUCTEUR ayant conserver la caseEpreuve et la grille
	public PanelAfficherCategorie(Epreuve epreuve, PanelSelectionEpreuve caseEpreuve, PanelGrille grille) {
		this.caseEpreuve = caseEpreuve;
		this.epreuve = epreuve;
		bandeau = new PanelBandeau();
		this.grille = grille;

		ajouter = new JButton("Ajouter une catégorie");
		retour = new JButton("Retour");

		add(bandeau);
		add(grille);
		JPanel buttons = new JPanel();
		buttons.add(ajouter);
		buttons.add(retour);
		add(buttons);

		fenetre = new JFrame("Catégories");
		fenetre.setSize(880, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		EcouteurAfficherAjouterCategorie ajouterListen = new EcouteurAfficherAjouterCategorie(this);
		ajouter.addActionListener(ajouterListen);

		EcouteurRetourEpreuve retourListen = new EcouteurRetourEpreuve(caseEpreuve, this);
		retour.addActionListener(retourListen);

		// Creer une instance de ma classe

		// Ajouter mon instance dans un des conteneurs de la fen?tre

	}

	/**
	 * Getter du PanelSelectionEpreuve du père
	 * 
	 * @return caseEpreuve - PanelSelectionEpreuve
	 */
	public PanelSelectionEpreuve getCaseEpreuve() {
		return caseEpreuve;
	}

	/**
	 * Setter du PanelSelectionEpreuve du père
	 * 
	 * @param caseEpreuve - PanelSelectionEpreuve
	 */
	public void setCaseEpreuve(PanelSelectionEpreuve caseEpreuve) {
		this.caseEpreuve = caseEpreuve;
	}

	/**
	 * Permet de créer le PanelAfficherCategorie en conservant le
	 * panelSelectionEpreuve
	 * père et en récupèrant l'epreuve associer
	 * 
	 * @param caseEpreuve
	 * @param epreuve
	 */
	// CONSTRUCTEUR ayant conserver la caseEpreuve et récupérer l'épreuve
	public PanelAfficherCategorie(PanelSelectionEpreuve caseEpreuve, Epreuve epreuve) {
		this.caseEpreuve = caseEpreuve;
		this.epreuve = epreuve;
		bandeau = new PanelBandeau();

		grille = caseEpreuve.getGrid(); // Prend en grille la grille enregistrer dans la case de l'épreuve (vide de
																		// base)
		ajouter = new JButton("Ajouter une catégorie");
		retour = new JButton("Retour");

		add(bandeau);
		add(grille);
		JPanel buttons = new JPanel();
		buttons.add(ajouter);
		buttons.add(retour);
		add(buttons);

		fenetre = new JFrame("Catégories");
		fenetre.setSize(880, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		// Ecouteur afficher ajouter catégorie
		EcouteurAfficherAjouterCategorie ajouterListen = new EcouteurAfficherAjouterCategorie(this);
		ajouter.addActionListener(ajouterListen);

		// Ecouteur retour vers l'épreuve
		EcouteurRetourEpreuve retourListen = new EcouteurRetourEpreuve(caseEpreuve, this);
		retour.addActionListener(retourListen);

		// Creer une instance de ma classe

		// Ajouter mon instance dans un des conteneurs de la fen?tre

	}

	/**
	 * Getter du bandeau du panel
	 * 
	 * @return bandeau - PanelBandeau
	 */
	public PanelBandeau getBandeau() {
		return bandeau;
	}

	/**
	 * Setter du bandeau du panel
	 * 
	 * @param bandeau - PanelBandeau
	 */
	public void setBandeau(PanelBandeau bandeau) {
		this.bandeau = bandeau;
	}

	/**
	 * Getter du bouton ajouter du panel
	 * 
	 * @return ajouter - JButton
	 */
	public JButton getAjouter() {
		return ajouter;
	}

	/**
	 * Setter du bouton ajouter du panel
	 * 
	 * @param ajouter - JButton
	 */
	public void setAjouter(JButton ajouter) {
		this.ajouter = ajouter;
	}

	/**
	 * Getter de la grille du panel
	 * 
	 * @return grille - PanelGrille
	 */
	public PanelGrille getGrille() {
		return grille;
	}

	/**
	 * Setter de la grille du panel
	 * 
	 * @param grille - PanelGrille
	 */
	public void setGrille(PanelGrille grille) {
		this.grille = grille;
	}

	/**
	 * Permet d'afficher la fenêtre une fois l'objet construit
	 */
	public void afficherFenetre() {

		fenetre.setLocationRelativeTo(null);
		// Afficher la fenetre
		fenetre.setVisible(true);

	}

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	/**
	 * Getter de l'epreuve
	 * 
	 * @return epreuve - Epreuve
	 */
	public Epreuve getEpreuve() {
		return epreuve;
	}

	public static void main(String[] args) {

	}
}
