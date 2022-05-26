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


	// On prépare ici des données dans le programme java, chaque nom utilisé ici sera relié
	// à un objet javafx, relié avec le fx:id situé dans la partie Code de Scene Builder

	// La partie droite de la fenêtre, une liste d'avions
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

	// Les champs de la partie gauche de la fenêtre qui affichent les détails 
	@FXML
	private Label ID;
	@FXML
	private Label numMatiere;
	@FXML
	private Label note;
	

	// Les références croisées vers l'application principale
	private BulletinGUI mainApp;

	// La ligne sélectionnée dans la liste (par défaut la première)
	private int ligneActive=0;

	/**
	 * Le constructeur est appelé juste avant la méthode d'initialisation
	 */
	public BulletinControl() {  	
	}

	/**
	 * Initializes the controller class.
	 * Cette méthode est appelée juste après que la fenêtre ait été chargée
	 */
	@FXML
	private void initialize() {
		// La notation s'appuie sur l'écriture fonctionnelle (lambda) que nous ne 
		// verrons pas en détail.
		// Pour faire court : les méthodes sont appliquées pour chaque ligne avec chaque élément de la liste
		// On passe par des SimpleStringProperty pour conserver nos classes métier sans javaFX
		idColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumEleve()+""));
		numMatiereColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumMatiere()+""));
		noteColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNote()+""));
			}

	/**
	 * Cette méthode permet de relier le contrôleur principal (relié au métier)
	 * au sous-contrôleur
	 * @param mainApp : l'application principale 
	 */
	public void setMainApp(BulletinGUI mainApp) {
		//System.out.println("setMainApp called");
		this.mainApp = mainApp;
		eleveTable.setItems(this.mainApp.getBulletinData());
		afficheEleveSelection();  
	}

	/**
	 * Mets à jour la partie gauche de la fenêtre avec les détails de l'avion actif 
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
		// permet de récupérer le numéro de la ligne sélectionnées
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

