package ihm.bd;

import java.io.IOException;
import java.util.List;

import dao.Connexion;
import dao.EleveDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import openk.Eleve;
import openk.Utilisateur;

public class BulletinGUI extends Application {


	private static int compteur=0;
	private final int numero;
	
    private Stage fenetrePrincipale;
    private AnchorPane structureRacineDeLaFenetre;
    
    private ObservableList<Eleve> bulletinData = FXCollections.observableArrayList();
    
    private BulletinControl sousControleur=null;
    
    
    
    public BulletinGUI() {
    	super();
    	this.bulletinData = getBulletinData();
    	this.numero=compteur++;
		System.out.println("cponstructeur " + this.numero);
    }
    public ObservableList<Eleve> getBulletinData() {
		return bulletinData;
	}

 	@Override
 	public void start(Stage premierescene) throws Exception {
 	
 		
 		this.fenetrePrincipale = premierescene;
 		this.fenetrePrincipale.setTitle("Bulletin");
 		
 		initStructureRacineDeLaFenetre();
 		
 		//montrerLesEleves();
 		
 	}
    public void initStructureRacineDeLaFenetre() {
        try {
            // Fait le lien avec la vue
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UtilisateurControl.class.getResource("Bulletin.fxml"));
            
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
     public void montrerLesEleves() {
        try {
            // On associe � l'autre vue de la liste 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BulletinGUI.class.getResource("./Bulletin.fxml"));
            //System.out.println("loader"+UtilisateurGUI.class.getResource("./Utilisateur.fxml"));
            // Ici, nous laissons la vue d�clarer sa propre instance de contr�leur,
            // unique, d�clar�e une seule fois : maintenant
            AnchorPane lesEleves = (AnchorPane) loader.load();
            
            
            // Place cette sous-fen�tre au milieu de la fen�tre principale
            //structureRacineDeLaFenetre.setCenter(lesEleves);
                        
            // r�cup�re le contr�leur de la sous-fen�tre 
            this.sousControleur = loader.getController();
            //this.sousControleur.setMainApp(this);
            
    		System.out.println(this.numero+" -> fin de montrer les eleve / "+this.sousControleur);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Stage getFenetrePrincipale() {
 		return fenetrePrincipale;
 	}
    
    public ObservableList<Eleve> getEleveDataEleve() {
    	bulletinData = FXCollections.observableArrayList();
		List<Eleve> lesEleves = EleveDAO.getInstance().readTable();
		for (Eleve eleve : lesEleves) {
			bulletinData.add(eleve);
		}
		return bulletinData;
	}
    
    public static void main(String[] args) {
        launch(args);
        Connexion.fermer();
    }
}
