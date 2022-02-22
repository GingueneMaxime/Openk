package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import openk.Batiment;

public class BatimentDAO extends DAO<Batiment>{

	private static final String TABLE = "Batiment";
	private static final String CLE_PRIMAIRE = "numBatiment";
	private static final String NOM = "nom";
	private static final String ADRESSE= "adresse";

	private static BatimentDAO instance=null;
	public static BatimentDAO getInstance(){
		if (instance==null){
			instance = new BatimentDAO();
		}
		return instance;
	}
	private BatimentDAO() {
		super();
	}
	@Override
	public boolean create(Batiment batiment) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NOM+", "+ADRESSE+") VALUES (?, ?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, batiment.getNom());
			pst.setString(2, batiment.getAdresse());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				batiment.setNumBatiment(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Batiment batiment) {
		boolean succes = true;
		try {
			int id = batiment.getNumBatiment();
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
	public boolean update(Batiment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Batiment read(int id) {
		Batiment batiment = null;
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
				String nom = rs.getString(NOM);
				String adresse = rs.getString(ADRESSE);
				batiment = new Batiment (id, nom, adresse);
				//donnees.put(id, utilisateur);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return batiment;

	}
	public void afficheSelectEtoileBatiment() {
		System.out.println("TODO");

	}
	public List<Batiment> readTable() {
		List<Batiment> rep = new ArrayList<Batiment>();
		Batiment batiment = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				batiment = BatimentDAO.getInstance().read(id);
				rep.add(batiment);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

	
}
