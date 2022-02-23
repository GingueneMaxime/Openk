package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import openk.Prof;



public class ProfDAO extends DAO<Prof> {

	private static final String TABLE = "prof";
	private static final String CLE_PRIMAIRE = "num_prof";

	

	private static ProfDAO instance=null;
	public static ProfDAO getInstance(){
		if (instance==null){
			instance = new ProfDAO();
		}
		return instance;
	}
	private ProfDAO() {
		super();
	}
	@Override
	public boolean create(Prof prof) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE;
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				prof.setNumero(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Prof prof) {
		boolean succes = true;
		try {
			int id = prof.getNumProf();
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
	public boolean update(Prof obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Prof read(int id) {
		Prof prof = null;
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
				
				prof = new Prof (id);
				//donnees.put(id);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return prof;

	}
	public void afficheSelectEtoileEleve() {
		System.out.println("TODO");

	}
	public List<Prof> readTable() {
		List<Prof> rep = new ArrayList<Prof>();
		Prof prof = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				prof = ProfDAO.getInstance().read(id);
				rep.add(prof);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}
	
}

