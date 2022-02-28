package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openk.Eleve;



public class EleveDAO extends DAO<Eleve> {

	private static final String TABLE = "Eleve";
	private static final String CLE_PRIMAIRE = "num_eleve";

	

	private static EleveDAO instance=null;
	public static EleveDAO getInstance(){
		if (instance==null){
			instance = new EleveDAO();
		}
		return instance;
	}
	private EleveDAO() {
		super();
	}
	@Override
	public boolean create(Eleve eleve) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE;
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				eleve.setNumero(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Eleve eleve) {
		boolean succes = true;
		try {
			int id = eleve.getNumEleve();
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
	public boolean update(Eleve obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Eleve read(int id) {
		Eleve eleve = null;
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
				
				eleve = new Eleve (id);
				//donnees.put(id);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return eleve;

	}
	public void afficheSelectEtoileEleve() {
		System.out.println("TODO");

	}
	public List<Eleve> readTable() {
		List<Eleve> rep = new ArrayList<Eleve>();
		Eleve eleve = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				eleve = EleveDAO.getInstance().read(id);
				rep.add(eleve);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}
	
}

