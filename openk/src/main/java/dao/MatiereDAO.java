package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openk.Matiere;


public class MatiereDAO extends DAO<Matiere> {

	private static final String TABLE = "Matiere";
	private static final String CLE_PRIMAIRE = "num_matiere";

	private static final String NOM = "nom";
	

	private static MatiereDAO instance=null;
	public static MatiereDAO getInstance(){
		if (instance==null){
			instance = new MatiereDAO();
		}
		return instance;
	}
	private MatiereDAO() {
		super();
	}
	@Override
	public boolean create(Matiere matiere) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NOM+") VALUES (?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, matiere.getNom());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				matiere.setNumero(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Matiere matiere) {
		boolean succes = true;
		try {
			int id = matiere.getNumMatiere();
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
	public boolean update(Matiere matiere) {
		boolean succes = true;
		try {
			
			String requete = "UPDATE "+TABLE+" SET "+NOM+" =?  WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, matiere.getNom());
			pst.setInt(2, matiere.getNumMatiere());
			pst.executeUpdate();;
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public Matiere read(int id) {
		Matiere matiere = null;
		/*if (donnees.containsKey(id)) {
			System.out.println("récupéré");
			matiere=donnees.get(id);
		}
		else {*/
			System.out.println("recherché dans la BD");
			try {



				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				String nom = rs.getString(NOM);
				matiere = new Matiere (id, nom);
				//donnees.put(id, matiere);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return matiere;

	}
	public void afficheSelectEtoileMatiere() {
		System.out.println("TODO");

	}
	public List<Matiere> readTable() {
		List<Matiere> rep = new ArrayList<Matiere>();
		Matiere matiere = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				matiere = MatiereDAO.getInstance().read(id);
				rep.add(matiere);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

}

