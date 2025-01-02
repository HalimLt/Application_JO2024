package jeuxOlympiques.vues;

import java.awt.Color;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Halim
/**
 * @author hluquet
 */
public class PanelSelectionEquipe extends PanelSelection {

	PanelSelectionPays pays;
	Equipe equipe;

	/**
	 * Permet de créer un objet equipe en appelant le constructeur panelSelection
	 * 
	 * @param equipe - Equipe
	 */
	public PanelSelectionEquipe(Equipe equipe) {
		super();
		this.equipe = equipe;
		buttonTitre = new JButton(equipe.getSonEpreuve() + " :\n" + equipe.getSaCategorie());
		buttonTitre.setForeground(Color.white); // Met le texte du label en blanc
		buttonTitre.setBackground(Color.blue);
		panelTitre.add(buttonTitre);
		panelTitre.setBackground(Color.blue);
	}

	// Permet d'initialiser les écouteurs modifier et supprimer (en conservant le
	// PanelAfficherCategorie pour garder la grille des catégories
	// ainsi que la case de l'épreuve)
	/**
	 * Permet d'initialiser les écouteurs modifier et supprimer (en conservant le
	 * PanelAfficherCategorie pour garder la grille des catégories
	 * ainsi que la case de l'épreuve)
	 * @param temp - PanelAfficherEquipe
	 */
	public void ajouterEcouteurs(PanelAfficherEquipe temp) {
		buttonSupprimer.addActionListener(new EcouteurSupprimerElementGrilleEquipe(this, temp));
		buttonModifier.addActionListener(new EcouteurModifierElementGrilleEquipe(this, temp));
	}

	/**
	 * Getter de pays
	 * 
	 * @return pays - PanelSelectionPays
	 */
	public PanelSelectionPays getPays() {
		return pays;
	}

	/**
	 * Setter de pays
	 * 
	 * @param pays - PanelSelectionPays
	 */
	public void setPays(PanelSelectionPays pays) {
		this.pays = pays;
	}

	/**
	 * Getter de pays
	 * 
	 * @return equipe - Equipe
	 */
	public Equipe getEquipe() {
		return equipe;
	}
}
