package jeuxOlympiques.controleurs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import jeuxOlympiques.modeles.*;


/**
 * @author hluquet
 */


public class EcouteurComboBoxEpreuve implements ActionListener {
	JComboBox<Categorie> comboBoxCategorie;
	Epreuve selectedEpreuve;

	/**
	 * Constructeur EcouteurComboBoxEpreuve 
	 * 
	 * @param comboBoxCategorie : JComboBox Categorie
	 */

	public EcouteurComboBoxEpreuve(JComboBox<Categorie> comboBoxCategorie) {
		this.comboBoxCategorie = comboBoxCategorie;
	}

	public void actionPerformed(ActionEvent event) {
		JComboBox<Epreuve> comboBox = (JComboBox<Epreuve>) event.getSource();
		selectedEpreuve = (Epreuve) comboBox.getSelectedItem();
		comboBoxCategorie.removeAllItems();

		for (Categorie categorie : selectedEpreuve.getSesCategories()) {
			comboBoxCategorie.addItem(categorie);

		}
	}
}