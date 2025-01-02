package jeuxOlympiques.modeles;
import java.io.Serializable;
import java.util.*;

/**
 * @author ese
 * 
 */
public class Categorie implements Serializable {



	private static final long serialVersionUID = 1L;
	ArrayList<Equipe> sesEquipes;
	ArrayList<Athlete> sesAthletes;
	Epreuve sonEpreuve;
	ArrayList<Session> sesSessions;
	// ResultatCategorie sonResultat;
	protected int idCategorie;
	protected String nomCategorie;
	private static int nbCategorie;

	// private String typeCategorie; Je ne pense pas que cette variable soit utile,
	

	

	/**
	 * Constructeur pour la catégorie 
	 * 
	 * @param sonEpreuve : Epreuve
	 * @param nomCategorie : Chaine de caractères
	 */

	public Categorie( Epreuve sonEpreuve, String nomCategorie) {
		sesEquipes = new ArrayList<Equipe>();
		sesAthletes = new ArrayList<Athlete>();
		nbCategorie++;
		this.idCategorie = nbCategorie;
		this.nomCategorie = nomCategorie;
		this.sonEpreuve = sonEpreuve;
		this.sonEpreuve.sesCategories.add(this);
	}


	/**
	 * Méthode pour supprimer la Session
	 * 
	 * @param session : Session
	 */
	public void supprimerSession(Session session) {
		sesSessions.remove(session);
		session.saCategorie = null;
	}

	// Halim

	/**
	 * 
	 * Méthode pour modifier la nom de catégorie
	 * 
	 * @param nomCategorie : Chaine de caractères
	 */
	public void modifierCategorie(String nomCategorie) {

		this.nomCategorie = nomCategorie;
	}

	//Lucas

	/**
	 * 
	 * Methode pour supprimer l'équipe
	 * 
	 * @param equipe : Equipe
	 */
	public void supprimerEquipe(Equipe equipe) {
		sesEquipes.remove(equipe);
		equipe.saCategorie = null;
	}


	/**
	 * 
	 * Méthode pour supprimer l'athète
	 * 
	 * @param athlete : Athlete
	 */
	public void supprimerAthlete(Athlete athlete) {
		sesAthletes.remove(athlete);
		athlete.saCategorie = null;
	}

	/**
	 * Partie Getters et Setters :
	 * 
	 */

	/**
	 * 
	 * Getter pour getIdCategorie
	 * 
	 * @return idCategorie : Entier
	 */


	public int getIdCategorie() {
		return idCategorie;
	}

	/**
	 * 
	 * Setter pour setIdCategorie
	 * 
	 * @param idCategorie : Entier
	 */

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * 
	 * Getter pour getNomCategorie
	 * 
	 * @return nomCategorie : Entier
	 */

	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * 
	 * Setter pour setNomCategorie
	 * 
	 * @param nomCategorie : Chaine de caractères
	 */

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	/**
	 * 
	 * Getter pour getSonEpreuve
	 * 
	 * @return sonEpreuve : Epreuve
	 */

	public Epreuve getSonEpreuve(){
		return sonEpreuve;
	}

	public String toString() {
		return nomCategorie;
	}

}