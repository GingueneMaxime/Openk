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
            
            // Ici, nous choisissons de gérer par nous même le lien entre
            // le controleur et la vue. Cela évite d'avoir deux instances du contrôleur
            // à savoir celle lancée au début du programme et celle qui aurait été générée
            // maintenant
            loader.setController(this);
            structureRacineDeLaFenetre = (BorderPane) loader.load();
            
            // Affiche la fenêtre principale
            Scene scene = new Scene(structureRacineDeLaFenetre);
            fenetrePrincipale.setScene(scene);
            fenetrePrincipale.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void montrerLesUtilisateurs() {
        try {
            // On associe à l'autre vue de la liste d'avions
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ControlGUI.class.getResource("./bd/Utilisateur.fxml"));
            
            // Ici, nous laissons la vue déclarer sa propre instance de contrôleur,
            // unique, déclarée une seule fois : maintenant
            AnchorPane lesUtilisateur = (AnchorPane) loader.load();
            
            
            // Place cette sous-fenêtre au milieu de la fenêtre principale
            structureRacineDeLaFenetre.setCenter(lesUtilisateur);
                        
            // récupère le contrôleur de la sous-fenêtre 
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
