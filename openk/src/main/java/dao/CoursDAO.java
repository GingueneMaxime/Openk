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
	private static final String NUM_PROF = "num_prof";
	private static final String NUM_MATIERE= "num_matiere";
	private static final String NUM_PROMOTION= "num_promotion";
	private static final String DATE_DEBUT= "date_debut";
	private static final String DATE_FIN= "date_fin";
	

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
			pst.setInt(1, cours.getNum_prof());
			pst.setInt(2, cours.getNum_matiere());
			pst.setInt(3, cours.getNum_promotion());
			pst.setObject(4, cours.getDate_debut());
			pst.setObject(5, cours.getDate_fin());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				cours.setNum_cours(rs.getInt(1));
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
			int id = cours.getNum_cours();
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
	public boolean update(Cours obj) {
		// TODO Auto-generated method stub
		return false;
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
				String num_prof = rs.getString(NUM_PROF);
				String num_matiere = rs.getString(NUM_MATIERE);
				String num_promotion = rs.getString(NUM_PROMOTION);
				String date_debut = rs.getString(DATE_DEBUT);
				String date_fin = rs.getString(DATE_FIN);
				cours = new Cours (id, num_prof, num_matiere, num_promotion, date_debut, date_fin);
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
