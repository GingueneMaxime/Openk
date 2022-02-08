package ihm.bd;



import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import openk.Utilisateur;

public class openkControl {


	// On pr�pare ici des donn�es dans le programme java, chaque nom utilis� ici sera reli�
	// � un objet javafx, reli� avec le fx:id situ� dans la partie Code de Scene Builder

	// La partie droite de la fen�tre, une liste d'avions
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

	// Les champs de la partie gauche de la fen�tre qui affichent les d�tails 
	// de l'avions actif
	@FXML
	private Label id;
	@FXML
	private Label prenom;
	@FXML
	private Label mail;
	@FXML
	private Label tel;

	// Les r�f�rences crois�es vers l'application principale
	private UtilisateurGUI mainApp;

	// La ligne s�lectionn�e dans la liste (par d�faut la premi�re)
	private int ligneActive=0;

	/**
	 * Le constructeur est appel� juste avant la m�thode d'initialisation
	 */
	public openkControl() {  	
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
		idColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_utilisateur()+""));
		nomColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
	}

	/**
	 * Cette m�thode permet de relier le contr�leur principal (reli� au m�tier)
	 * au sous-contr�leur
	 * @param mainApp : l'application principale 
	 */
	public void setMainApp(UtilisateurGUI mainApp) {
		//System.out.println("setMainApp called");
		this.mainApp = mainApp;
		utilisateurTable.setItems(this.mainApp.getutilisateurData());
		afficheAvionSelection();  
	}

	/**
	 * Mets � jour la partie gauche de la fen�tre avec les d�tails de l'avion actif 
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
		// permet de r�cup�rer le num�ro de la ligne s�lectionn�es
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

