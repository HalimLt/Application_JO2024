package jeuxOlympiques.vues;

import javax.swing.*;
import jeuxOlympiques.modeles.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author sgadewa
 */
// Stephane
public class PanelAccueil extends JPanel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PanelBandeau bandeau;

	JFrame accueil;
	Container Ico;
	JLabel labelI;
	BufferedImage image;

	/**
	 * Créer le panel afficher accueil
	 */
	public PanelAccueil() {

		bandeau = new PanelBandeau();
		add(bandeau);

		accueil = new JFrame("Accueil");
		accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			image = ImageIO.read(new File("Images/JO_2024.png"));// Chemin relatif
			ImageIcon icon = new ImageIcon(image);
			labelI = new JLabel(icon);
			add(labelI);
			accueil.add(this);

		} catch (Exception e) {
			System.out.println("Image non trouvée");
		}
		accueil.setSize(880, 500);

	}
	/**
	 * PanelAccueil demandant la grille des épreuves, la grille des pays et les sessions pour la séréalisation
	 * @param grilleDesEpreuves - PanelGrille
	 * @param grilleDesPays - PanelGrille
	 * @param lesSessions - ArrayList Session
	 */
	public PanelAccueil(PanelGrille grilleDesEpreuves, PanelGrille grilleDesPays, ArrayList<Session> lesSessions ) {

		PanelBandeau.setGrilleEpreuve(grilleDesEpreuves);
		PanelBandeau.setGrillePays(grilleDesPays);
		PanelSelectionSession.setLesSessions(lesSessions);
		
		bandeau = new PanelBandeau();
		add(bandeau);

		accueil = new JFrame("Accueil");
		accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			image = ImageIO.read(new File("Images/JO_2024.png"));// Chemin relatif
			ImageIcon icon = new ImageIcon(image);
			labelI = new JLabel(icon);
			add(labelI);
			accueil.add(this);

		} catch (Exception e) {
			System.out.println("Image non trouvée");
		}
		accueil.setSize(880, 500);

	}

	/**
	 * Afficher la fenetre
	 */
	public void afficherFenetre() {
		accueil.setLocationRelativeTo(null);
		accueil.setVisible(true);
	}

	public static void main(String[] args) {
		// PanelAccueil accueil = new PanelAccueil();
		// accueil.afficherFenetre();
	}
}
