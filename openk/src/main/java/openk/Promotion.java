package openk;

import java.time.LocalDateTime;

public class Promotion {
	
	private int num_promotion;
	private int num_formation;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin;

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
