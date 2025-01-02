package application;
import jeuxOlympiques.vues.PanelAccueil;
import jeuxOlympiques.vues.PanelBandeau;
import jeuxOlympiques.vues.PanelGrille;
import jeuxOlympiques.vues.PanelSelectionEpreuve;
import jeuxOlympiques.vues.PanelSelectionPays;
import jeuxOlympiques.vues.PanelSelectionSession;
import jeuxOlympiques.modeles.Session;

import java.io.*;
import java.util.ArrayList;

public class jeuxOlympiques implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	

	public static void main(String[] args)  throws IOException, ClassNotFoundException {

		PanelGrille gridEpreuve;
		PanelGrille gridPays;
		ArrayList<Session> lesSessions;
		
		File grilleEpreuve = new File ("grilleEpreuve.dat");
		if (grilleEpreuve.exists()) {
			FileInputStream fichier = new FileInputStream("grilleEpreuve.dat");
			ObjectInputStream flotObjet = new ObjectInputStream(fichier);
			gridEpreuve = (PanelGrille) (flotObjet.readObject());
			
			for (int i=0; i<gridEpreuve.getCases().size();i++) {
				PanelSelectionEpreuve epreuves = (PanelSelectionEpreuve)gridEpreuve.getCases().get(i);
				epreuves.ajouterEcouteurs(null);
				gridEpreuve.getCases().set(i,epreuves);
			}
			
			flotObjet.close();
		}
		else {
			gridEpreuve=PanelBandeau.getGrilleEpreuve();
		}
		
		File grillePays = new File ("grillePays.dat");
		if (grillePays.exists()) {
			FileInputStream fichier = new FileInputStream("grillePays.dat");
			ObjectInputStream flotObjet = new ObjectInputStream(fichier);
			gridPays = (PanelGrille) (flotObjet.readObject());
			
			for (int i=0; i<gridPays.getCases().size();i++) {
				PanelSelectionPays pays = (PanelSelectionPays)gridPays.getCases().get(i);
				pays.ajouterEcouteurs(null);
				gridPays.getCases().set(i,pays);
			}
			
			flotObjet.close();
		}
		else {
			gridPays=PanelBandeau.getGrillePays();
		}
		
		File sessions = new File ("sessions.dat");
		if (sessions.exists()) {
			FileInputStream fichier = new FileInputStream("sessions.dat");
			ObjectInputStream flotObjet = new ObjectInputStream(fichier);
			lesSessions = (ArrayList<Session>) (flotObjet.readObject());
			flotObjet.close();
		}
		else {
			lesSessions=PanelSelectionSession.getLesSessions();
		}
		
		PanelAccueil accueil=new PanelAccueil(gridEpreuve, gridPays, lesSessions);
		accueil.afficherFenetre();

		
		
	}


}
