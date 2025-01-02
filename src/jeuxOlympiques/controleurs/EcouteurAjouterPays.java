package jeuxOlympiques.controleurs;

import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//Halim
/**
 * 
 * @author hluquet
 */
public class EcouteurAjouterPays implements ActionListener {
	//ATTRIBUTS
	JButton valider;
	PanelGrille grille;
	JFrame nouvelleFenetreAffichePays;
	JFrame ancienneFenetre;
	JTextField nomPays;
	JTextField descriptionPays;

	
	
	/**
	 * Constructeur pour EcouteurAjouterPays
	 * 
	 * @param accept : JButton
	 * @param grid : PanelGrille
	 * @param fen : JFrame
	 * @param nom : JTextField
	 */
	//CONSTRUCTEUR
	public EcouteurAjouterPays(JButton accept, PanelGrille grid, JFrame fen, JTextField nom) {
		valider = accept;
		grille = grid;

		//Créer une nouvelle fenêtre pour afficher la nouvelle fenêtre épreuve
		nouvelleFenetreAffichePays = new JFrame("Pays");
		nouvelleFenetreAffichePays.setSize(800, 500);
		nouvelleFenetreAffichePays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ancienneFenetre = fen; //Fenetre d'ajouter Pays

		nomPays = nom;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == valider) {

			//Ferme la fenêtre ajouterPays
			ancienneFenetre.setVisible(false);

			//Créer le panelSelectionPays et l'ajoute à la grille
			PanelSelectionPays selectionTemp;
			Pays pays = new Pays(nomPays.getText());
			selectionTemp = new PanelSelectionPays(pays);
			grille.ajouterSelection(selectionTemp);

			//Création d'un nouveau panel avec la nouvelle grille
			PanelAfficherPays afficherPays;
			try {
				afficherPays = new PanelAfficherPays(grille);
				selectionTemp.ajouterEcouteurs(afficherPays);

				nouvelleFenetreAffichePays.add(afficherPays);

				nouvelleFenetreAffichePays.setLocationRelativeTo(null);

				nouvelleFenetreAffichePays.setVisible(true);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		}
	}
}
