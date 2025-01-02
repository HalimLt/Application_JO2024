package jeuxOlympiques.modeles;

import java.io.Serializable;
import java.util.*;


/**
 * @author ese
 * 
 */
public class Epreuve implements Serializable{

	private static final long serialVersionUID = 1L;
	ArrayList<Categorie> sesCategories;
	protected int idEpreuve;
	protected String nomEpreuve;
	protected String descriptionEpreuve;
	private static int nbEpreuve = 0;
	public static JeuxOlympique JOParis=new JeuxOlympique();

	

	


	/**
	 * Premier Constructeur pour le nom de l'epreuve uniquement
	 * 
	 * @param nomEpreuve : Chaine de caractères
	 */
	public Epreuve(String nomEpreuve) {

		sesCategories = new ArrayList<Categorie>();
		nbEpreuve++;
		this.idEpreuve = nbEpreuve;
		this.nomEpreuve = nomEpreuve;
		this.descriptionEpreuve = "null";
		JOParis.sesEpreuves.add(this);
	}

	/**
	 * 
	 * Deuxieme Constructeur avec un nom et une description de l'epreuve
	 * 
	 * @param nomEpreuve : Chaine de caractères
	 * @param descriptionEpreuve : Chaine de caractères
	 */

	public Epreuve(String nomEpreuve, String descriptionEpreuve) {
		sesCategories = new ArrayList<Categorie>();
		nbEpreuve++;
		this.idEpreuve = nbEpreuve;
		this.nomEpreuve = nomEpreuve;
		this.descriptionEpreuve = descriptionEpreuve;
		JOParis.sesEpreuves.add(this);
	}

	// Halim

	public static JeuxOlympique getJOParis() {
		return JOParis;
	}

	public static void setJOParis(JeuxOlympique jOParis) {
		JOParis = jOParis;
	}

	/**
	 * Méthode pour modifier l'épreuve 
	 * 
	 * @param nomEpreuve : Chaine de caractères
	 * @param descriptionEpreuve : Chaine de caractères
	 */
	public void modifierEpreuve(String nomEpreuve, String descriptionEpreuve) {
		this.nomEpreuve = nomEpreuve;
		this.descriptionEpreuve = descriptionEpreuve;
	}


	// Halim

	/**
	 * 
	 * Méthode pour supprimer la Catégorie
	 * 
	 * @param categorie : Categorie
	 */
	public void supprimerCategorie(Categorie categorie) {
		sesCategories.remove(categorie);
		categorie.sonEpreuve = null;
	}

	// Halim


	// Ne pas utiliser dans le package modeles


	/**
	 * Getter pour getIdEpreuve
	 * 
	 * @return idEpreuve : Entier
	 */
	public int getIdEpreuve() {
		return idEpreuve;
	}

	/**
	 * 
	 * Setter pour setIdEpreuve
	 * 
	 * @param idEpreuve : Entier
	 */

	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

	/**
	 * 
	 * Getter pour getNomEpreuve
	 * 
	 * @return nomEpreuve : Chaine de caractères 
	 */

	public String getNomEpreuve() {
		return nomEpreuve;
	}

	/**
	 * 
	 * Setter pour setNomEpreuve
	 * 
	 * @param nomEpreuve : Chaine de caractères 
	 */

	public void setNomEpreuve(String nomEpreuve) {
		this.nomEpreuve = nomEpreuve;
	}

	/**
	 * 
	 * Getter pour getDescriptionEpreuve
	 * 
	 * @return descriptionEpreuve : Chaine de caractères 
	 */


	public String getDescriptionEpreuve() {
		return descriptionEpreuve;
	}

	/**
	 * 
	 * Setter pour setDescriptionEpreuve
	 * 
	 * @param descriptionEpreuve : Chaine de caractères 
	 */

	public void setDescriptionEpreuve(String descriptionEpreuve) {
		this.descriptionEpreuve = descriptionEpreuve;
	}

	/**
	 * 
	 * Getter pour getSesCategories
	 * 
	 * @return sesCategories : ArrayList Categorie
	 */

	public ArrayList<Categorie> getSesCategories() {
		return sesCategories;
	}

	/**
	 * 
	 * Setter pour setSesCategories
	 * 
	 * @param sesCategories : ArrayList Categorie
	 */

	public void setSesCategories(ArrayList<Categorie> sesCategories) {
		this.sesCategories = sesCategories;
	}


	public String toString() {
		return nomEpreuve;
	}

}

