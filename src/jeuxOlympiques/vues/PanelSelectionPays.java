package jeuxOlympiques.vues;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Halim
/**
 * @author hluquet
 */
public class PanelSelectionPays extends PanelSelection implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Pays pays;

	/**
	 * Permet de créer un objet pays en appelant le constructeur panelSelection
	 * 
	 * @param pays - Pays
	 */
	public PanelSelectionPays(Pays pays) {
		super();
		this.pays = pays;
		buttonTitre = new JButton("       " + pays.getNomPays() + "       ");
		buttonTitre.setForeground(Color.white); // Met le texte du label en blanc
		buttonTitre.setBackground(Color.blue);
		panelTitre.add(buttonTitre);
		panelTitre.setBackground(Color.blue);
	}

	// Permet d'ajouter les différents actionListener des boutons
	/**
	 * Permet d'ajouter les différents actionListener des boutons
	 * @param temp - PanelAfficherPays
	 */
	public void ajouterEcouteurs(PanelAfficherPays temp) {

		buttonSupprimer.addActionListener(new EcouteurSupprimerElementGrillePays(this, temp));
		buttonModifier.addActionListener(new EcouteurModifierElementGrillePays(this, temp));
		buttonTitre.addActionListener(new EcouteurPaysToEquipe(this, temp));
	}

	/**
	 * Getter de pays
	 * 
	 * @return pays - Pays
	 */
	public Pays getPays() {
		return pays;
	}
}
