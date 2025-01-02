package jeuxOlympiques.controleurs;

import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Halim
/**
 * 
 * @author lpivet
 * 
 */
public class EcouteurAjouterEquipe implements ActionListener {

	//ATTRIBUTS
	JButton valider;
	PanelGrille grille;
	JFrame nouvelleFenetreAffiche;
	JFrame ancienneFenetre;
	JComboBox<Epreuve> comboBoxEpreuve;
	JComboBox<Categorie> comboBoxCategorie;
	Epreuve selectedEpreuve;
	Categorie selectedCategorie;
	Pays pays;
	PanelAfficherEquipe panel;

	

	/**
	 * 
	 * Constructeur pour EcouteurAjouterEquipe
	 * 
	 * @param panel : PanelAfficherEquipe
	 * @param pays : Pays
	 * @param accept : JButton
	 * @param grid : PanelGrille
	 * @param fen : JFrame
	 * @param comboBoxEpreuve : JComboBox Epreuve
	 * @param comboBoxCategorie : JComboBox Categorie
	 */

	//CONSTRUCTEUR conservant le panel et la grille
	public EcouteurAjouterEquipe(PanelAfficherEquipe panel,Pays pays,JButton accept, PanelGrille grid, JFrame fen, JComboBox<Epreuve> comboBoxEpreuve, JComboBox<Categorie> comboBoxCategorie) {
		this.panel=panel;
		this.pays=pays;
		valider = accept;
		grille = grid;
		ancienneFenetre= fen;

		this.comboBoxEpreuve=comboBoxEpreuve;
		this.comboBoxCategorie=comboBoxCategorie;
		//Créer une nouvelle fenêtre
		nouvelleFenetreAffiche = new JFrame("Equipe");
		nouvelleFenetreAffiche.setSize(800, 500);
		nouvelleFenetreAffiche.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == valider) {
			selectedEpreuve = (Epreuve) comboBoxEpreuve.getSelectedItem();
			selectedCategorie = (Categorie) comboBoxCategorie.getSelectedItem();
			if (selectedEpreuve!=null && selectedCategorie!=null) {
				//Ferme la fenêtre de ajouter Equipe
				ancienneFenetre.dispose();

				//Créer le panel selection Equipe
				PanelSelectionEquipe selectionTemp;

				selectionTemp = new PanelSelectionEquipe(new Equipe(selectedCategorie, pays, selectedEpreuve));	
				selectionTemp.setPays(panel.getCasePays());

				//Ajoute le panel à la grille et affiche le nouveau panel afficher categorie (en ayant conserver la case de l'épreuve 
				//grâce à panel.getCasePays()
				grille.ajouterSelection(selectionTemp);
				PanelAfficherEquipe afficherEquipe = new PanelAfficherEquipe(panel.getCasePays(),grille);

				//Permet d'initialiser les écouteurs en gardant le panel afficher catégorie pour pouvoir ensuite récupérer le panel selection et la grid
				selectionTemp.ajouterEcouteurs(afficherEquipe); 

				nouvelleFenetreAffiche.add(afficherEquipe);

				nouvelleFenetreAffiche.setLocationRelativeTo(null);

				nouvelleFenetreAffiche.setVisible(true);
			}

		}
	}
}
