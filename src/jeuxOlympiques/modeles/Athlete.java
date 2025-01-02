package jeuxOlympiques.modeles;

import java.util.*;


/**
 * @author ese
 */
public class Athlete {

	Pays sonPays;
	Equipe sonEquipe;
	ArrayList<Session> sesSessions;
	//ArrayList<ResultatSession> sesResultatsSessions;
	//ResultatCategorie sonResultatCategorie;
	Categorie saCategorie;
	protected int idAthlete;
	protected int numPoste;
	protected String poste;
	protected String nomAthlete;
	protected String prenomAthlete;
	private static int nbAthlete;


	//Constructeur pour un athlète d'un sport individuel
	

		/**
		 * 
		 * Premier constructeur pour un athlète d'un sport individuel
		 * @param numPoste : Entier
		 * @param poste : Chaine de caractères
		 * @param nomAthlete : Chaine de caractères 
		 * @param prenomAthlete : Chaine de caractères
		 * @param pays : Pays
		 * @param categorie : Chaine de caractères
		 */

	public Athlete(int numPoste, String poste, String nomAthlete, String prenomAthlete, Pays pays, Categorie categorie) {
		sesSessions=new ArrayList<Session>();
		nbAthlete++;
		this.idAthlete=nbAthlete;
		this.numPoste=numPoste;
		this.poste=poste;
		this.nomAthlete=nomAthlete;
		this.prenomAthlete=prenomAthlete;
		sonPays=pays;
		sonPays.sesAthletes.add(this);
		saCategorie=categorie;
		saCategorie.sesAthletes.add(this);

	}

	/**
	 * 
	 * Deuxième constructeur pour un sport en équipe
	 * 
	 * @param numPoste : Entier
	 * @param poste : Chaine de caractères
	 * @param nomAthlete : Chaine de caractères
	 * @param prenomAthlete : Chaine de caractères
	 * @param equipe : Equipe
	 */

	//Constructeur pour un athlète d'un sport collectif
	public Athlete(int numPoste, String poste, String nomAthlete, String prenomAthlete, Equipe equipe) {
		sesSessions=new ArrayList<Session>();
		nbAthlete++;
		this.idAthlete=nbAthlete;
		this.numPoste=numPoste;
		this.poste=poste;
		this.nomAthlete=nomAthlete;
		this.prenomAthlete=prenomAthlete;
		sonEquipe=equipe;
		sonEquipe.sesAthletes.add(this);
		saCategorie=equipe.saCategorie;
		saCategorie.sesAthletes.add(this);
		sonPays=equipe.sonPays;
		sonPays.sesAthletes.add(this);

	}

	/**
	 * Méthode pour modifier les informations sur un athlète individuel ou en équipe
	 * @param numPoste : Entier
	 * @param poste : Chaine de caractères 
	 * @param nomAthlete : Chaine de caractères
	 * @param prenomAthlete : Chaine de caractères
	 */
	public void modifierAthlete(int numPoste, String poste, String nomAthlete, String prenomAthlete) {

		this.numPoste=numPoste;
		this.poste=poste;
		this.nomAthlete=nomAthlete;
		this.prenomAthlete=prenomAthlete;
	}


	/**
	 * Getter pour IdAthlete
	 * 
	 * @return IdAthlete : Entier
	 */
	public int getIdAthlete() {
	return idAthlete;

	}

	/**
	 * Setter pour IdAthlete
	 * 
	 * @param idAthlete : Entier
	 */

	public void setIdAthlete(int idAthlete) {

		this.idAthlete=idAthlete;
	}

	/**
	 * Getter pour getNumPoste
	 * 
	 * @return numPoste : Entier
	 */
	public int getNumPoste() {

		return numPoste;
	}

	/** 
	 * Setter pour setNumPoste
	 * 
	 * @param numPoste : Entier
	 */

	public void setNumPoste(int numPoste) {
		this.numPoste=numPoste;
	}

	/**
	 * Getter pour getPoste
	 * 
	 * @return Poste : Chaine de caractères
	 */
	public String getPoste() {
		return poste;
	} 


	/**
	 * Setter pour setPoste
	 * 
	 * @param poste : Chaine de caractères
	 */

	public void setPoste(String poste) {
		this.poste=poste;

	}

	/**
	 * 
	 * Getter pour getNomAthlete
	 * 
	 * @return nomAthlete : Chaine de caractères
	 */


	public String getNomAthlete() {
		return nomAthlete;
	}

	/**
	 * Setter pour setNomAthlete
	 * 
	 * @param nomAthlete : Chaine de caractères
	 */

	public void setNomAthlete(String nomAthlete) {
		this.nomAthlete=nomAthlete;
	}

	/**
	 * 
	 * Getter pour getPrenomAthlete
	 * 
	 * @return prenomAthlete : Chaine de caractères
	 */


	// prenomAthlete
	public String getPrenomAthlete() {
		return prenomAthlete;
	}

	/**
	 * 
	 * Setter pour setPrenomAthlete
	 * 
	 * @param prenomAthlete : Chaine de caractères
	 */

	public void setPrenomAthlete(String prenomAthlete) {
		this.prenomAthlete=prenomAthlete;
	}

}