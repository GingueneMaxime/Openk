package ihm.bd;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import openk.Eleve;

public class BulletinControl {


	// On pr�pare ici des donn�es dans le programme java, chaque nom utilis� ici sera reli�
	// � un objet javafx, reli� avec le fx:id situ� dans la partie Code de Scene Builder

	// La partie droite de la fen�tre, une liste d'avions
	@FXML
	private TableView<Eleve> eleveTable;
	// pour laquelle on n'affiche que deux informations (identifiant et nom des utilisateurs)
	@FXML
	private TableColumn<Eleve, String> idColonne;
	@FXML
	private TableColumn<Eleve, String> numMatiereColonne;
	@FXML
	private TableColumn<Eleve, String> noteColonne;
	
	// un champs qui permet de montrer l'action du bouton
	@FXML
	private Label texteTest;

	// Les champs de la partie gauche de la fen�tre qui affichent les d�tails 
	@FXML
	private Label ID;
	@FXML
	private Label numMatiere;
	@FXML
	private Label note;
	

	// Les r�f�rences crois�es vers l'application principale
	private BulletinGUI mainApp;

	// La ligne s�lectionn�e dans la liste (par d�faut la premi�re)
	private int ligneActive=0;

	/**
	 * Le constructeur est appel� juste avant la m�thode d'initialisation
	 */
	public BulletinControl() {  	
	}

	/**
	 * Initializes the controller class.
	 * Cette m�thode est appel�e juste apr�s que la fen�tre ait �t� charg�e
	 */
	@FXML
	private void initialize() {
		// La notation s'appuie sur l'�criture fonctionnelle (lambda) que nous ne 
		// verrons pas en d�tail.
		// Pour faire court : les m�thodes sont appliqu�es pour chaque ligne avec chaque �l�ment de la liste
		// On passe par des SimpleStringProperty pour conserver nos classes m�tier sans javaFX
		idColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumEleve()+""));
		numMatiereColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumMatiere()+""));
		noteColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNote()+""));
			}

	/**
	 * Cette m�thode permet de relier le contr�leur principal (reli� au m�tier)
	 * au sous-contr�leur
	 * @param mainApp : l'application principale 
	 */
	public void setMainApp(BulletinGUI mainApp) {
		//System.out.println("setMainApp called");
		this.mainApp = mainApp;
		eleveTable.setItems(this.mainApp.getBulletinData());
		afficheEleveSelection();  
	}

	/**
	 * Mets � jour la partie gauche de la fen�tre avec les d�tails de l'avion actif 
	 */
	private void afficheEleveSelection() {
		Eleve projetCourant = eleveTable.getItems().get(ligneActive);
		ID.setText(projetCourant.getNumEleve()+"");

		numMatiere.setText(projetCourant.getNumMatiere()+"");
		note.setText(projetCourant.getNote()+"");
	}
	@FXML
	public void handleButtonsListEpaves(ActionEvent event) {
		eleveTable.setItems(this.mainApp.getBulletinData());
		afficheEleveSelection(); 
	}

	@FXML
	public void handleButtonsListEleve(ActionEvent event) {
		eleveTable.setItems(this.mainApp.getBulletinData());
		afficheEleveSelection(); 
	}

	@FXML
	private void handleMouseTableViewAction(MouseEvent event) {
		// permet de r�cup�rer le num�ro de la ligne s�lectionn�es
		this.setLigneActive(eleveTable.getSelectionModel().getSelectedIndex());
		this.afficheEleveSelection();
	}

	/**
	 * Modifie la ligne active
	 * @param ligneSelectionnee
	 */
	public void setLigneActive(int ligneSelectionnee) {
		this.ligneActive=ligneSelectionnee;
	}

}

