package jeuxOlympiques.vues;

import java.io.Serializable;

import javax.swing.*;

import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Lucas
/**
 * @author lpivet
 */

public class PanelAfficherSession extends JPanel implements Serializable{

	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelBandeau bandeau;
	PanelGrille grille;
	JButton ajouter;
	JButton retour;
	JFrame fenetre;
	Categorie categorie;
	PanelSelectionCategorie caseCategorie;
	Epreuve epreuve;

	/**
	 * Getter de la fenetre
	 * 
	 * @return fenetre - JFrame
	 */
	public JFrame getFenetre() {
		return fenetre;
	}

	/**
	 * Setter de la fenetre
	 * 
	 * @param fenetre - JFrame
	 */
	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}

	/**
	 * Permet de créer un PanelAfficherSession en conservant le PanelAfficherSession
	 * père et en récupérant une grille
	 * 
	 * @param caseCategorie - PanelSelectionCategorie
	 * @param grille        - PanelGrille
	 */
	// CONSTRUCTEUR ayant conserver la caseCategorie et la grille
	public PanelAfficherSession(Epreuve epreuve, PanelSelectionCategorie caseCategorie, PanelGrille grille) {
		this.epreuve = epreuve;
		this.caseCategorie = caseCategorie;
		bandeau = new PanelBandeau();
		this.grille = grille;

		ajouter = new JButton("Ajouter une session");
		retour = new JButton("Retour");

		add(bandeau);
		add(grille);
		JPanel buttons = new JPanel();
		buttons.add(ajouter);
		buttons.add(retour);
		add(buttons);

		fenetre = new JFrame("Session");
		fenetre.setSize(880, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		EcouteurAfficherAjouterSession ajouterListen = new EcouteurAfficherAjouterSession(this);
		ajouter.addActionListener(ajouterListen);

		EcouteurRetourCategorie retourListen = new EcouteurRetourCategorie(caseCategorie, this);
		retour.addActionListener(retourListen);

	}

	/**
	 * Getter de caseCategorie
	 * 
	 * @return caseCategorie - PanelSelectionCategorie
	 */
	public PanelSelectionCategorie getCaseCategorie() {
		return caseCategorie;
	}

	/**
	 * Setter de caseCategorie
	 * 
	 * @param caseCategorie - PanelSelectionCategorie
	 */
	public void setCaseCategorie(PanelSelectionCategorie caseCategorie) {
		this.caseCategorie = caseCategorie;
	}

	/**
	 * Permet de créer un PanelAfficherSession en conservant le
	 * PanelSelectionCategorie père et en récupérant la catégorie
	 * 
	 * @param caseCategorie - PanelSelectionCategorie
	 * @param categorie     - Categorie
	 */
	// CONSTRUCTEUR ayant conserver la caseCategorie et récupérer l'épreuve
	public PanelAfficherSession(Epreuve epreuve, PanelSelectionCategorie caseCategorie, Categorie categorie) {
		this.epreuve = epreuve;
		this.caseCategorie = caseCategorie;
		this.categorie = categorie;
		bandeau = new PanelBandeau();

		grille = caseCategorie.getGrid(); // Prend en grille la grille enregistrer dans la case de l'épreuve (vide de
																			// base)
		ajouter = new JButton("Ajouter une session");
		retour = new JButton("Retour");

		add(bandeau);
		add(grille);
		JPanel buttons = new JPanel();
		buttons.add(ajouter);
		buttons.add(retour);
		add(buttons);

		fenetre = new JFrame("Sessions");
		fenetre.setSize(880, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		// Ecouteur afficher ajouter catégorie
		EcouteurAfficherAjouterSession ajouterListen = new EcouteurAfficherAjouterSession(this);
		ajouter.addActionListener(ajouterListen);

		// Ecouteur retour vers l'épreuve
		EcouteurRetourCategorie retourListen = new EcouteurRetourCategorie(caseCategorie, this);
		retour.addActionListener(retourListen);

	}

	/**
	 * Getter de epreuve
	 * 
	 * @return epreuve - Epreuve
	 */
	public Epreuve getEpreuve() {
		return epreuve;
	}

	/**
	 * Setter de epreuve
	 * 
	 * @param epreuve - Epreuve
	 */
	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	/**
	 * Getter de bandeau
	 * 
	 * @return bandeau - PanelBandeau
	 */
	public PanelBandeau getBandeau() {
		return bandeau;
	}

	/**
	 * Setter de bandeau
	 * 
	 * @param bandeau - PanelBandeau
	 */
	public void setBandeau(PanelBandeau bandeau) {
		this.bandeau = bandeau;
	}

	/**
	 * Getter de ajouter
	 * 
	 * @return ajouter - JButton
	 */
	public JButton getAjouter() {
		return ajouter;
	}

	/**
	 * Setter de ajouter
	 * 
	 * @param ajouter - JButton
	 */
	public void setAjouter(JButton ajouter) {
		this.ajouter = ajouter;
	}

	/**
	 * Getter de grille
	 * 
	 * @return grille - PanelGrille
	 */
	public PanelGrille getGrille() {
		return grille;
	}

	/**
	 * Setter de grille
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

	/**
	 * Getter de catégorie
	 * 
	 * @return categorie - Categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	public static void main(String[] args) {

	}
}
