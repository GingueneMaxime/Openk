package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openk.Admin;



public class AdminDAO extends DAO<Admin> {

	private static final String TABLE = "Admin";
	private static final String CLE_PRIMAIRE = "num_admin";

	

	private static AdminDAO instance=null;
	public static AdminDAO getInstance(){
		if (instance==null){
			instance = new AdminDAO();
		}
		return instance;
	}
	private AdminDAO() {
		super();
	}
	@Override
	public boolean create(Admin admin) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE;
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				admin.setNumero(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Admin admin) {
		boolean succes = true;
		try {
			int id = admin.getNum_Admin();
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
	public boolean update(Admin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin read(int id) {
		Admin admin = null;
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
				
				admin = new Admin (id);
				//donnees.put(id);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return admin;

	}
	public void afficheSelectEtoileUtilisateur() {
		System.out.println("TODO");

	}
	public List<Admin> readTable() {
		List<Admin> rep = new ArrayList<Admin>();
		Admin admin = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				admin = AdminDAO.getInstance().read(id);
				rep.add(admin);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

}
