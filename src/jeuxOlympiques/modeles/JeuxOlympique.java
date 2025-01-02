package jeuxOlympiques.modeles;
import java.io.Serializable;
import java.util.*;

/**
   * @author ese
   */
public class JeuxOlympique implements Serializable{

  private static final long serialVersionUID = 1L;
ArrayList<Pays> sesPays;
  ArrayList<Athlete> sesAthletes;
  ArrayList<Epreuve> sesEpreuves;
  ArrayList<Session> sesSessions;
  ArrayList<Equipe> sesEquipes;

  

  /**
   * 
   * Constructeur JeuxOlympique
   */

  public JeuxOlympique() {
        sesPays = new ArrayList<>();
        sesAthletes = new ArrayList<>();
        sesEpreuves = new ArrayList<>();
        sesSessions = new ArrayList<>();
        sesEquipes = new ArrayList<>();
    }

  // Getters pour accéder aux listes

  /**
   * 
   * Getter pour getSesPays
   * 
   * @return sesPays : ArrayList Pays
   */

    public ArrayList<Pays> getSesPays() {
        return sesPays;
    }

    /**
     * 
     * Getter pour getSesAthletes
     * 
     * @return sesPays : ArrayList Athlete
     */

    public ArrayList<Athlete> getSesAthletes() {
        return sesAthletes;
    }

    /**
     * 
     * Getter pour getSesEpreuves
     * 
     * @return sesEpreuves : ArrayList Epreuve
     */

    public ArrayList<Epreuve> getSesEpreuves() {
        return sesEpreuves;
    }

    /**
     * 
     * Getter pour getSesSessions
     * 
     * @return sesSessions : ArrayList Session
     */

    public ArrayList<Session> getSesSessions() {
        return sesSessions;
    }


    /**
     * 
     * Getter pour getSesEquipes
     * 
     * @return sesEquipes : ArrayList Equipe
     */

    public ArrayList<Equipe> getSesEquipes() {
        return sesEquipes;
    }

    // Setters pour modifier les listes

    /**
     * 
     * Setter pour setSesPays
     * 
     * @param sesPays : ArrayList Pays
     */
    public void setSesPays(ArrayList<Pays> sesPays) {
        this.sesPays = sesPays;
    }

    /**
     * 
     * Setter pour setSesAthletes
     * 
     * @param sesAthletes : ArrayList Athlete
     */

    public void setSesAthletes(ArrayList<Athlete> sesAthletes) {
        this.sesAthletes = sesAthletes;
    }

    /**
     * 
     * Setter pour setSesEpreuves 
     * 
     * @param sesEpreuves : ArrayList Epreuve
     */

    public void setSesEpreuves(ArrayList<Epreuve> sesEpreuves) {
        this.sesEpreuves = sesEpreuves;
    }

    /**
     * 
     * Setter pour setSesSessions 
     * 
     * @param sesSessions : ArrayList Session 
     */

    public void setSesSessions(ArrayList<Session> sesSessions) {
        this.sesSessions = sesSessions;
    }

    /**
     * 
     * Setter pour setSesEquipes 
     * 
     * @param sesEquipes : ArrayList Equipe
     */

    public void setSesEquipes(ArrayList<Equipe> sesEquipes) {
        this.sesEquipes = sesEquipes;
    }
}