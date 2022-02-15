package openk;

import java.time.LocalDateTime;

public class Promotion {
	
	private int num_promotion;
	private int num_formation;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin;
	
	public Promotion(int num_promotion, int num_formation, LocalDateTime date_debut, LocalDateTime date_fin) {
		super();
		this.num_promotion = num_promotion;
		this.num_formation = num_formation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Promotion(int id, String num_formation2, String date_debut2, String date_fin2) {
		// TODO Auto-generated constructor stub
	}
	public int getNum_promotion() {
		return num_promotion;
	}
	public void setNum_promotion(int num_promotion) {
		this.num_promotion = num_promotion;
	}
	public int getNum_formation() {
		return num_formation;
	}
	public LocalDateTime getDate_debut() {
		return date_debut;
	}
	public LocalDateTime getDate_fin() {
		return date_fin;
	}
	@Override
	public String toString() {
		return "Promotion [num_promotion=" + num_promotion + ", num_formation=" + num_formation + ", date_debut="
				+ date_debut + ", date_fin=" + date_fin + "]";
	}
	
}
