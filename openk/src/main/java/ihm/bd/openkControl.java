package ihm.bd;




import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import openk.Projet;

public class openkControl {


	// On prépare ici des données dans le programme java, chaque nom utilisé ici sera relié
	// à un objet javafx, relié avec le fx:id situé dans la partie Code de Scene Builder

	// La partie droite de la fenêtre, une liste d'avions
	@FXML
	private TableView<Projet> projetTable;
	// pour laquelle on n'affiche que deux informations (identifiant et nom de l'avion)
	@FXML
	private TableColumn<Projet, String> idColonne;
	@FXML
	private TableColumn<Projet, String> nomColonne;

	// un champs qui permet de montrer l'action du bouton
	@FXML
	private Label texteTest;

	// Les champs de la partie gauche de la fenêtre qui affichent les détails 
	// de l'avions actif
	@FXML
	private Label num_utilisateur;
	@FXML
	private Label nom;
	@FXML
	private Label prenom;
	@FXML
	private Label mail;
	@FXML
	private Label tel;

	// Les références croisées vers l'application principale
	private AvionGUI mainApp;

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
		idColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumero()+""));
		nomColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
	}

	/**
	 * Cette méthode permet de relier le contrôleur principal (relié au métier)
	 * au sous-contrôleur
	 * @param mainApp : l'application principale 
	 */
	public void setMainApp(AvionGUI mainApp) {
		//System.out.println("setMainApp called");
		this.mainApp = mainApp;
		projetTable.setItems(this.mainApp.getProjetData());
		afficheAvionSelection();  
	}

	/**
	 * Mets à jour la partie gauche de la fenêtre avec les détails de l'avion actif 
	 */
	private void afficheAvionSelection() {
		Projet projetCourant = projetTable.getItems().get(ligneActive);
		num_utilisateur.setText(projetCourant.getNumero()+"");

		nom.setText(projetCourant.getNom());
		prenom.setText(projetCourant.getPrenom());
		mail.setText(projetCourant.getMail());
		tel.setText(projetCourant.getTel()+"");
	}

	/**
	 * Pour chaque bouton on peut définir une méthode propre associée à ce bouton
	 * Dans Scene Builder, à gauche, on clique sur hierarchy, Button
	 * à droite, a été indiqué le nom de la méthode dans On Action
	 * @param event
	 */
	@FXML
	private void handleButtonAction(ActionEvent event) {
		texteTest.setText("clic (" + ligneActive+")");
	}

	
	/**
	 * À vérifier
	 * Il serait possible de générer des petites fenêtres de dialogue
	 * mais actuellement la classe Alert est inconnue (nécessite javaFX 8u40)
	 * @param event
	 *
	@FXML
	private void handleButtonActionMessage(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("I have a great message for you!");

		alert.showAndWait();
	
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Look, a Confirmation Dialog");
		alert.setContentText("Are you ok with this?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			texteTest.setText("option ok");
		} else {
			texteTest.setText("option cancel");
		}	
	}*/
	@FXML
	private void handleButtonActionMessage(ActionEvent event) {
		texteTest.setText("Alert : inactif");
	}
	
	/**
	 * Pour le MenuButton, on peut définir une méthode propre à chaque ligne associée à cette liste
	 * Dans Scene Builder, à gauche, on clique sur hierarchy, Button
	 * à droite, a été indiqué le nom de la méthode dans On Action
	 * @param event
	 */
	@FXML
	public void handleButtonsListEpaves(ActionEvent event) {
		projetTable.setItems(this.mainApp.getAvionDataEpave());
		afficheAvionSelection(); 
	}

	@FXML
	public void handleButtonsListRestore(ActionEvent event) {
		projetTable.setItems(this.mainApp.getAvionDataAvion());
		afficheAvionSelection(); 
	}

	/**
	 * Pour chaque partie de la fenêtre qui peut être manipulée par la souris,
	 * on peut faire une méthode.
	 * Celle-ci est indiquée dans la partie "code" de TableView :
	 * Dans Scene Builder, à gauche, on clique sur hierarchy, TableView
	 * à droite, a été indiqué le nom de la méthode dans On Mouse Clicked
	 *   
	 * @param event
	 */
	@FXML
	private void handleMouseTableViewAction(MouseEvent event) {
		// permet de récupérer le numéro de la ligne sélectionnées
		this.setLigneActive(projetTable.getSelectionModel().getSelectedIndex());
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

