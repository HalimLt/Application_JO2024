package jeuxOlympiques.vues;

import java.awt.Font;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;
import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Halim 
/**
 * @author hluquet
 */
public class PanelAfficherPays extends JPanel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ATTRIBUTS
	PanelBandeau bandeau;
	PanelGrille grillePays;
	JButton ajouterPays;
	JFrame fenetre;
	JLabel labelTitre;

	// CONSTRUCTEUR
	PanelAfficherPays() throws IOException {
		bandeau = new PanelBandeau();
		grillePays = PanelBandeau.getGrillePays(); // Récupère la grille enregistrer dans le bandeau de façon static
		ajouterPays = new JButton("Ajouter un pays");
		labelTitre = new JLabel("Gestion des pays");

		// Ajoute tout au Panel
		add(bandeau);
		add(labelTitre);
		add(grillePays);
		add(ajouterPays);

		// Ajoute tout à la fenêtre
		fenetre = new JFrame("Pays");
		fenetre.setSize(800, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		// Ajoute l'ecouteur permettant d'afficher ajouterPays au bouton ajouter
		EcouteurAfficherAjouterPays EcouteurajouterPays = new EcouteurAfficherAjouterPays(this);
		ajouterPays.addActionListener(EcouteurajouterPays);
		serealisationGrillePays();

	}

	public JFrame getFenetre() {
		return fenetre;
	}

	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}

	// CONSTRUCTEUR permettant de conserver la grille (lorsque l'on ajoute ou
	// modifie)
	public PanelAfficherPays(PanelGrille grille) throws IOException {
		bandeau = new PanelBandeau();
		grillePays = grille;
		ajouterPays = new JButton("Ajouter un pays");
		labelTitre = new JLabel("Gestion des pays");
		labelTitre.setFont(new Font("Serif", Font.BOLD, 50));
		
		add(bandeau);
		add(labelTitre);
		add(grillePays);
		add(ajouterPays);
		

		PanelBandeau.setGrillePays(grillePays); // Permet d'enregistrer la nouvelle grille des épreuves de façon static

		fenetre = new JFrame("Pays");
		fenetre.setSize(880, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		EcouteurAfficherAjouterPays ajouterPaysListen = new EcouteurAfficherAjouterPays(this);
		ajouterPays.addActionListener(ajouterPaysListen);
		serealisationGrillePays();
	}

	/**
	 * Méthode permettant de séréaliser la grille des pays
	 * @throws IOException
	 */
	private void serealisationGrillePays() throws IOException {
		File grillePays = new File ("grillePays.dat");
		if (!grillePays.exists()) {
			FileOutputStream fichier = new FileOutputStream("grillePays.dat");
			ObjectOutputStream flotObjet = new ObjectOutputStream(fichier);
			flotObjet.writeObject(PanelBandeau.getGrillePays());
			flotObjet.close();
		}
		else {
			grillePays.delete();
			FileOutputStream fichier = new FileOutputStream("grillePays.dat");
			ObjectOutputStream flotObjet = new ObjectOutputStream(fichier);
			flotObjet.writeObject(PanelBandeau.getGrillePays());
			flotObjet.close();
		}
	}
	
	public PanelBandeau getBandeau() {
		return bandeau;
	}

	public void setBandeau(PanelBandeau bandeau) {
		this.bandeau = bandeau;
	}

	public JButton getAjouterPays() {
		return ajouterPays;
	}

	public void setAjouterPays(JButton ajouterPays) {
		this.ajouterPays = ajouterPays;
	}

	public PanelGrille getGrillePays() {
		return grillePays;
	}

	public void setGrillePays(PanelGrille grillePays) {
		this.grillePays = grillePays;
	}

	public void afficherFenetre() {
		fenetre.setLocationRelativeTo(null);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}

	public static void main(String[] args) {
		
	}
}
