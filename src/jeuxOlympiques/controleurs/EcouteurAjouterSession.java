package jeuxOlympiques.controleurs;

import jeuxOlympiques.vues.*;

import jeuxOlympiques.modeles.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//Lucas REPLIT2
/**
 * 
 * @author lpivet
 * 
 */
public class EcouteurAjouterSession implements ActionListener {

	//ATTRIBUTS
	JButton valider;
	PanelGrille grille;
	JFrame nouvelleFenetreAffiche;
	JFrame ancienneFenetre;
	JTextField type;
	JTextField desc;
	JTextField date;
	JTextField heureDeb;
	JTextField heureFin;
	Categorie categorie;
	PanelAfficherSession panel;

	

	/**
	 * Constructeur pour EcouteurAjouterSession
	 * 
	 * @param panel : PanelAfficherSession
	 * @param categorie : Categorie
	 * @param accept : JButton
	 * @param grid : PanelGrille
	 * @param fen : JFrame
	 * @param type : JTextField
	 * @param desc : JTextField
	 * @param date : JTextField
	 * @param heureDeb : JTextField
	 * @param heureFin : JTextField
	 */

	//CONSTRUCTEUR conservant le panel et la grille
	public EcouteurAjouterSession(PanelAfficherSession panel,Categorie categorie,JButton accept, PanelGrille grid, JFrame fen, JTextField type
			,JTextField desc, JTextField date, JTextField heureDeb, JTextField heureFin) {
		this.panel=panel;
		this.categorie=categorie;
		valider = accept;
		grille = grid;

		//Créer une nouvelle fenêtre
		nouvelleFenetreAffiche = new JFrame("Session");
		nouvelleFenetreAffiche.setSize(800, 500);
		nouvelleFenetreAffiche.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ancienneFenetre = fen;

		this.type = type;
		this.desc=desc;
		this.date=date;
		this.heureDeb=heureDeb;
		this.heureFin=heureFin;

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == valider) {

			//Ferme la fenêtre de ajouter Session
			ancienneFenetre.dispose();

			//Créer le panel selection Session
			PanelSelectionSession selectionTemp;

			try {
				selectionTemp = new PanelSelectionSession(new Session(categorie,type.getText(),desc.getText(),date.getText()
						,heureDeb.getText(),heureFin.getText()));
				selectionTemp.setCategorie(panel.getCaseCategorie());

				//Ajoute le panel à la grille et affiche le nouveau panel afficher session (en ayant conserver la case de l'épreuve 
				//grâce à panel.getCaseCategorie()
				grille.ajouterSelection(selectionTemp);
				PanelAfficherSession afficherSession = new PanelAfficherSession(panel.getEpreuve(),panel.getCaseCategorie(),grille);

				//Permet d'initialiser les écouteurs en gardant le panel afficher catégorie pour pouvoir ensuite récupérer le panel selection et la grid
				selectionTemp.ajouterEcouteurs(afficherSession); 

				nouvelleFenetreAffiche.add(afficherSession);

				nouvelleFenetreAffiche.setLocationRelativeTo(null);


				nouvelleFenetreAffiche.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			

		}
	}
}
