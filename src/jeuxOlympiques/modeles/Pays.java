package jeuxOlympiques.modeles;
import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author sgadewa
 */
public class Pays implements Serializable{

	private static final long serialVersionUID = 1L;
	ArrayList<Athlete> sesAthletes;
	ArrayList<Equipe> sesEquipe;
	protected int idPays;
	protected String nomPays;
	private static int nbPays;
	


	/**
	 * Constructeur pour Pays
	 * 
	 * @param nomPays : Chaine de caractères
	 */
	public Pays(String nomPays) {
		sesAthletes=new ArrayList<Athlete>();
		sesEquipe=new ArrayList<Equipe>();
		nbPays++;
		this.idPays = nbPays;
		this.nomPays = nomPays;
	}

	/**
	 * Methode pour modifier le nom du pays
	 * 
	 * @param nomPays : Chaine de caractères
	 */

	public void modifierPays(String nomPays) {

		this.nomPays = nomPays;
	}

	/**
	 * 
	 * Methode pour supprimer Equipe dans Pays
	 * 
	 * @param equipe : Equipe
	 */
	public void supprimerEquipe(Equipe equipe) {
		sesEquipe.remove(equipe);
		equipe.sonPays = null;
	}

	/**
	 * 
	 * Methode pour supprimer Athlete dans Pays
	 * 
	 * @param athlete : Athlete
	 */


	public void supprimerAthletePays(Athlete athlete) {
		sesAthletes.remove(athlete);
		athlete.sonPays = null;
	}


	// Eric
	// Ne pas utiliser dans le package modele
	// Getters et Setters

	/**
	 * Getter pour getIdPays
	 * 
	 * @return idPays : Entier
	 */

	public int getIdPays() {
		return idPays;
	}
	/**
	 * 
	 * Setter pour setIdPays
	 * 
	 * @param idPays : Entier
	 */

	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	/**
	 * 
	 * Getter pour getNomPays
	 * 
	 * @return nomPays : Chaine de caractères 
	 */

	public String getNomPays() {
		return nomPays;
	}

	/**
	 * 
	 * Setter pour setNomPays
	 * 
	 * @param nomPays : Chaine de caractères 
	 */

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

}