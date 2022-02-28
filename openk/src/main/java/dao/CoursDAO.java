package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import openk.Cours;

public class CoursDAO extends DAO<Cours>{

	private static final String TABLE = "Cours";
	private static final String CLE_PRIMAIRE = "num_cours";
	private static final String NUM_PROF = "numProf";
	private static final String NUM_MATIERE= "numMatiere";
	private static final String NUM_PROMOTION= "numPromotion";
	private static final String DATE_DEBUT= "dateDebut";
	private static final String DATE_FIN= "dateFin";
	

	private static CoursDAO instance=null;
	public static CoursDAO getInstance(){
		if (instance==null){
			instance = new CoursDAO();
		}
		return instance;
	}
	private CoursDAO() {
		super();
	}
	@Override
	public boolean create(Cours cours) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NUM_PROF+", "+NUM_MATIERE+", "+NUM_PROMOTION+","+DATE_DEBUT+","+DATE_FIN+") VALUES(?,?, ?,?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, cours.getNumProf());
			pst.setInt(2, cours.getNumMatiere());
			pst.setInt(3, cours.getNumPromotion());
			pst.setObject(4, cours.getDateDebut());
			pst.setObject(5, cours.getDateFin());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				cours.setNumCours(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Cours cours) {
		boolean succes = true;
		try {
			int id = cours.getNumCours();
			String requete = "DELETE FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, id);
			pst.executeUpdate();;
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}
	@Override
	public boolean update(Cours cours) {
		boolean succes = true;
		try {
			
			String requete = "UPDATE "+TABLE+" SET "+NUM_PROF+" =?, "+NUM_MATIERE+" =?,"+NUM_PROMOTION+" =?,"+DATE_DEBUT+" =? "+DATE_FIN+" =? WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, cours.getNumProf());
			pst.setInt(2, cours.getNumMatiere());
			pst.setInt(3, cours.getNumPromotion());
			pst.setObject(4, cours.getDateDebut());
			pst.setObject(5, cours.getDateFin());
			pst.setInt(6, cours.getNumCours());
			pst.executeUpdate();;
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();}
			
		return succes;
		
		}
		

	@Override
	public Cours read(int id) {
		Cours cours = null;
		/*if (donnees.containsKey(id)) {
			System.out.println("récupéré");
			utilisateur=donnees.get(id);
		}
		else {*/
			System.out.println("recherché dans la BD");
			try {



				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				String numProf = rs.getString(NUM_PROF);
				String numMatiere = rs.getString(NUM_MATIERE);
				String numPromotion = rs.getString(NUM_PROMOTION);
				String dateDebut = rs.getString(DATE_DEBUT);
				String dateFin = rs.getString(DATE_FIN);
				cours = new Cours (id, numProf, numMatiere, numPromotion, dateDebut, dateFin);
				//donnees.put(id, utilisateur);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return cours;

	}
	public void afficheSelectEtoileBatiment() {
		System.out.println("TODO");

	}
	public List<Cours> readTable() {
		List<Cours> rep = new ArrayList<Cours>();
		Cours cours = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				cours = CoursDAO.getInstance().read(id);
				rep.add(cours);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

	
}
