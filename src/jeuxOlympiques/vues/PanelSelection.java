package jeuxOlympiques.vues;

import javax.swing.*;

import java.awt.*;
import java.io.Serializable;

import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

/**
 * 
 * @author lpivet
 *
 */
// Lucas
public abstract class PanelSelection extends JPanel {
	
	
	JPanel panelButton;
	JPanel panelTitre;
	JButton buttonTitre;
	JButton buttonSupprimer;
	JButton buttonModifier;
	PanelGrille grid = new PanelGrille();

	/**
	 * Permet de créer un objet PanelSelection
	 */
	public PanelSelection() {

		panelButton = new JPanel();
		panelTitre = new JPanel();

		buttonSupprimer = new JButton("Supprimer");
		buttonModifier = new JButton("Modifier");

		buttonModifier.setBackground(Color.green); // Met le texte du bouton en vert
		buttonSupprimer.setBackground(Color.red);// Met le texte du bouton en rouge

		panelButton.add(buttonSupprimer);
		panelButton.add(buttonModifier);

		panelButton.setLayout(new GridLayout(2, 1)); // Permet d'avoir un bouton l'un au dessus de l'autre

		add(panelTitre);
		add(panelButton);

		setLayout(new GridLayout(1, 2));// Met le titre à gauche et les bouttons à droite
	}

	/**
	 * Getter de panelButton
	 * 
	 * @return panelButton -JPanel
	 */
	public JPanel getPanelButton() {
		return panelButton;
	}

	/**
	 * Setter de panelButton
	 * 
	 * @param panelButton - JPanel
	 */
	public void setPanelButton(JPanel panelButton) {
		this.panelButton = panelButton;
	}

	/**
	 * Getter de panelTitre
	 * 
	 * @return panelTitre -JPanel
	 */
	public JPanel getPanelTitre() {
		return panelTitre;
	}

	/**
	 * Setter de panelTitre
	 * 
	 * @param panelTitre -JPanel
	 */
	public void setPanelTitre(JPanel panelTitre) {
		this.panelTitre = panelTitre;
	}

	/**
	 * Getter de buttonTitre
	 * 
	 * @return buttonTitre - JButton
	 */
	public JButton getButtonTitre() {
		return buttonTitre;
	}

	/**
	 * Setter de buttonTitre
	 * 
	 * @param buttonTitre - JButton
	 */
	public void setButtonTitre(JButton buttonTitre) {
		this.buttonTitre = buttonTitre;
	}

	/**
	 * Getter de buttonSupprimer
	 * 
	 * @return buttonSupprimer - JButton
	 */
	public JButton getButtonSupprimer() {
		return buttonSupprimer;
	}

	/**
	 * Setter de boutonSupprimer
	 * 
	 * @param buttonSupprimer - JButton
	 */
	public void setButtonSupprimer(JButton buttonSupprimer) {
		this.buttonSupprimer = buttonSupprimer;
	}

	/**
	 * Getter de boutonModifier
	 * 
	 * @return buttonModifier - JButton
	 */
	public JButton getButtonModifier() {
		return buttonModifier;
	}

	/**
	 * Setter de boutonModifier
	 * 
	 * @param buttonModifier - JButton
	 */
	public void setButtonModifier(JButton buttonModifier) {
		this.buttonModifier = buttonModifier;
	}

	/**
	 * Getter de grid
	 * 
	 * @return grid - PanelGrille
	 */
	public PanelGrille getGrid() {
		return grid;
	}

	/**
	 * Setter de grid
	 * 
	 * @param grid - PanelGrille
	 */
	public void setGrid(PanelGrille grid) {
		this.grid = grid;
	}

}
