package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openk.Formation;




public class FormationDAO extends DAO<Formation> {

	private static final String TABLE = "Formation";
	private static final String CLE_PRIMAIRE = "num_formation";

	private static final String NOM = "nom";
	private static final String CERTIF_OU_DIPLOME = "certif_ou_diplome";

	private static FormationDAO instance=null;
	public static FormationDAO getInstance(){
		if (instance==null){
			instance = new FormationDAO();
		}
		return instance;
	}
	private FormationDAO() {
		super();
	}
	@Override
	public boolean create(Formation formation) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NOM+","+CERTIF_OU_DIPLOME+ ") VALUES (?, ?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, formation.getNom());
			pst.setString(2, formation.getCertif_ou_diplome());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				formation.setNumero(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Formation formation) {
		boolean succes = true;
		try {
			int id = formation.getNum_formation();
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
	public boolean update(Formation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Formation read(int id) {
		Formation formation = null;
		/*if (donnees.containsKey(id)) {
			System.out.println("récupéré");
			formation=donnees.get(id);
		}
		else {*/
			System.out.println("recherché dans la BD");
			try {



				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				String nom = rs.getString(NOM);
				String certif_ou_diplome = rs.getString(CERTIF_OU_DIPLOME);
				formation = new Formation (id, nom, certif_ou_diplome);
				//donnees.put(id, formation);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return formation;

	}
	public void afficheSelectEtoileFormation() {
		System.out.println("TODO");

	}
	public List<Formation> readTable() {
		List<Formation> rep = new ArrayList<Formation>();
		Formation formation = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				formation = FormationDAO.getInstance().read(id);
				rep.add(formation);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

}

