package erreur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.Connexion;
import dao.DAO;



public class AppartenanceDAO extends DAO<Appartenance> {

	private static final String TABLE = "Appartenance";
	private static final String CLE_PRIMAIRE = "num_eleve";
	private static final String CLE_PRIMAIRE2 = "num_promotion";

	private static AppartenanceDAO instance=null;
	public static AppartenanceDAO getInstance(){
		if (instance==null){
			instance = new AppartenanceDAO();
		}
		return instance;
	}
	private AppartenanceDAO() {
		super();
	}
	@Override
	public boolean create(Appartenance appartenance) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE;
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				appartenance.setNumero(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Appartenance appartenance) {
		boolean succes = true;
		try {
			int id = appartenance.getNum_eleve();
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
	public boolean update(Appartenance obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/*
	@Override
	//public Appartenance read(int id) {
		// utilisateur = null;
		/*if (donnees.containsKey(id)) {
			System.out.println("récupéré");
			utilisateur=donnees.get(id);
		}
		else {*/
			//System.out.println("recherché dans la BD");
			//try {



				//String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				//ResultSet rs = Connexion.executeQuery(requete);
				//rs.next();
				
				//appartenance = new Appartenance (id);
				//donnees.put(id, utilisateur);
			//} catch (SQLException e) {
				//e.printStackTrace();
			//}
		//}
		//return appartenance;

	//}
	public void afficheSelectEtoileAppartenance() {
		System.out.println("TODO");

	}
	public List<Appartenance> readTable() {
		List<Appartenance> rep = new ArrayList<Appartenance>();
		Appartenance appartenance = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				appartenance = AppartenanceDAO.getInstance().read(id);
				rep.add(appartenance);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}
	@Override
	public Appartenance read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
