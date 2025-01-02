package jeuxOlympiques.modeles;
import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author ese
 */
public class Equipe implements Serializable{

	private static final long serialVersionUID = 1L;
	Pays sonPays;
	ArrayList<Athlete> sesAthletes;
	ArrayList<Session> sesSessions;
	protected Epreuve sonEpreuve;
	//ArrayList<ResultatSession> sesResultatsSessions;
	//ResultatCategorie sonResultatCategorie;
	protected Categorie saCategorie; // modifié cf.no2
	protected int idEquipe;
	private static int nbEquipe=0;


	

	/**
	 * Constructeur pour Equipe
	 * 
	 * @param categorie : Categorie
	 * @param pays : Pays
	 */
	//Lucas
	public Equipe( Categorie categorie, Pays pays, Epreuve epreuve) {
		sesAthletes=new ArrayList<Athlete>();
		sesSessions=new ArrayList<Session>();
		nbEquipe++;
		this.idEquipe = nbEquipe;
		saCategorie=categorie;
		saCategorie.sesEquipes.add(this);
		sonPays=pays;

		sonEpreuve=epreuve;

	}

	/**
	 * Getter pour getSonEpreuve
	 * 
	 * @return sonEpreuve : Epreuve
	 */

	public Epreuve getSonEpreuve() {
		return sonEpreuve;
	}

	/**
	 * Setter pour setSonEpreuve
	 * 
	 * @param sonEpreuve : Epreuve
	 */

	public void setSonEpreuve(Epreuve sonEpreuve) {
		this.sonEpreuve = sonEpreuve;
	}

	/**
	 * 
	 * Méthode pour supprimer un Athlete dans Equipe 
	 * 
	 * @param athlete : Athlete
	 */

	//Lucas
	public void supprimerAthleteEquipe(Athlete athlete) {
		athlete.sonEquipe=null;
		sesAthletes.remove(athlete);
	}
	// Eric
	// Ne pas utiliser dans le package modele
	// Getters et Setters


	/**
	 * Getter pour getIdEquipe
	 * 
	 * @return idEquipe : Entier
	 */
	// idEquipe
	public int getIdEquipe() {
		return idEquipe;
	}

	/**
	 * Setter pour setIdEquipe
	 * 
	 * @param idEquipe : Entier
	 */

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}


	/**
	 * Getter pour getSaCategorie
	 * 
	 * @return saCategorie : Categorie
	 */

	public Categorie getSaCategorie(){
		return saCategorie;
	}
}