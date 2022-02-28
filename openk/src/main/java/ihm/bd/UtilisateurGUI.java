package ihm.bd;

import java.io.IOException;
import java.util.List;
import dao.Connexion;
import dao.UtilisateurDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import openk.Utilisateur;

public class UtilisateurGUI extends Application {


	private static int compteur=0;
	private final int numero;
	
    private Stage fenetrePrincipale;
    private AnchorPane structureRacineDeLaFenetre;
    
    private ObservableList<Utilisateur> utilisateurData = FXCollections.observableArrayList();
    
    private UtilisateurControl sousControleur=null;
    
    public UtilisateurGUI() {
    	super();
    	this.utilisateurData = getUtilisateurDataUtilisateur();
    	this.numero=compteur++;
		System.out.println("cponstructeur " + this.numero);
    }
    public ObservableList<Utilisateur> getUtilisateurData() {
		return utilisateurData;
	}

 	@Override
 	public void start(Stage premierescene) throws Exception {
 	
 		Utilisateur ut = UtilisateurDAO.getInstance().read(10);
 		System.out.println(ut);
 		ut.setNom("Dupont");
 		ut.setTelephone(0707070707);
 		System.out.println(ut);
 		UtilisateurDAO.getInstance().update(ut);
 		System.out.println("mise � jour termin�e");
 		this.fenetrePrincipale = premierescene;
 		this.fenetrePrincipale.setTitle("Utilisateur");
 		initStructureRacineDeLaFenetre();
 		
 	}
    public void initStructureRacineDeLaFenetre() {
        try {
            // Fait le lien avec la vue
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UtilisateurControl.class.getResource("Utilisateur.fxml"));
            
            // Ici, nous choisissons de g�rer par nous m�me le lien entre
            // le controleur et la vue. Cela �vite d'avoir deux instances du contr�leur
            // � savoir celle lanc�e au d�but du programme et celle qui aurait �t� g�n�r�e
            // maintenant
            loader.setController(this);
            structureRacineDeLaFenetre = (AnchorPane) loader.load();
            
            // Affiche la fen�tre principale
            Scene scene = new Scene(structureRacineDeLaFenetre);
            fenetrePrincipale.setScene(scene);
            fenetrePrincipale.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   /* public void montrerLesUtilisateurs() {
        try {
            // On associe � l'autre vue de la liste 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UtilisateurGUI.class.getResource("Utilisateur.fxml"));
            
            // Ici, nous laissons la vue d�clarer sa propre instance de contr�leur,
            // unique, d�clar�e une seule fois : maintenant
            AnchorPane lesUtilisateurs = (AnchorPane) loader.load();
            
            
            // Place cette sous-fen�tre au milieu de la fen�tre principale
            structureRacineDeLaFenetre.setCenter(lesUtilisateurs);
                        
            // r�cup�re le contr�leur de la sous-fen�tre 
            this.sousControleur = loader.getController();
            this.sousControleur.setMainApp(this);
            
    		System.out.println(this.numero+" -> fin de montrer les utilisateur / "+this.sousControleur);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
    public Stage getFenetrePrincipale() {
 		return fenetrePrincipale;
 	}
    
    public ObservableList<Utilisateur> getUtilisateurDataUtilisateur() {
		utilisateurData = FXCollections.observableArrayList();
		List<Utilisateur> lesUtilisateurs = UtilisateurDAO.getInstance().readTable();
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
