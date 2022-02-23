package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import openk.Promotion;

public class PromotionDAO extends DAO<Promotion>{

	private static final String TABLE = "Promotion";
	private static final String CLE_PRIMAIRE = "num_promotion";
	private static final String NUM_FORMATION = "numFormation";
	private static final String DATE_DEBUT= "dateDebut";
	private static final String DATE_FIN= "dateFin";

	private static PromotionDAO instance=null;
	public static PromotionDAO getInstance(){
		if (instance==null){
			instance = new PromotionDAO();
		}
		return instance;
	}
	private PromotionDAO() {
		super();
	}
	@Override
	public boolean create(Promotion promotion) {
		boolean succes=true;
		try {
			String requete = "INSERT INTO "+TABLE+" ("+NUM_FORMATION+", "+DATE_DEBUT+","+DATE_FIN+") VALUES (?, ?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, promotion.getNumFormation());
			pst.setObject(2, promotion.getDateDebut());
			pst.setObject(3, promotion.getDateFin());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				promotion.setNumPromotion(rs.getInt(1));
			}
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public boolean delete(Promotion promotion) {
		boolean succes = true;
		try {
			int id = promotion.getNumPromotion();
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
	public boolean update(Promotion promotion) {
		boolean succes = true;
		try {
			
			String requete = "UPDATE "+TABLE+" SET "+NUM_FORMATION+" =?, "+DATE_DEBUT+" =?,"+DATE_FIN+" =?  WHERE "+CLE_PRIMAIRE+" = ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1, promotion.getNumFormation());
			pst.setObject(2, promotion.getDateDebut());
			pst.setObject(3, promotion.getDateFin());
			pst.setInt(4, promotion.getNumPromotion());
			pst.executeUpdate();;
		} catch (SQLException e) {
			succes=false;
			e.printStackTrace();
		}
		return succes;
	}

	@Override
	public Promotion read(int id) {
		Promotion promotion = null;
		/*if (donnees.containsKey(id)) {
			System.out.println("récupéré");
			promotion=donnees.get(id);
		}
		else {*/
			System.out.println("recherché dans la BD");
			try {



				String requete = "SELECT * FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
				ResultSet rs = Connexion.executeQuery(requete);
				rs.next();
				String numFormation = rs.getString(NUM_FORMATION);
				String dateDebut = rs.getString(DATE_DEBUT);
				String dateFin=rs.getString(DATE_FIN);
				promotion = new Promotion (id, numFormation, dateDebut,dateFin);
				//donnees.put(id, promotion);
			} catch (SQLException e) {
				//e.printStackTrace();
			}
		//}
		return promotion;

	}
	public void afficheSelectEtoilePromotion() {
		System.out.println("TODO");

	}
	public List<Promotion> readTable() {
		List<Promotion> rep = new ArrayList<Promotion>();
		Promotion promotion = null;
		try{
			String requete = "SELECT "+CLE_PRIMAIRE+" FROM "+TABLE;
			ResultSet res = Connexion.executeQuery(requete) ;
			while(res.next()){
				int id = res.getInt(1);
				promotion = PromotionDAO.getInstance().read(id);
				rep.add(promotion);
			}
		}
		catch(SQLException e){
			System.out.println("Echec de la tentative d'interrogation Select * : " + e.getMessage()) ;
		}
		return rep;
	}

	
}
