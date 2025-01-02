package jeuxOlympiques.vues;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;

import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

/**
 * @author lpivet
 */

// Lucas

public class PanelSelectionCategorie extends PanelSelection {
	
	PanelSelectionEpreuve epreuve;
	Categorie categorie;

	/**
	 * Getter de epreuve
	 * 
	 * @return epreuve - PanelSelectionEpreuve
	 */
	public PanelSelectionEpreuve getSelectionEpreuve() {
		return epreuve;
	}

	/**
	 * Setter de epreuve
	 * 
	 * @param epreuve - PanelSelectionEpreuve
	 */
	public void setSelectionEpreuve(PanelSelectionEpreuve epreuve) {
		this.epreuve = epreuve;
	}

	/**
	 * Permet de créer un objet catégorie en appelant le constructeur panelSelection
	 * 
	 * @param categorie - Categorie
	 */
	public PanelSelectionCategorie(Categorie categorie) {
		super();
		this.categorie = categorie;

		buttonTitre = new JButton("       " + categorie.getNomCategorie() + "       ");
		buttonTitre.setForeground(Color.white); // Met le texte du label en blanc
		buttonTitre.setBackground(Color.blue);
		panelTitre.add(buttonTitre);
		panelTitre.setBackground(Color.blue);
	}

	/**
	 * Permet d'initialiser les écouteurs modifier, supprimer et titre (en
	 * conservant le PanelAfficherCategorie pour garder la grille des catégories
	 * ainsi que la case de l'épreuve)
	 * 
	 * @param temp - PanelAfficherCategorie
	 */
	public void ajouterEcouteurs(PanelAfficherCategorie temp) {

		buttonSupprimer.addActionListener(new EcouteurSupprimerElementGrilleCategorie(this, temp));
		buttonModifier.addActionListener(new EcouteurModifierElementGrilleCategorie(this, temp));
		buttonTitre.addActionListener(new EcouteurCategorieModifierSession(this, temp));
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
