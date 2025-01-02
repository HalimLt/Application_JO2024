package jeuxOlympiques.vues;

import java.io.Serializable;

import javax.swing.*;
import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Halim
/**
 * @author hluquet
 */
public class PanelAfficherEquipe extends JPanel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelBandeau bandeau;
	PanelGrille grille;
	JButton ajouter;
	JButton retour;
	JFrame fenetre;
	Pays pays;
	PanelSelectionPays casePays;

	public JFrame getFenetre() {
		return fenetre;
	}

	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}

	// CONSTRUCTEUR ayant conserver la casePays et la grille
	public PanelAfficherEquipe(PanelSelectionPays casePays, PanelGrille grille) {
		this.casePays = casePays;
		bandeau = new PanelBandeau();
		this.grille = grille;

		ajouter = new JButton("Ajouter une équipe");
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

		EcouteurAfficherAjouterEquipe ajouterListen = new EcouteurAfficherAjouterEquipe(this);
		ajouter.addActionListener(ajouterListen);

		EcouteurRetourPays retourListen = new EcouteurRetourPays(casePays, this);
		retour.addActionListener(retourListen);

		// Creer une instance de ma classe
		// Ajouter mon instance dans un des conteneurs de la fen?tre
	}

	public PanelSelectionPays getCasePays() {
		return casePays;
	}

	public void setCasePays(PanelSelectionPays casePays) {
		this.casePays = casePays;
	}

	// CONSTRUCTEUR ayant conserver la casePays et récupérer l'épreuve
	public PanelAfficherEquipe(PanelSelectionPays casePays, Pays pays) {
		this.casePays = casePays;
		this.pays = pays;
		bandeau = new PanelBandeau();

		grille = casePays.getGrid(); // Prend en grille la grille enregistrer dans la case du pays (vide de base)
		ajouter = new JButton("Ajouter une équipe");
		retour = new JButton("Retour");

		add(bandeau);
		add(grille);
		JPanel buttons = new JPanel();
		buttons.add(ajouter);
		buttons.add(retour);
		add(buttons);

		fenetre = new JFrame("Equipe");
		fenetre.setSize(880, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		// Ecouteur afficher ajouter équipe
		EcouteurAfficherAjouterEquipe ajouterListen = new EcouteurAfficherAjouterEquipe(this);
		ajouter.addActionListener(ajouterListen);

		// Ecouteur retour vers le pays
		EcouteurRetourPays retourListen = new EcouteurRetourPays(casePays, this);
		retour.addActionListener(retourListen);

		// Creer une instance de ma classe
		// Ajouter mon instance dans un des conteneurs de la fen?tre
	}

	public PanelBandeau getBandeau() {
		return bandeau;
	}

	public void setBandeau(PanelBandeau bandeau) {
		this.bandeau = bandeau;
	}

	public JButton getAjouter() {
		return ajouter;
	}

	public void setAjouter(JButton ajouter) {
		this.ajouter = ajouter;
	}

	public PanelGrille getGrille() {
		return grille;
	}

	public void setGrille(PanelGrille grille) {
		this.grille = grille;
	}

	public void afficherFenetre() {
		// Afficher la fenetre
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}

	public Pays getPays() {
		return pays;
	}
}
