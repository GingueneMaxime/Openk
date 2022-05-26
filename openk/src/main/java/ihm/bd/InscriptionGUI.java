package ihm.bd;

import java.io.IOException;
import java.util.List;

import dao.Connexion;
import dao.UtilisateurDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import openk.Utilisateur;

public class InscriptionGUI extends Application {


	private static int compteur=0;
	private final int numero;
	
    private Stage fenetrePrincipale;
    private AnchorPane structureRacineDeLaFenetre;
    
    private ObservableList<Utilisateur> inscriptionData = FXCollections.observableArrayList();
    
    private InscriptionControl sousControleur=null;
    
    
    
    public InscriptionGUI() {
    	super();
    	this.inscriptionData = getInscriptionDataInscription();
    	this.numero=compteur++;
		System.out.println("cponstructeur " + this.numero);
    }
    public ObservableList<Utilisateur> getInscriptionData() {
		return inscriptionData;
	}

 	@Override
 	public void start(Stage premierescene) throws Exception {
 	
 		this.fenetrePrincipale = premierescene;
 		this.fenetrePrincipale.setTitle("Inscription");
 		
 		initStructureRacineDeLaFenetre();
 		
 		
 	}
    public void initStructureRacineDeLaFenetre() {
        try {
            // Fait le lien avec la vue
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InscriptionControl.class.getResource("InscriptionFP.fxml"));
            
            // Ici, nous choisissons de gérer par nous même le lien entre
            // le controleur et la vue. Cela évite d'avoir deux instances du contrôleur
            // à savoir celle lancée au début du programme et celle qui aurait été générée
            // maintenant
            loader.setController(this);
            structureRacineDeLaFenetre = (AnchorPane) loader.load();
            
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
            // On associe à l'autre vue de la liste 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InscriptionGUI.class.getResource("./Inscription.fxml"));
            //System.out.println("loader"+UtilisateurGUI.class.getResource("./Utilisateur.fxml"));
            // Ici, nous laissons la vue déclarer sa propre instance de contrôleur,
            // unique, déclarée une seule fois : maintenant
            AnchorPane lesInscriptions = (AnchorPane) loader.load();
            
            
            // Place cette sous-fenêtre au milieu de la fenêtre principale
//            structureRacineDeLaFenetre.setCenter(lesInscriptions);
                        
            // récupère le contrôleur de la sous-fenêtre 
            this.sousControleur = loader.getController();
            this.sousControleur.setMainApp(this);
            
    		System.out.println(this.numero+" -> fin de montrer les utilisateur / "+this.sousControleur);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stage getFenetrePrincipale() {
 		return fenetrePrincipale;
 	}
    
    public ObservableList<Utilisateur> getInscriptionDataInscription() {
    	inscriptionData = FXCollections.observableArrayList();
		List<Utilisateur> lesUtilisateurs = UtilisateurDAO.getInstance().readTable();
		for (Utilisateur utilisateur : lesUtilisateurs) {
			inscriptionData.add(utilisateur);
		}
		return inscriptionData;
	}
    
    public static void main(String[] args) {
        launch(args);
        Connexion.fermer();
    }
}
