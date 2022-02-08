package ihm.bd;

import dao.Connexion;
import dao.UtilisateurDAO;
import ihm.bd.openkControl;
import openk.Utilisateur;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ControlGUI extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	private static int compteur=0;
	private final int numero;
	
    private Stage fenetrePrincipale;
    private BorderPane structureRacineDeLaFenetre;
    
    private ObservableList<Utilisateur> utilisateurData = FXCollections.observableArrayList();
    
    private openkControl sousControleur=null;
    
    public ControlGUI() {
    	super();
    	this.utilisateurData = getutilisateurData();
    	this.numero=compteur++;
		System.out.println("cponstructeur " + this.numero);
    }
    public ObservableList<Utilisateur> getutilisateurData() {
		return utilisateurData;
	}
    
    public void initStructureRacineDeLaFenetre() {
        try {
            // Fait le lien avec la vue
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(openkControl.class.getResource("Utilisateur.fxml"));
            
            // Ici, nous choisissons de g�rer par nous m�me le lien entre
            // le controleur et la vue. Cela �vite d'avoir deux instances du contr�leur
            // � savoir celle lanc�e au d�but du programme et celle qui aurait �t� g�n�r�e
            // maintenant
            loader.setController(this);
            structureRacineDeLaFenetre = (BorderPane) loader.load();
            
            // Affiche la fen�tre principale
            Scene scene = new Scene(structureRacineDeLaFenetre);
            fenetrePrincipale.setScene(scene);
            fenetrePrincipale.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void montrerLesUtilisateurs() {
        try {
            // On associe � l'autre vue de la liste d'avions
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ControlGUI.class.getResource("./bd/Utilisateur.fxml"));
            
            // Ici, nous laissons la vue d�clarer sa propre instance de contr�leur,
            // unique, d�clar�e une seule fois : maintenant
            AnchorPane lesUtilisateur = (AnchorPane) loader.load();
            
            
            // Place cette sous-fen�tre au milieu de la fen�tre principale
            structureRacineDeLaFenetre.setCenter(lesUtilisateur);
                        
            // r�cup�re le contr�leur de la sous-fen�tre 
            this.sousControleur = loader.getController();
            this.sousControleur.setMainApp(this);
            
    		System.out.println(this.numero+" -> fin de montrer les avions / "+this.sousControleur);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Stage getFenetrePrincipale() {
		return fenetrePrincipale;
	}
    public ObservableList<Utilisateur> getAvionDataAvion() {
		utilisateurData = FXCollections.observableArrayList();
		List<Utilisateur> lesAvions = UtilisateurDAO.getInstance().readTable();
		for (Utilisateur utilisateur : lesUtilisateurs) {
			utilisateurData.add(utilisateur);
		}
		return utilisateurData;
	}
    public static void main(String[] args) {
        launch(args);
        Connexion.fermer();
    }
}
