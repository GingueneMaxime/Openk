package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import openk.Seance;

public class SeanceDAO extends DAO<Seance>{

	private static final String TABLE = "Seance";
	private static final String CLE_PRIMAIRE = "num_seance";
	private static final String NUM_COURS = "numCours";
	private static final String NUM_SALLE = "numSalle";
	private static final String DATE_DEBUT= "dateDebut";
	private static final String DATE_FIN= "dateFin";

	private static SeanceDAO instance=null;
	public static SeanceDAO getInstance(){
		if (instance==null){
			instance = new SeanceDAO();
		}
		return instance;
	}
	private SeanceDAO() {
		super();
	}
	@Override
	public boolean create(Seance seance) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NUM_COURS+"+"+NUM_SALLE+", "+DATE_DEBUT+","+DATE_FIN+") VALUES (?, ?, ?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, seance.getNumCours());
			pst.setInt(2, seance.getNumSalle());
			pst.setObject(3, seance.getDateDebut());
			pst.setObject(4, seance.getDateFin());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				seance.setNumSeance(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Seance seance) {
		boolean succes = true;
		try {
			int id = seance.getNumSeance();
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
	public boolean update(Seance seance) {
		boolean succes = true;
		try {
			
			String requete = "UPDATE "+TABLE+" SET "+NUM_COURS+" =?, "+NUM_SALLE+" =?,"+DATE_DEBUT+" =?, "+DATE_FIN+" =?  WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, seance.getNumCours());
			pst.setInt(2, seance.getNumSalle());
			pst.setObject(3, seance.getDateDebut());
			pst.setObject(4, seance.getDateFin());
			pst.setInt(5, seance.getNumSeance());
			pst.executeUpdate();;
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public Seance read(int id) {
		Seance seance = null;
		/*if (donnees.containsKey(id)) {
			System.out.println("récupéré");
			seance=donnees.get(id);
		}
		else {*/
			System.out.println("recherché dans la BD");
			try {



				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				int numCours = rs.getInt(NUM_COURS);
				int numSalle = rs.getInt(NUM_SALLE);
				LocalDateTime dateDebut = (LocalDateTime) rs.getObject(DATE_DEBUT);
				LocalDateTime dateFin = (LocalDateTime) rs.getObject(DATE_FIN);
				seance = new Seance (id,numCours, numSalle, dateDebut,dateFin);
				//donnees.put(id, promotion);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return seance;

	}
	public void afficheSelectEtoilePromotion() {
		System.out.println("TODO");

	}
	public List<Seance> readTable() {
		List<Seance> rep = new ArrayList<Seance>();
		Seance seance = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				seance = SeanceDAO.getInstance().read(id);
				rep.add(seance);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

	//finalisée
	
}
