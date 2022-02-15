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
	private static final String NUM_FORMATION = "num_formation";
	private static final String DATE_DEBUT= "date_debut";
	private static final String DATE_FIN= "date_fin";

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
			pst.setInt(1, promotion.getNum_formation());
			pst.setObject(2, promotion.getDate_debut());
			pst.setObject(3, promotion.getDate_fin());
			pst.executeUpdate();
			//Récupérer la clé qui a été générée et la pousser dans l'objet initial
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				promotion.setNum_promotion(rs.getInt(1));
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
			int id = promotion.getNum_promotion();
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
	public boolean update(Promotion obj) {
		// TODO Auto-generated method stub
		return false;
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
				String num_formation = rs.getString(NUM_FORMATION);
				String date_debut = rs.getString(DATE_DEBUT);
				String date_fin=rs.getString(DATE_FIN);
				promotion = new Promotion (id, num_formation, date_debut,date_fin);
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
