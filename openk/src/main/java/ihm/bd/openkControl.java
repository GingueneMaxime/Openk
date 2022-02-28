package ihm.bd;



import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import openk.Utilisateur;

public class openkControl {


	// On prépare ici des données dans le programme java, chaque nom utilisé ici sera relié
	// à un objet javafx, relié avec le fx:id situé dans la partie Code de Scene Builder

	// La partie droite de la fenêtre, une liste d'avions
	@FXML
	private TableView<Utilisateur> utilisateurTable;
	// pour laquelle on n'affiche que deux informations (identifiant et nom des utilisateurs)
	@FXML
	private TableColumn<Utilisateur, String> idColonne;
	@FXML
	private TableColumn<Utilisateur, String> nomColonne;

	// un champs qui permet de montrer l'action du bouton
	@FXML
	private Label texteTest;

	// Les champs de la partie gauche de la fenêtre qui affichent les détails 
	@FXML
	private Label ID;
	@FXML
	private Label Prénom;
	@FXML
	private Label Mail;
	@FXML
	private Label Tel;

	// Les références croisées vers l'application principale
	private UtilisateurGUI mainApp;

	// La ligne sélectionnée dans la liste (par défaut la première)
	private int ligneActive=0;

	/**
	 * Le constructeur est appelé juste avant la méthode d'initialisation
	 */
	public openkControl() {  	
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
		idColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_utilisateur()+""));
		nomColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
	}

	/**
	 * Cette méthode permet de relier le contrôleur principal (relié au métier)
	 * au sous-contrôleur
	 * @param mainApp : l'application principale 
	 */
	public void setMainApp(UtilisateurGUI mainApp) {
		//System.out.println("setMainApp called");
		this.mainApp = mainApp;
		utilisateurTable.setItems(this.mainApp.getUtilisateurData());
		afficheUtilisateurSelection();  
	}

	/**
	 * Mets à jour la partie gauche de la fenêtre avec les détails de l'avion actif 
	 */
	private void afficheUtilisateurSelection() {
		Utilisateur projetCourant = utilisateurTable.getItems().get(ligneActive);
		ID.setText(projetCourant.getNum_utilisateur()+"");

		Prénom.setText(projetCourant.getPrenom());
		Mail.setText(projetCourant.getMail());
		Tel.setText(projetCourant.getTel()+"");
	}
	@FXML
	public void handleButtonsListEpaves(ActionEvent event) {
		utilisateurTable.setItems(this.mainApp.getUtilisateurData());
		afficheUtilisateurSelection(); 
	}

	@FXML
	public void handleButtonsListUtilisateur(ActionEvent event) {
		utilisateurTable.setItems(this.mainApp.getUtilisateurDataUtilisateur());
		afficheUtilisateurSelection(); 
	}

	@FXML
	private void handleMouseTableViewAction(MouseEvent event) {
		// permet de récupérer le numéro de la ligne sélectionnées
		this.setLigneActive(utilisateurTable.getSelectionModel().getSelectedIndex());
		this.afficheUtilisateurSelection();
	}

	/**
	 * Modifie la ligne active
	 * @param ligneSelectionnee
	 */
	public void setLigneActive(int ligneSelectionnee) {
		this.ligneActive=ligneSelectionnee;
	}

}

