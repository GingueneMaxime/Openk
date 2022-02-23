package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openk.Salle;




public class SalleDAO extends DAO<Salle> {

	private static final String TABLE = "Salle";
	private static final String CLE_PRIMAIRE = "num_salle";

	private static final String NUM_BATIMENT = "numBatiment";
	private static final String NOM= "nom";
	private static final String EQUIPEMENT_VIRTUEL= "equipementVirtuel";
	private static final String NB_PLACES = "nbPlaces";
	

	private static SalleDAO instance=null;
	public static SalleDAO getInstance(){
		if (instance==null){
			instance = new SalleDAO();
		}
		return instance;
	}
	private SalleDAO() {
		super();
	}
	@Override
	public boolean create(Salle salle) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NUM_BATIMENT+", "+NOM+","+EQUIPEMENT_VIRTUEL+","+NB_PLACES+") VALUES (?, ?, ?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, salle.getNumBatiment());
			pst.setString(2, salle.getNom());
			pst.setString(3, salle.getEquipementVirtuel());
			pst.setInt(4, salle.getNbPlaces());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				salle.setNumero(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Salle salle) {
		boolean succes = true;
		try {
			int id = salle.getNumSalle();
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
	public boolean update(Salle salle) {
		boolean succes = true;
		try {
			
			String requete = "UPDATE "+TABLE+" SET "+NUM_BATIMENT+" =?, "+NOM+" =?,"+EQUIPEMENT_VIRTUEL+" =?, "+NB_PLACES+" =?  WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, salle.getNumBatiment());
			pst.setString(2, salle.getNom());
			pst.setString(3, salle.getEquipementVirtuel());
			pst.setInt(4, salle.getNbPlaces());
			pst.setInt(5, salle.getNumSalle());
			pst.executeUpdate();;
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public Salle read(int id) {
		Salle salle = null;
		/*if (donnees.containsKey(id)) {
			System.out.println("récupéré");
			salle=donnees.get(id);
		}
		else {*/
			System.out.println("recherché dans la BD");
			try {



				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				int numBatiment = rs.getInt(NUM_BATIMENT);
				String nom = rs.getString(NOM);
				String equipementVirtuel = rs.getString(EQUIPEMENT_VIRTUEL);
				int nbPlaces = rs.getInt(NB_PLACES);
				salle = new Salle (id,numBatiment , nom, equipementVirtuel,nbPlaces );
				//donnees.put(id, salle);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return salle;

	}
	public void afficheSelectEtoileSalle() {
		System.out.println("TODO");

	}
	public List<Salle> readTable() {
		List<Salle> rep = new ArrayList<Salle>();
		Salle salle = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				salle = SalleDAO.getInstance().read(id);
				rep.add(salle);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

}

