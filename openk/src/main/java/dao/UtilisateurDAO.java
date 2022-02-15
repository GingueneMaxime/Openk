package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openk.Utilisateur;


public class UtilisateurDAO extends DAO<Utilisateur> {

	private static final String TABLE = "Utilisateur";
	private static final String CLE_PRIMAIRE = "num_utilisateur";

	private static final String NOM = "nom";
	private static final String PRENOM= "prenom";
	private static final String MAIL = "mail";
	private static final String TEL = "tel";

	private static UtilisateurDAO instance=null;
	public static UtilisateurDAO getInstance(){
		if (instance==null){
			instance = new UtilisateurDAO();
		}
		return instance;
	}
	private UtilisateurDAO() {
		super();
	}
	@Override
	public boolean create(Utilisateur utilisateur) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NOM+", "+PRENOM+", "+MAIL+","+TEL+") VALUES (?, ?, ?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, utilisateur.getNom());
			pst.setString(2, utilisateur.getPrenom());
			pst.setString(3, utilisateur.getMail());
			pst.setInt(4, utilisateur.getTel());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNumero(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Utilisateur utilisateur) {
		boolean succes = true;
		try {
			int id = utilisateur.getNum_utilisateur();
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
	public boolean update(Utilisateur utilisateur) {
		boolean succes = true;
		try {
			
			String requete = "UPDATE FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, utilisateur.getNom());
			pst.setString(2, utilisateur.getPrenom());
			pst.setString(3, utilisateur.getMail());
			pst.setInt(4, utilisateur.getTel());
			pst.executeUpdate();;
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public Utilisateur read(int id) {
		Utilisateur utilisateur = null;
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
				String prenom = rs.getString(PRENOM);
				String mail = rs.getString(MAIL);
				int tel = rs.getInt(TEL);
				utilisateur = new Utilisateur (id, nom, prenom, mail, tel);
				//donnees.put(id, utilisateur);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return utilisateur;

	}
	public void afficheSelectEtoileUtilisateur() {
		System.out.println("TODO");

	}
	public List<Utilisateur> readTable() {
		List<Utilisateur> rep = new ArrayList<Utilisateur>();
		Utilisateur utilisateur = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				utilisateur = UtilisateurDAO.getInstance().read(id);
				rep.add(utilisateur);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

}

