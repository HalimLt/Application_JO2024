package jeuxOlympiques.modeles;
import java.util.*;

/**
 * @author ese
 * 
 */
public class Lieu {

	Ville saVille;
	ArrayList<Session> sesSession;
	protected int idLieu;
	protected String nomLieu;
	protected String adrLieu;
	private static int nbLieu;



	/**
	 * Constructeur pour Lieu 
	 * 
	 * @param nomLieu : Chaine de caractères
	 * @param adrLieu : Chaine de caractères
	 * @param saVille : Chaine de caractères
	 */
	public Lieu(String nomLieu, String adrLieu, Ville saVille) {
		nbLieu++;
		this.idLieu = nbLieu;
		this.nomLieu = nomLieu;
		this.adrLieu = adrLieu;
		this.saVille = saVille;
	}

	// Eric
	// Ne pas utiliser dans le package modele
	// Getters et Setters

	/**
	 * 
	 * Getter de idLieu
	 * 
	 * @return idLieu : Entier
	 */

	public int idLieu() {
		return idLieu;
	}

	/**
	 * Setter de idLieu
	 * 
	 * @param idLieu : Entier
	 */
	public void idLieu(int idLieu) {
		this.idLieu = idLieu;

	}

	/**
	 * Getter de nomLieu
	 * 
	 * @return nomLieu : Chaine de caractères
	 */

	public String nomLieu() {
		return nomLieu;
	}

	/**
	 * Setter de nomLieu
	 * 
	 * 
	 * @param nomLieu : Chaine de caractères
	 */

	public void nomLieu(String nomLieu) {
		this.nomLieu = nomLieu;
	}

	/**
	 * Getter de adrLieu 
	 * 
	 * @return adrLieu : Chaine de caractères
	 */

	public String adrLieu() {
		return adrLieu;
	}

	/**
	 * Setter de adrLieu
	 * 
	 * @param adrLieu :  Chaine de caractères
	 */

	public void adrLieu(String adrLieu) {
		this.adrLieu = adrLieu;
	}

}