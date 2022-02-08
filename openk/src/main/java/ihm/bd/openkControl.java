package ihm.bd;



import javafx.beans.property.SimpleStringProperty;
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
	// pour laquelle on n'affiche que deux informations (identifiant et nom de l'avion)
	@FXML
	private TableColumn<Utilisateur, String> idColonne;
	@FXML
	private TableColumn<Utilisateur, String> nomColonne;

	// un champs qui permet de montrer l'action du bouton
	@FXML
	private Label texteTest;

	// Les champs de la partie gauche de la fenêtre qui affichent les détails 
	// de l'avions actif
	@FXML
	private Label id;
	@FXML
	private Label prenom;
	@FXML
	private Label mail;
	@FXML
	private Label tel;

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
		utilisateurTable.setItems(this.mainApp.getutilisateurData());
		afficheAvionSelection();  
	}

	/**
	 * Mets à jour la partie gauche de la fenêtre avec les détails de l'avion actif 
	 */
	private void afficheAvionSelection() {
		Utilisateur projetCourant = utilisateurTable.getItems().get(ligneActive);
		id.setText(projetCourant.getNum_utilisateur()+"");

		prenom.setText(projetCourant.getPrenom());
		mail.setText(projetCourant.getMail());
		tel.setText(projetCourant.getTel()+"");
	}
	@FXML
	private void handleMouseTableViewAction(MouseEvent event) {
		// permet de récupérer le numéro de la ligne sélectionnées
		this.setLigneActive(utilisateurTable.getSelectionModel().getSelectedIndex());
		this.afficheAvionSelection();
	}

	/**
	 * Modifie la ligne active
	 * @param ligneSelectionnee
	 */
	public void setLigneActive(int ligneSelectionnee) {
		this.ligneActive=ligneSelectionnee;
	}

}

