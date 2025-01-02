package jeuxOlympiques.vues;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import jeuxOlympiques.modeles.Session;

/**
 * 
 * @author ese
 *
 */
// Eric
public class PanelAfficherCalendrier extends AbstractTableModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Session> list; // On crée une liste de session
	PanelBandeau bandeau;
	JTable table;
	JScrollPane scrollpane;
	JFrame frame;

	/**
	 * Créer un nouveau objet PanelAfficherCalendrier
	 */
	public PanelAfficherCalendrier() {
		bandeau = new PanelBandeau();
		list = PanelSelectionSession.getLesSessions();
		table = new JTable(this);
		scrollpane = new JScrollPane(table);

		JPanel panelMain = new JPanel(new BorderLayout());

		panelMain.add(bandeau, BorderLayout.NORTH);

		panelMain.add(scrollpane, BorderLayout.CENTER);

		frame = new JFrame("Calendrier");
		frame.getContentPane().add(panelMain);
		frame.setSize(880, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Permet d'afficher la fenêtre une fois l'objet construit
	 */
	public void afficherCalendrier() {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * 
	 */
	public Object getValueAt(int rowIndex, int columnIndex) { // Déclaration des attributs
		return getData(list.get(rowIndex), columnIndex);
	}

	/**
	 * Returns a default name for the column using spreadsheet conventions: A, B, C,
	 * ... Z, AA, AB, etc. If column cannot be found, returns an empty string.
	 * Specified by:
	 * getColumnName in interface TableModel
	 * 
	 * @param agent - l'objet session permettant de récupérer ses différents
	 *              éléments
	 * @param col   - the column being queried
	 * @return a string containing the default name of column
	 */
	public Object getData(Session agent, int col) { // Récupérer les getters de la table Sessions
		switch (col) {
			case 0:
				return agent.typeSession();
			case 1:
				return agent.descSession();
			case 2:
				return agent.getDateSession();
			case 3:
				return agent.heureDebut();
			case 4:
				return agent.heureFin();
		}
		return null;
	}

	/**
	 * 
	 */
	public String getColumnName(int column) { // Initialiser le Nom de Colonne
		switch (column) {
			case 0:
				return "Type";
			case 1:
				return "Description";
			case 2:
				return "Date";
			case 3:
				return "Heure début";
			case 4:
				return "Heure fin";
		}
		return "";
	}

	/**
	 * 
	 */
	public int getRowCount() { // Définir le nombre de lignes
		return list.size(); // on utilise la taille de ArrayList en prenant la classe Session
	}

	/**
	 * 
	 */
	public int getColumnCount() { // Pour Date, Heure Début et heure fin de Calendrier
		return 5; // On définit le nombre de colonnes, c'est-à-dire Date, Heure début et Heure fin
	}

	public static void main(String[] args) {
		PanelAfficherCalendrier n = new PanelAfficherCalendrier();
		n.afficherCalendrier();
	}
}