package jeuxOlympiques.vues;

import javax.swing.*;

import java.util.ArrayList;
import java.awt.*;
import java.io.Serializable;

//Lucas 

/**
 * 
 * @author lpivet
 *
 */
public class PanelGrille extends JPanel implements Serializable{

	private static final long serialVersionUID = 1L;
	ArrayList<PanelSelection> cases;

	/**
	 * Getter qui retourne une case.
	 * 
	 * @return cases - ArrayList<PanelSelection> cases;
	 */
	public ArrayList<PanelSelection> getCases() {
		return cases;
	}

	/**
	 * Setter qui donne la case dans l'arrayList
	 * 
	 * @param cases - ArrayList<PanelSelection> cases;
	 */
	public void setCases(ArrayList<PanelSelection> cases) {
		this.cases = cases;
	}

	/**
	 * Créer un objet panelGrille
	 */
	PanelGrille() {
		cases = new ArrayList<PanelSelection>();
		setLayout(new GridLayout(0, 2));
	}

	/**
	 * Permet d'ajouter un case de type PanelSelection à l'ArrayList
	 * 
	 * @param temp - ArrayList<PanelSelection> cases;
	 */
	public PanelGrille(ArrayList<PanelSelection> temp) {
		cases = temp;
		setLayout(new GridLayout(0, 2));
	}

	/**
	 * Méthode qui permet d'ajouter un objet de type selection
	 * 
	 * @param selection - PanelSelection
	 */
	public void ajouterSelection(PanelSelection selection) {
		effacerGrille();
		cases.add(selection);
		afficherGrille();
	}

	/**
	 * Méthode qui permet de supprimer un objet de type panelSelection
	 * 
	 * @param selection - PanelSelection
	 */
	public void supprimerSelection(PanelSelection selection) {
		effacerGrille();
		cases.remove(selection);
		afficherGrille();
	}

	/**
	 * Permet de supprimer une case de l'ArrayList
	 */
	private void effacerGrille() {
		for (int i = 0; i < cases.size(); i++) {
			remove(cases.get(i));
		}
	}

	/**
	 * Permet d'afficher les cases ajouté à la grille
	 */
	private void afficherGrille() {
		for (int i = 0; i < cases.size(); i++) {
			add(cases.get(i));
		}
	}
}