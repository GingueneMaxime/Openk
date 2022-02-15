package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import openk.Seance;

public class SeanceDAO extends DAO<Seance>{

	private static final String TABLE = "seance";
	private static final String CLE_PRIMAIRE = "num_seance";
	private static final String NUM_COURS = "num_cours";
	private static final String NUM_SALLE = "num_salle";
	private static final String DATE_DEBUT= "date_debut";
	private static final String DATE_FIN= "date_fin";

	private static SeanceDAO instance=null;
	public static SeanceDAO getInstance(){
		if (instance==null){
			instance = new SeanceDAO();
		}
		return instance;
	}
	private SeanceDAO() {
		super();
	}
	@Override
	public boolean create(Seance seance) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NUM_COURS+"+"+NUM_SALLE+", "+DATE_DEBUT+","+DATE_FIN+") VALUES (?, ?, ?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, seance.getNum_cours());
			pst.setInt(2, seance.getNum_salle());
			pst.setObject(3, seance.getDate_debut());
			pst.setObject(4, seance.getDate_fin());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				seance.setNum_seance(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Seance seance) {
		boolean succes = true;
		try {
			int id = seance.getNum_seance();
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
	public boolean update(Seance obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Seance read(int id) {
		Seance seance = null;
		/*if (donnees.containsKey(id)) {
			System.out.println("récupéré");
			seance=donnees.get(id);
		}
		else {*/
			System.out.println("recherché dans la BD");
			try {



				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				int num_cours = rs.getInt(NUM_COURS);
				int num_salle = rs.getInt(NUM_SALLE);
				LocalDateTime date_debut = (LocalDateTime) rs.getObject(DATE_DEBUT);
				LocalDateTime date_fin = (LocalDateTime) rs.getObject(DATE_FIN);
				seance = new Seance (id,num_cours, num_salle, date_debut,date_fin);
				//donnees.put(id, promotion);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return seance;

	}
	public void afficheSelectEtoilePromotion() {
		System.out.println("TODO");

	}
	public List<Seance> readTable() {
		List<Seance> rep = new ArrayList<Seance>();
		Seance seance = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				seance = SeanceDAO.getInstance().read(id);
				rep.add(seance);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

	
}
