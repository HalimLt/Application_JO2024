package jeuxOlympiques.modeles;
import java.util.*;

/**
 * 
 * @author sgadewa
 */
public class Ville {

	ArrayList<Lieu> sesLieux;
	protected int idVille;
	protected String nomVille;
	protected int CPVille;
	private static int nbVille;

	

	/**
	 * Constructeur pour Ville
	 * 
	 * @param idVille : Entier
	 * @param nomVille : Chaine de caractères
	 * @param CPVille : Entier
	 */
	// Halim
	public Ville(int idVille, String nomVille, int CPVille) {
		nbVille++;
		this.idVille = nbVille;
		this.nomVille = nomVille;
		this.CPVille = CPVille;
	}

	// Eric
	// Ne pas utiliser dans le package modele
	// Getters et Setters

	/**
	 * 
	 * Getter pour getIdVille
	 * 
	 * @return idVille : Entier
	 */

	// idVille

	public int getIdVille() {
		return idVille;
	}

	/**
	 * 
	 * Setter pour setIdVille
	 * 
	 * @param idVille : Entier
	 */

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	/**
	 * 
	 * 
	 * Getter pour getNomVille
	 * @return nomVille : Chaine de caractères
	 */

	// nomVille 
	public String getNomVille() {
		return nomVille;
	}

	/**
	 * 
	 * Setter pour setNomVille
	 * 
	 * @param nomVille : Chaine de caractères
	 */

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}


	/**
	 * 
	 * Getter pour getCPVille 
	 * 
	 * 
	 * @return CPVille : Entier
	 */
	// CPVille
	public int getCPVille() {
		return CPVille;
	}

	/**
	 * 
	 * Setter pour setCPVille
	 * 
	 * 
	 * @param CPVille :Entier
	 */

	public void setCPVille(int CPVille) {
		this.CPVille = CPVille;
	}


}