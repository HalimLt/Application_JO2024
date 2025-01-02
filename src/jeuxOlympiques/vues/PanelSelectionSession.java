package jeuxOlympiques.vues;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Lucas 
/**
 * @author lpivet
 */
public class PanelSelectionSession extends PanelSelection implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PanelSelectionCategorie categorie;
	static ArrayList<Session> lesSessions = new ArrayList<Session>();
	Session saSession;

	/**
	 * Getter de categorie
	 * 
	 * @return categorie - PanelSelectionCategorie
	 */
	public PanelSelectionCategorie getCategorie() {
		return categorie;
	}

	/**
	 * Setter de categorie
	 * 
	 * @param categorie - PanelSelectionCategorie
	 */
	public void setCategorie(PanelSelectionCategorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * Permet de créer un objet session en appelant le constructeur panelSelection
	 * 
	 * @param session - Session
	 * @throws IOException 
	 */
	public PanelSelectionSession(Session session) throws IOException {
		super();
		buttonTitre = new JButton(
				"       " + session.getDateSession() + "(" + session.heureDebut() + "-" + session.heureFin() + ")       ");
		lesSessions.add(session);
		saSession = session;
		buttonTitre.setForeground(Color.white); // Met le texte du label en blanc
		buttonTitre.setBackground(Color.blue);
		panelTitre.add(buttonTitre);

		panelTitre.setBackground(Color.blue);
		serealisationLesSessions();
	}
	/**
	 * Méthode permettant de séréaliser la grille des pays
	 * @throws IOException
	 */
	private void serealisationLesSessions() throws IOException {
		File sessions = new File ("sessions.dat");
		if (!sessions.exists()) {
			FileOutputStream fichier = new FileOutputStream("sessions.dat");
			ObjectOutputStream flotObjet = new ObjectOutputStream(fichier);
			flotObjet.writeObject(lesSessions);
			flotObjet.close();
		}
		else {
			sessions.delete();
			FileOutputStream fichier = new FileOutputStream("sessions.dat");
			ObjectOutputStream flotObjet = new ObjectOutputStream(fichier);
			flotObjet.writeObject(lesSessions);
			flotObjet.close();
		}
	}

	/**
	 * Getter de saSession
	 * 
	 * @return saSession - Session
	 */
	public Session getSaSession() {
		return saSession;
	}

	/**
	 * Setter de saSession
	 * 
	 * @param saSession - Session
	 */
	public void setSaSession(Session saSession) {
		this.saSession = saSession;
	}

	// Permet d'initialiser les écouteurs modifier et supprimer (en conservant le
	// PanelAfficherSession pour garder la grille des catégories
	// ainsi que la case de l'épreuve)

	/**
	 * Permet d'initialiser les écouteurs modifier et supprimer (en conservant le
	 * PanelAfficherSession pour garder la grille des catégories
	 * ainsi que la case de l'épreuve)
	 * @param temp - PanelAfficherSession
	 */
	public void ajouterEcouteurs(PanelAfficherSession temp) {

		buttonSupprimer.addActionListener(new EcouteurSupprimerElementGrilleSession(this, temp));
		buttonModifier.addActionListener(new EcouteurModifierElementGrilleSession(this, temp));
	}

	/**
	 * Getter de lesSessions
	 * 
	 * @return lesSessions - ArrayList Session
	 */
	public static ArrayList<Session> getLesSessions() {
		return lesSessions;
	}

	/**
	 * Setter de lesSessions
	 * 
	 * @param lesSessions - ArrayList Session
	 */
	public static void setLesSessions(ArrayList<Session> lesSessions) {
		PanelSelectionSession.lesSessions = lesSessions;
	}
}
