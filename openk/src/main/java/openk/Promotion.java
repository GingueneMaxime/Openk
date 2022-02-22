package openk;

import java.time.LocalDateTime;

public class Promotion {
	
	private int numPromotion;
	private int numFormation;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	
	public Promotion(int numPromotion, int numFormation, LocalDateTime dateDebut, LocalDateTime dateFin) {
		super();
		this.numPromotion = numPromotion;
		this.numFormation = numFormation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public Promotion(int id, String num_formation2, String date_debut2, String date_fin2) {
		// TODO Auto-generated constructor stub
	}
	public int getNumPromotion() {
		return numPromotion;
	}
	public void setNumPromotion(int numPromotion) {
		this.numPromotion = numPromotion;
	}
	public int getNumFormation() {
		return numFormation;
	}
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	public LocalDateTime getDateFin() {
		return dateFin;
	}
	@Override
	public String toString() {
		return "Promotion [numPromotion=" + numPromotion + ", numFormation=" + numFormation + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + "]";
	}
	
}
