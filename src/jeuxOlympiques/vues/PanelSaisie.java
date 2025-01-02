package jeuxOlympiques.vues;

import javax.swing.*;

/**
 * 
 * @author ese
 *
 */
public class PanelSaisie extends JPanel {

	// Déclarer les composants du panel en tant qu'attributs
	// pour qu'ils soient accessibles par toutes les méthodes
	JLabel label;
	JTextField text;

	/**
	 * Constructeur d'un panel saisie qui prend un string et permet de créer un
	 * champ de texte avec un nom
	 * 
	 * @param s - String
	 */
	PanelSaisie(String s) {

		// Créer les composants
		label = new JLabel(s);
		text = new JTextField(10);
		text.setText("");
		// Ajouter les composants dans CE paneau : ceci est possible car
		// cette classe (PanelSaisie) hérite de JPanel
		add(label);
		add(text);
	}

	public static void main(String[] args) {
		// Creer une fenetre
		JFrame fenetre = new JFrame("Test de ma classe PanelSaisie");
		fenetre.setSize(400, 100);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creer une instance de ma classe
		PanelSaisie p = new PanelSaisie("Nom");

		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}

	/**
	 * Getter de label
	 * 
	 * @return label - JLabel
	 */
	public JLabel getLabel() {
		return label;
	}

	/**
	 * Setter de label
	 * 
	 * @param label - JLabel
	 */
	public void setLabel(JLabel label) {
		this.label = label;
	}

	/**
	 * Getter de text
	 * 
	 * @return text - JTextField
	 */
	public JTextField getText() {
		return text;
	}

	/**
	 * Setter de text
	 * 
	 * @param text - JTextField
	 */
	public void setText(JTextField text) {
		this.text = text;
	}

}