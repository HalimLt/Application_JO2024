package jeuxOlympiques.modeles;
import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author sgadewa
 */
public class Session implements Serializable{

	private static final long serialVersionUID = 1L;
	Lieu sonLieu;
	Categorie saCategorie;
	ArrayList<Athlete> sesAthletes;
	ArrayList<Equipe> sesEquipes;


	protected int idSession;
	protected String typeSession;
	protected String descSession;
	protected String dateSession;
	protected String heureDebut;
	protected String heureFin;

	private static int nbSession;

	


	/**
	 * 
	 * Constructeur pour Session
	 * 
	 * @param categorie : Categorie
	 * @param typeSession : Chaine de caractères
	 * @param descSession : Chaine de caractères
	 * @param dateSession : Chaine de caractères
	 * @param heureDebut : Chaine de caractères
	 * @param HeureFin : Chaine de caractères
	 */

	public Session(Categorie categorie, String typeSession, String descSession, String dateSession, String heureDebut, String HeureFin) {
		nbSession++;
		this.idSession = nbSession;
		this.typeSession = typeSession;
		this.descSession = descSession; 
		this.dateSession = dateSession;
		this.heureDebut = heureDebut;
		this.heureFin = HeureFin;
		this.saCategorie=categorie;

	}

	/**
	 * Methode pour modifier une session
	 * 
	 * @param typeSession : Chaine de caractères
	 * @param descSession : Chaine de caractères
	 * @param dateSession : Chaine de caractères
	 * @param heureDebut : Chaine de caractères
	 * @param HeureFin : Chaine de caractères
	 */

	//Stephane 
	public void modifierSession(String typeSession, String descSession, String dateSession, String heureDebut, String HeureFin) {

		setTypeSession(typeSession);
		setDescSession(descSession);
		setDateSession(dateSession);
		setHeureDebut(heureDebut);
		setHeureFin(HeureFin);

	}


	/**
	 * Setter pour setIdSession
	 * 
	 * @param idSession : Entier
	 */

	// Setters
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	/**
	 * Setter pour setTypeSession
	 * 
	 * 
	 * @param typeSession : Chaine de caractères
	 */

	public void setTypeSession(String typeSession) {
		this.typeSession = typeSession;
	}

	/**
	 * 
	 * Getter pour setDescSession
	 * 
	 * @param descSession : Chaine de caractères
	 */

	public void setDescSession(String descSession){
		this.descSession = descSession; 
	}

	/**
	 * 
	 * Setter pour setDateSession
	 * 
	 * 
	 * @param dateSession : Chaine de caractères
	 */

	public void setDateSession(String dateSession){
		this.dateSession = dateSession;
	}

	/**
	 * 
	 * Setter pour setHeureDebut
	 * 
	 * @param heureDebut : Chaine de caractères
	 */

	public void setHeureDebut(String heureDebut){
		this.heureDebut = heureDebut;
	}

	/**
	 * 
	 * Setter pour setHeureFin 
	 * 
	 * @param heureFin : Chaine de caractères
	 */

	public void setHeureFin(String heureFin){
		this.heureFin = heureFin;
	}

	/**
	 * Setter pour setSonLieu
	 * 
	 * @param sonLieu : Chaine de caractères
	 */

	public void setSonLieu(Lieu sonLieu){
		this.sonLieu = sonLieu;
	}

	// Eric
	// Ne pas utiliser dans le package modele
	// Getters 

	/**
	 * Getter pour getIdSession
	 * 
	 * @return idSession : Entier
	 */

	// idSession
	public int getIdSession() {
		return idSession;
	}

	/**
	 * Getter pour typeSession
	 * 
	 * @return typeSession : Chaine de caractères
	 */

	// typeSession
	public String typeSession() {
		return typeSession;
	}


	/**
	 * Getter pour descSession
	 * 
	 * @return descSession : Chaine de caractères
	 */
	// descSession
	public String descSession () {
		return descSession;
	}

	/**
	 * 
	 * Getter pour getDateSession
	 * 
	 * @return dateSession : Chaine de caractères
	 */

	// dateSession

	public String getDateSession() {
		return dateSession;
	}

	/**
	 * 
	 * Getter pour heureDebut
	 * 
	 * @return heureDebut : Chaine de caractères
	 */

	// heureDebut 

	public String heureDebut() {
		return heureDebut;
	}

	/**
	 * 
	 * Getter pour heureFin
	 * 
	 * @return heureFin : Chaine de caractères
	 */

	// heureFin

	public String heureFin() {
		return heureFin;
	}












}