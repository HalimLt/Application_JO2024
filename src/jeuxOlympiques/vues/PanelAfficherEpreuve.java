package jeuxOlympiques.vues;

import javax.swing.*;

import java.io.*;

import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Lucas 

/**
 * 
 * @author lpivet
 */
public class PanelAfficherEpreuve extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelBandeau bandeau;
	PanelGrille grilleEpreuve;
	JButton ajouterEpreuve;
	JFrame fenetre;

	/**
	 * Getter de la fenêtre enregistrer dans le panel
	 * 
	 * @return fenetre - fenêtre enregistrer dans le panel
	 */
	public JFrame getFenetre() {
		return fenetre;
	}

	/**
	 * Setter de la fenêtre enregistrer dans le panel
	 * 
	 * @param fenetre
	 */
	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}

	/**
	 * Créer un nouveau PanelAfficherEpreuve à l'aide d'une grille
	 * 
	 * @param grille - PanelGrille remplis avec des sélections Epreuves
	 * @throws IOException 
	 */
	// CONSTRUCTEUR permettant de conserver la grille (lorsque l'on ajoute ou
	// modifie)
	public PanelAfficherEpreuve(PanelGrille grille) throws IOException {
		bandeau = new PanelBandeau();
		grilleEpreuve = grille;
		ajouterEpreuve = new JButton("Ajouter une épreuve");

		add(bandeau);
		add(grilleEpreuve);
		add(ajouterEpreuve);

		PanelBandeau.setGrilleEpreuve(grilleEpreuve); // Permet d'enregistrer la nouvelle grille des épreuves de façon static
		

		fenetre = new JFrame("Epreuves");
		fenetre.setSize(880, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		EcouteurAfficherAjouterEpreuve ajouterEpreuveListen = new EcouteurAfficherAjouterEpreuve(this);
		ajouterEpreuve.addActionListener(ajouterEpreuveListen);
		serealisationGrilleEpreuve();
	}

	/**
	 * Méthode permettant de séréaliser la grille des épreuves
	 * @throws IOException
	 */
	private void serealisationGrilleEpreuve() throws IOException {
		File grilleEpreuve = new File ("grilleEpreuve.dat");
		if (!grilleEpreuve.exists()) {
			FileOutputStream fichier = new FileOutputStream("grilleEpreuve.dat");
			ObjectOutputStream flotObjet = new ObjectOutputStream(fichier);
			flotObjet.writeObject(PanelBandeau.getGrilleEpreuve());
			flotObjet.close();
		}
		else {
			grilleEpreuve.delete();
			FileOutputStream fichier = new FileOutputStream("grilleEpreuve.dat");
			ObjectOutputStream flotObjet = new ObjectOutputStream(fichier);
			flotObjet.writeObject(PanelBandeau.getGrilleEpreuve());
			flotObjet.close();
		}
	}

	/**
	 * Getter du bandeau enregistrer dans le panel
	 * 
	 * @return bandeau - bandeau enregistrer dans le panel
	 */
	public PanelBandeau getBandeau() {
		return bandeau;
	}

	/**
	 * Setter du bandeau enregistrer dans le panel
	 * 
	 * @param bandeau - PanelBandeau
	 */
	public void setBandeau(PanelBandeau bandeau) {
		this.bandeau = bandeau;
	}

	/**
	 * Getter du JButton ajouterEpreuve enregistrer dans le panel
	 * 
	 * @return ajouterEpreuve - JButton ajouter
	 */
	public JButton getAjouterEpreuve() {
		return ajouterEpreuve;
	}

	/**
	 * Setter du JButton ajouterEpreuve enregistrer dans le panel
	 * 
	 * @param ajouterEpreuve - JButton
	 */
	public void setAjouterEpreuve(JButton ajouterEpreuve) {
		this.ajouterEpreuve = ajouterEpreuve;
	}

	/**
	 * Getter de la grille enregistrer dans le panel
	 * 
	 * @return grilleEpreuve - PanelGrille grilleEpreuve
	 */
	public PanelGrille getGrilleEpreuve() {
		return grilleEpreuve;
	}

	/**
	 * Setter de grilleEpreuve enregistrer dans le panel
	 * 
	 * @param grilleEpreuve - PanelGrille
	 */
	public void setGrilleEpreuve(PanelGrille grilleEpreuve) {
		this.grilleEpreuve = grilleEpreuve;
	}

	/**
	 * Permet d'afficher la fenêtre une fois l'objet construit
	 */
	public void afficherFenetre() {
		fenetre.setLocationRelativeTo(null);
		// Afficher la fenetre
		fenetre.setVisible(true);

	}

	public static void main(String[] args) {
		/*PanelAfficherEpreuve test = new PanelAfficherEpreuve(PanelBandeau.getGrilleEpreuve());
		test.afficherFenetre();*/

	}
}
