package ihm.bd;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import openk.Utilisateur;

public class InscriptionControl {


	// On pr�pare ici des donn�es dans le programme java, chaque nom utilis� ici sera reli�
	// � un objet javafx, reli� avec le fx:id situ� dans la partie Code de Scene Builder

	// La partie droite de la fen�tre, une liste d'avions
	@FXML
	private TableView<Utilisateur> utilisateurTable;
	// pour laquelle on n'affiche que deux informations (identifiant et nom des utilisateurs)
	@FXML
	private TableColumn<Utilisateur, String> idColonne;
	@FXML
	private TableColumn<Utilisateur, String> nomColonne;
	@FXML
	private TableColumn<Utilisateur, String> prenomColonne;
	@FXML
	private TableColumn<Utilisateur, String> mailColonne;
	@FXML
	private TableColumn<Utilisateur, String> telColonne;
	@FXML
	private TableColumn<Utilisateur, String> mot_de_passeColonne;

	// un champs qui permet de montrer l'action du bouton
	@FXML
	private Label FormulaireInscription;

	// Les champs de la partie gauche de la fen�tre qui affichent les d�tails 
	@FXML
	private Label NomUtilisateur;
	@FXML
	private Label Prenom;
	@FXML
	private Label AdresseMail;
	@FXML
	private Label numeroTelephone;
	@FXML
	private Label Civilite;
	

	// Les r�f�rences crois�es vers l'application principale
	private InscriptionGUI mainApp;

	// La ligne s�lectionn�e dans la liste (par d�faut la premi�re)
	private int ligneActive=0;

	/**
	 * Le constructeur est appel� juste avant la m�thode d'initialisation
	 */
	public InscriptionControl() {  	
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
		idColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumUtilisateur()+""));
		nomColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
		prenomColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
		mailColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMail()));
		telColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTel()));
		mot_de_passeColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotDePasse()));

	}

	/**
	 * Cette m�thode permet de relier le contr�leur principal (reli� au m�tier)
	 * au sous-contr�leur
	 * @param mainApp : l'application principale 
	 */
	public void setMainApp(InscriptionGUI mainApp) {
		//System.out.println("setMainApp called");
		this.mainApp = mainApp;
		utilisateurTable.setItems(this.mainApp.getInscriptionData());
//		afficheUtilisateurSelection();  
	}

	/**
	 * Mets � jour la partie gauche de la fen�tre avec les d�tails de l'avion actif 
	 */
//	private void afficheUtilisateurSelection() {
//		Utilisateur projetCourant = utilisateurTable.getItems().get(ligneActive);
//		NomUtilisateur.setText(projetCourant.getNom()+"");
//		NouveauMdp.setText(projetCourant.getMotDePasse());
//		ConfirmerMdp.setText(projetCourant.getMotDePasse());
//	}

	@FXML
	public void handleButtonsListUtilisateur(ActionEvent event) {
		utilisateurTable.setItems(this.mainApp.getInscriptionDataInscription());
//		afficheUtilisateurSelection(); 
	}

	@FXML
	private void handleMouseTableViewAction(MouseEvent event) {
		// permet de r�cup�rer le num�ro de la ligne s�lectionn�es
		this.setLigneActive(utilisateurTable.getSelectionModel().getSelectedIndex());
//		this.afficheUtilisateurSelection();
	}

	/**
	 * Modifie la ligne active
	 * @param ligneSelectionnee
	 */
	public void setLigneActive(int ligneSelectionnee) {
		this.ligneActive=ligneSelectionnee;
	}



	
}
