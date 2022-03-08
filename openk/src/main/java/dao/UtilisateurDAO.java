package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openk.Adresse;


public class UtilisateurDAO extends DAO<Adresse> {

	private static final String TABLE = "Utilisateur";
	private static final String CLE_PRIMAIRE = "num_utilisateur";

	private static final String NOM = "nom";
	private static final String PRENOM= "prenom";
	private static final String MAIL = "mail";
	private static final String TEL = "tel";
	private static final String MOT_DE_PASSE = "motDePasse";

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
	public boolean create(Adresse utilisateur) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NOM+", "+PRENOM+", "+MAIL+","+TEL+","+MOT_DE_PASSE+") VALUES (?, ?, ?,?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, utilisateur.getNom());
			pst.setString(2, utilisateur.getPrenom());
			pst.setString(3, utilisateur.getMail());
			pst.setString(4, utilisateur.getTel());
			pst.setString(5, utilisateur.getmotDePasse());
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
	public boolean delete(Adresse utilisateur) {
		boolean succes = true;
		try {
			int id = utilisateur.getNumUtilisateur();
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
	public boolean update(Adresse utilisateur) {
		boolean succes = true;
		try {
			
			String requete = "UPDATE "+TABLE+" SET "+NOM+" =?, "+PRENOM+" =?,"+MAIL+" =?, "+TEL+" =?,"+MOT_DE_PASSE+" =?  WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1, utilisateur.getNom());
			pst.setString(2, utilisateur.getPrenom());
			pst.setString(3, utilisateur.getMail());
			pst.setString(4, utilisateur.getTel());
			pst.setString(5, utilisateur.getmotDePasse());
			pst.setInt(6, utilisateur.getNumUtilisateur());
			pst.executeUpdate();;
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public Adresse read(int id) {
		Adresse utilisateur = null;
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
				String tel = rs.getString(TEL);
				String motDePasse = rs.getString(MOT_DE_PASSE);
				utilisateur = new Adresse (id, nom, prenom, mail, tel, motDePasse);
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
	public List<Adresse> readTable() {
		List<Adresse> rep = new ArrayList<Adresse>();
		Adresse utilisateur = null;
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

